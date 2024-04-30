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

    private ProductType type;
    private String name;
    private Long currentBalance;
    private String email;
//    private List<WithdrawalNotice> notices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
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