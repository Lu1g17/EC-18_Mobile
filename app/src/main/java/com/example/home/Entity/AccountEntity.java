package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Account")
public class AccountEntity {
    private String fiscalCode, email, password;

    public AccountEntity() {
        fiscalCode = null;
        email = null;
        password = null;
    }

    @DynamoDBHashKey(attributeName = "FiscalCode")
    @DynamoDBAttribute(attributeName = "FiscalCode")
    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        if (fiscalCode == null)
            this.fiscalCode = "Non definito";
        else
            this.fiscalCode = fiscalCode;
    }

    public AccountEntity(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    @DynamoDBAttribute(attributeName = "Email") //E' un campo di account non di user
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null)
            this.email = "Non definito";
        else
            this.email = email;
    }

    @DynamoDBAttribute(attributeName = "Password") //E' un campo di account non di user
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null)
            this.password = "Non definito";
        else
            this.password = password;
    }
}
