package com.helperproject.interestservice.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class UserInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;
    @Column(unique = true)
    private String username;
    private String interest;


    public UserInterest(String username, String interest) {
        this.username = username;
        this.interest = interest;
    }

    public UserInterest() {
    }

    public void setInterest(String interest){
        this.interest = interest;
    }
}
