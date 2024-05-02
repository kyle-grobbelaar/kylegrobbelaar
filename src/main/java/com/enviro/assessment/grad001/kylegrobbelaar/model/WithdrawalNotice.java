package com.enviro.assessment.grad001.kylegrobbelaar.model;

//import jakarta.persistence.*;
//import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Special object that stores the withdrawal notice product information,
 * special message related to URI request
 */
@Entity
@Table( name = "Withdraws" )
public class WithdrawalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "MESSAGE" )
    private String message;
    @Column( name = "PRODUCT_ID" )
    private Long productId;
    @Column( name = "TYPE" )
    @Enumerated( EnumType.STRING )
    private ProductType Type;
    @Column( name = "EMAIL" )
    private String email;
    @Column( name = "NEW_BALANCE" )
    private Long newBalance;
    @Column( name = "DATE_CREATED" )
    private LocalDate dateCreated;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductType getProductType() {
        return Type;
    }

    public void setProductType(ProductType productType) {
        this.Type = productType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Long getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Long newBalance) {
        this.newBalance = newBalance;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
