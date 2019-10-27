package com.example.home;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

public class DynamoDBMapperCRUDExample {

    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();


    @DynamoDBTable(tableName = "Article")
    public static class ArticleItem{
        private Integer id;
        private String title;

        @DynamoDBHashKey(attributeName = "Code")
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @DynamoDBAttribute(attributeName = "Title")
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static void aggiungi() {
        ArticleItem articolo = new ArticleItem();
        articolo.setId(17);
        articolo.setTitle("La Teoria del Tutto");

        DynamoDBMapper mapper = new DynamoDBMapper(client);
        mapper.save(articolo);

    }
}
