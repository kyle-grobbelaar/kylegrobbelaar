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

    @GetMapping("/login")
    public ResponseEntity<Person> savePerson() {
        Person person = new Person();
        person.setName( "Kyle" );
        person.setEmail( "grobb@gmail.com" );
        System.out.println();
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{name}/investments")
    public ResponseEntity<List<Product>> getInvestmentsByName (@PathVariable String name ) {
        return ResponseEntity.ok(userService.getAllProductsByName( name ));
    }

    @GetMapping("/investment/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable String id) {
        return ResponseEntity.ok(userService.findEntityById( Long.valueOf( id ) ));
    }

    @GetMapping("/investors")
    public ResponseEntity<List<Person>> getAllInvestors() {
        return ResponseEntity.ok(userService.findAllPersons());
    }

    @GetMapping("investor/name={name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findPersonByName( name ));
    }

    @GetMapping("investor/id={id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        Person p = userService.findPersonById( Long.valueOf( id ));
        if (p == null) {
            System.out.println("Not Such Person");
            return ResponseEntity.ok( null );
        }
        else { return ResponseEntity.ok( p ); }
    }

    @GetMapping("investor/email={email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findPersonByEmail( email ));
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
        if (!userService.isValidWithdrawAmount( p, Long.valueOf( withdrawAmount ) )) {
            notice.setMessage( "Withdraw amount exceeds 90% of total current balance." );
            userService.saveNotice( notice );
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body( notice );
        }
        else{
            notice.setMessage( withdrawAmount + " successfully withdrawn from product." );
            userService.doWithdrawAmount( p, Long.valueOf(withdrawAmount) );
            userService.saveNotice( notice );
            return ResponseEntity.ok( notice );
        }
    }

}
