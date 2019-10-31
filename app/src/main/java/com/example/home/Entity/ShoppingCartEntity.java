package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.example.home.Boundary.MainActivity.dynamoDBMapper;

@DynamoDBTable(tableName = "ShoppingCart")
public class ShoppingCartEntity {

    private String fiscalCode, articleCode;
    private Integer quantity = new Integer(1);


    public ShoppingCartEntity(String fiscalCode, String articleCode) {
        this.fiscalCode = fiscalCode;
        this.articleCode = articleCode;
    }

    @DynamoDBHashKey(attributeName = "FiscalCode")
    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    @DynamoDBRangeKey(attributeName = "ArticleCode")
    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    @DynamoDBAttribute(attributeName = "Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ShoppingCartEntity clone() {
        ShoppingCartEntity clone = new ShoppingCartEntity(this.fiscalCode, this.articleCode);

        return clone;
    }
    public boolean add() {
        final ShoppingCartEntity shoppingCart = this.clone();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
                eav.put(":val1", new AttributeValue().withS(shoppingCart.getFiscalCode()));
                eav.put(":val2", new AttributeValue().withS(shoppingCart.getArticleCode()));

                DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("FiscalCode = :val1 and ArticleCode = :val2").withExpressionAttributeValues(eav);
                List<ShoppingCartEntity> lista = dynamoDBMapper.parallelScan(ShoppingCartEntity.class, scanExpression, 16);

                Iterator<ShoppingCartEntity> iteratore = lista.iterator();
                if (iteratore.hasNext()) {
                    ShoppingCartEntity item = iteratore.next();
                    shoppingCart.setQuantity(new Integer(Integer.valueOf(item.getQuantity() + 1)));

                    dynamoDBMapper.save(shoppingCart);
                } else {
                    shoppingCart.setQuantity(new Integer(1));

                    dynamoDBMapper.save(shoppingCart);
                }
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
