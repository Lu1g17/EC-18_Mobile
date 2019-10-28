package com.example.home.Entity;


import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Admin")

public class AdminEntity {

    private String email, password;

    public AdminEntity() {
        //setEmail(email);
        //setPassword(password);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
