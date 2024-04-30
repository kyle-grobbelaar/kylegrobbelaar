package com.enviro.assessment.grad001.kylegrobbelaar.model;

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
@Table( name = "Persons")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String contact;

    private Long age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public boolean equals (Object o) {

        if (this.getClass() != o.getClass()) {
            return false;
        }
        Person p = (Person) o;

        if (!this.getName().equalsIgnoreCase(p.getName())) {
            return false;
        } else if (!this.getEmail().equalsIgnoreCase(p.getEmail())) {
            return false;
        } else if (!this.getAge().equals(p.getAge())){
            return false;
        }
        return true;
    }

}
