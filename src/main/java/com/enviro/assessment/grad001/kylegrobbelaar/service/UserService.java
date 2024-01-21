package com.enviro.assessment.grad001.kylegrobbelaar.service;

import com.enviro.assessment.grad001.kylegrobbelaar.model.*;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.PersonDAO;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.ProductDAO;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.WithdrawalNoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        mockDemoProductRepo();
        mockDemoPersonRepo();
    }

    public Product saveProductEntity( Product testEntity) {
        return productDAO.save( testEntity );
    }
    public void saveNotice( WithdrawalNotice notice ) {
        noticeDAO.save( notice );
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
    public List<Product> getAllProductsByName( String name ){
        return productDAO.findAllByName( name );
    }
    public Product findEntityById ( Long id ){
        Optional<Product> optionalProduct = productDAO.findById( id );
        return optionalProduct.orElse(null);
    }

    public List<Person> findAllPersons(){
        return personDAO.findAll();
    }

    public Person findPersonByName( String name ){
        return personDAO.findByName( name );
    }

    public Person findPersonByEmail( String email ){
        return personDAO.findByEmail( email );
    }

    public Person findPersonById( Long id ) {
        Optional<Person> optionalPerson = personDAO.findById(id);
        return optionalPerson.orElse(null);
    }

    public boolean isPersonRetired( String email ) {
        Person person = personDAO.findByEmail( email );
        return person.getAge() >= 65;
    }

    public boolean isValidWithdrawAmount( Product product, Long amount ){
        return product.getCurrentBalance()-amount > product.getCurrentBalance()*0.1;
    }

    public void doWithdrawAmount( Product product, Long amount ){
        product.setCurrentBalance(product.getCurrentBalance() - amount );
        productDAO.save( product );
    }

//    public void saveWithdrawNotice(Product product, WithdrawalNotice notice) {
////        product.appendNotice( notice );
//        productDAO.save( product );
//    }

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
        a.setAddress("123 road");
        a.setContact("012345456");
        a.setAge(21L);
        personDAO.save( a );

        Person b = new Person();
        b.setName( "donny" );
        b.setEmail( "donny@mail.com" );
        b.setAddress("456 road");
        b.setContact("0143565456");
        b.setAge(35L);
        personDAO.save( b );

        Person c = new Person();
        c.setName( "mack" );
        c.setEmail( "mack@mail.com" );
        c.setAddress("789 road");
        c.setContact("01234567456");
        c.setAge(78L);
        personDAO.save( c );
    }

}
