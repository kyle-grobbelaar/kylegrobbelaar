package com.enviro.assessment.grad001.kylegrobbelaar.controller;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Person;
import com.enviro.assessment.grad001.kylegrobbelaar.model.Product;
import com.enviro.assessment.grad001.kylegrobbelaar.model.ProductType;
import com.enviro.assessment.grad001.kylegrobbelaar.model.WithdrawalNotice;
import com.enviro.assessment.grad001.kylegrobbelaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class RestApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> getLoginInformation ( @RequestParam String name,
                                                        @RequestParam String email,
                                                        @RequestParam String contact,
                                                        @RequestParam String age) {
        Person person = new Person();
        person.setName( name );
        person.setEmail( email );
        person.setContact( contact );
        person.setAge( Long.valueOf( age ) );

        userService.savePersonToDAO( person );

        return ResponseEntity.ok( "Logged in!" );
    }

    /**
     * Retireve all products/investments associated with the client
     * @param name
     * @return List<Product>
     */
    @GetMapping("/{name}/investments")
    public ResponseEntity<List<Product>> getInvestmentsByName (@PathVariable String name ) {
        return ResponseEntity.ok(userService.getAllProductsByName( name ));
    }

    /**
     * Retrieve a specific product based on an id
     * @param id
     * @return Product/null
     */
    @GetMapping("/investment/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable String id) {
        Product product = userService.findEntityById( Long.valueOf( id ) );
        if (product == null){
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( product );
        }
        else{
            return ResponseEntity.ok(userService.findEntityById( Long.valueOf( id ) ));
        }
    }

    /**
     * Retrieves a list of all investors
     * @return List
     */
    @GetMapping("/investors")
    public ResponseEntity<List<Person>> getAllInvestors() {
        return ResponseEntity.ok(userService.findAllPersons());
    }

    /**
     * Retrieve investor information
     * @param name
     * @return Person
     */
    @GetMapping("/investor/name={name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String name) {
        Person p = userService.findPersonByName( name );
        if (p == null) {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( null );
        }
        else { return ResponseEntity.ok( p ); }
    }

    /**
     * Retrieve investor information
     * @param id
     * @return Person
     */
    @GetMapping("/investor/id={id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        Person p = userService.findPersonById( Long.valueOf( id ));
        if (p == null) {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( null );
        }
        else { return ResponseEntity.ok( p ); }
    }

    /**
     * Retrieve investor information
     * @param email
     * @return Person
     */
    @GetMapping("/investor/email={email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email) {
        Person p = userService.findPersonByEmail( email );
        if (p == null) {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( null );
        }
        else { return ResponseEntity.ok( p ); }
    }

    /**
     * This method presumes that a product does exist
     * @param id - the id of an existing Product
     * @param withdrawAmount - Amount to reduce the products current balance
     * @return - return a message
     */
    // TODO: 20/01/2024 make post request test
    @PostMapping("/withdraw/{id}")
    public ResponseEntity<WithdrawalNotice> makeWithdrawNotice(@PathVariable String id,
                                                               @RequestParam String withdrawAmount) {
        WithdrawalNotice notice = new WithdrawalNotice();
        Product p = userService.findEntityById( Long.valueOf( id ));

        notice.setEmail(p.getEmail() );
        notice.setProductId( p.getId() );
        notice.setProductType( p.getType() );

        if (p.getType() == ProductType.RETIREMENT && !userService.isPersonRetired(p.getEmail())) {
            notice.setMessage( "You must be 65 years or older to withdraw from this product" );
            userService.saveNotice( notice );
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body( notice );
        }
        else if (!userService.isValidWithdrawAmount( p, Long.valueOf( withdrawAmount ) )) {
            notice.setMessage( "Withdraw amount exceeds 90% of total current balance." );
            userService.saveNotice( notice );
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body( notice );
        }
        else if (userService.isAmountOverBalance( p, Long.valueOf( withdrawAmount))) {
            notice.setMessage( "Withdraw amount exceeds current balance held within product." );
            userService.saveNotice( notice );
            return ResponseEntity.status( HttpStatus.FORBIDDEN ).body( notice );
        }
        else{
            notice.setMessage( withdrawAmount + " successfully withdrawn from product." );
            userService.doWithdrawAmount( p, Long.valueOf(withdrawAmount) );
            userService.saveNotice( notice );
            return ResponseEntity.ok( notice );
        }
    }

}
