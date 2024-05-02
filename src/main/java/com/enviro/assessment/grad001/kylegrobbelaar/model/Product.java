package com.enviro.assessment.grad001.kylegrobbelaar.model;

import javax.persistence.*;

import java.lang.annotation.Target;
import java.util.List;

@Entity
@Table( name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "TYPE" )
    @Enumerated( EnumType.STRING )
    private ProductType Type;
    @Column( name = "NAME" )
    private String name;
    @Column( name = "CURRENT_BALANCE" )
    private Long currentBalance;
    @Column( name = "EMAIL" )
    private String email;
//    private List<WithdrawalNotice> notices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getType() {
        return Type;
    }

    public void setType(ProductType type) {
        this.Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<WithdrawalNotice> getNotices() {
//        return notices;
//    }

//    public void appendNotice ( WithdrawalNotice notice ){
//        notices.add( notice );
//    }
}