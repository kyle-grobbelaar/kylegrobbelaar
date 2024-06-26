package com.enviro.assessment.grad001.kylegrobbelaar.service;

import com.enviro.assessment.grad001.kylegrobbelaar.model.*;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.PersonDAO;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.ProductDAO;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.WithdrawalNoticeDAO;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final ProductDAO productDAO;
    private final PersonDAO personDAO;
    private final WithdrawalNoticeDAO noticeDAO;

    @Autowired
    public UserService (ProductDAO productDAO, PersonDAO personDAO, WithdrawalNoticeDAO noticeDAO) {
        this.productDAO = productDAO;
        this.personDAO = personDAO;
        this.noticeDAO = noticeDAO;
//        mockDemoProductRepo();
//        mockDemoPersonRepo();
    }

    public void savePersonToDAO ( Person person ) {
        List<Person> personList = personDAO.findAll();

        if (!personList.contains( person )){
            personDAO.save( person );
        }

        System.out.println( personDAO.findAll() );
    }

    public Product saveProductEntity( Product testEntity) {
        return productDAO.save( testEntity );
    }

    /**
     * Save a Product
     * @param notice
     */
    public void saveNotice( WithdrawalNotice notice ) {
        noticeDAO.save( notice );
    }

    /**
     * Get all products
     * @return
     */
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    /**
     * Get all products by associated investor name
     * @param name
     * @return
     */
    public List<Product> getAllProductsByName( String name ){
        return productDAO.findAllByName( name );
    }

    /**
     * Get all products by associated investor name
     * @param email
     * @return
     */
    public List<Product> getAllProductsByEmail( String email ){
        return productDAO.findAllByEmail( email );
    }

    /**
     * Find a single Product by its id
     * @param id
     * @return
     */
    public Product findEntityById ( Long id ){
        Optional<Product> optionalProduct = productDAO.findById( id );
        return optionalProduct.orElse(null);
    }

    /**
     * Get all investors
     * @return
     */
    public List<Person> findAllPersons(){
        return personDAO.findAll();
    }

    public Person findPersonByName( String name ){
        Optional<Person> optionalPerson = personDAO.findByName( name );
        return optionalPerson.orElse( null );
    }

    public Person findPersonByEmail( String email ){
        Optional<Person> optionalPerson = personDAO.findByEmail( email );
        return optionalPerson.orElse( null );
    }

    public Person findPersonById( Long id ) {
        Optional<Person> optionalPerson = personDAO.findById(id);
        return optionalPerson.orElse(null);
    }

    /**
     * Check if a person is able to withdraw from a Retirement Product
     * @param email
     * @return
     */
    public boolean isPersonRetired( String email ) {
        Person person = findPersonByEmail( email );
        return person.getAge() >= 65;
    }

    /**
     * Confirm if the withdraw amount is less than 90% of the Product current balance
     * @param product
     * @param amount
     * @return
     */
    public boolean isValidWithdrawAmount( Product product, Long amount ){
        return product.getCurrentBalance()-amount > product.getCurrentBalance()*0.1;
    }

    /**
     *
     * @param product
     * @param amount
     * @return true if current available balance is less than withdraw amount
     */
    public boolean isAmountOverBalance( Product product, Long amount ) {
        return product.getCurrentBalance() < amount;
    }

    public void doWithdrawAmount( Product product, Long amount ){
        product.setCurrentBalance(product.getCurrentBalance() - amount );
        productDAO.save( product );
    }

    /**
     *  Downloads a csv file into the projects filepath
     * @param productId
     */
    public void doDownloadCsv ( Long productId ) {
        List<WithdrawalNotice> noticeList = noticeDAO.findByproductId( productId );

        File file = new File( productId+".csv" );

        try {
            FileWriter outputFile = new FileWriter( file );
            CSVWriter writer = new CSVWriter( outputFile );

            String[] header = {"id", "date", "productId", "type", "newBalance", "message"};
            writer.writeNext(header);

            for (WithdrawalNotice notice : noticeList) {
                String[] data = {
                        notice.getId().toString(),
                        notice.getDateCreated().toString(),
                        notice.getProductId().toString(),
                        notice.getProductType().toString(),
                        notice.getNewBalance().toString(),
                        notice.getMessage()
                };
                writer.writeNext( data );
            }
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * This mocks entries into the Product database
     */
    public void mockDemoProductRepo() {
        Product a = new Product();
        a.setName( "kyle");
        a.setEmail( "kyle@mail.com" );
        a.setType( ProductType.SAVINGS );
        a.setCurrentBalance( Long.valueOf(400) );
        productDAO.save( a );

        Product b = new Product();
        b.setName( "kyle");
        b.setEmail( "kyle@mail.com" );
        b.setType( ProductType.RETIREMENT );
        b.setCurrentBalance( Long.valueOf(800) );
        productDAO.save( b );

        Product c = new Product();
        c.setName( "donny");
        c.setEmail( "donny@mail.com" );
        c.setType( ProductType.SAVINGS );
        c.setCurrentBalance( Long.valueOf(200) );
        productDAO.save( c );

        Product d = new Product();
        d.setName( "mack");
        d.setEmail( "mack@mail.com" );
        d.setType( ProductType.RETIREMENT );
        d.setCurrentBalance( Long.valueOf(300) );
        productDAO.save( d );
    }

    public void mockDemoPersonRepo() {
        Person a = new Person();
        a.setName( "kyle" );
        a.setEmail( "kyle@mail.com" );
        a.setContact("012345456");
        a.setAge(21L);
        personDAO.save( a );

        Person b = new Person();
        b.setName( "donny" );
        b.setEmail( "donny@mail.com" );
        b.setContact("0143565456");
        b.setAge(35L);
        personDAO.save( b );

        Person c = new Person();
        c.setName( "mack" );
        c.setEmail( "mack@mail.com" );
        c.setContact("01234567456");
        c.setAge(78L);
        personDAO.save( c );
    }

}
