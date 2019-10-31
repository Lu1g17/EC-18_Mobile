package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Account")
public class AccountEntity {
    private String fiscalCode, email, password, tipo;

    public AccountEntity() {
        fiscalCode = null;
        email = null;
        password = null;
        tipo = null;
    }

    public AccountEntity(String fiscalCode, String email, String password, String tipo) {
        setFiscalCode(fiscalCode);
        setEmail(email);
        setPassword(password);
        setTipo(tipo);
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

    @DynamoDBAttribute(attributeName = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null)
            this.email = "Non definito";
        else
            this.email = email;
    }

    @DynamoDBAttribute(attributeName = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null)
            this.password = "Non definito";
        else
            this.password = password;
    }

    @DynamoDBAttribute(attributeName = "Type") //E' un campo di account non di user
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null)
            this.tipo = "Non definito";
        else
            this.tipo = tipo;
    }
}
