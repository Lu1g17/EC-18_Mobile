package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import static com.example.home.Boundary.MainActivity.dynamoDBMapper;

@DynamoDBTable(tableName = "ShoppingCart")
public class ShoppingCartEntity {

    private String fiscalCode, code;


    public ShoppingCartEntity(String fiscalCode, String code) {
        this.fiscalCode = fiscalCode;
        this.code = code;
    }

    @DynamoDBHashKey(attributeName = "FiscalCode")
    @DynamoDBAttribute(attributeName = "FiscalCode")
    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    @DynamoDBAttribute(attributeName = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean add() {
        final ShoppingCartEntity shoppingCart = this;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dynamoDBMapper.save(shoppingCart);
            }
        });

        t.start();

        try {
            t.join();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
