package com.enviro.assessment.grad001.kylegrobbelaar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ProductType type;
    private String name;
    private Long currentBalance;
    private String email;

}


enum ProductType {
    SAVINGS,
    RETIREMENT
}