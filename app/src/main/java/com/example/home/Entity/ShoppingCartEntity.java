package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.home.Boundary.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.example.home.Boundary.MainActivity.dynamoDBMapper;

@DynamoDBTable(tableName = "ShoppingCart")
public class ShoppingCartEntity {

    private String fiscalCode;
    private String articleCode;
    private String nome;
    Float prezzo;
    private Integer quantity = new Integer(1);

    public ShoppingCartEntity() {
        this.fiscalCode = null;
        this.articleCode = null;
        this.nome = null;
        this.prezzo = null;
    }

    public ShoppingCartEntity(String fiscalCode, String articleCode, String nome, Float prezzo) {
        this.fiscalCode = fiscalCode;
        this.articleCode = articleCode;
        this.nome = nome;
        this.prezzo = prezzo;
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

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return nome;
    }

    public void setName(Integer quantity) {
        this.nome = nome;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public Float getPrice() {
        return prezzo;
    }

    public void setPrice(Integer quantity) {
        this.prezzo = prezzo;
    }

    public ShoppingCartEntity clone() {
        ShoppingCartEntity clone = new ShoppingCartEntity(this.fiscalCode, this.articleCode, this.nome, this.prezzo);

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

    public ArrayList<ShoppingCartEntity> getList(String fiscalCode) {
        final ArrayList<ShoppingCartEntity> lista = new ArrayList<ShoppingCartEntity>();

        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(fiscalCode));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("FiscalCode = :val1").withExpressionAttributeValues(eav);
        List<ShoppingCartEntity> li = dynamoDBMapper.parallelScan(ShoppingCartEntity.class, scanExpression, 16);

        lista.addAll(li);

        return lista;
    }
}
