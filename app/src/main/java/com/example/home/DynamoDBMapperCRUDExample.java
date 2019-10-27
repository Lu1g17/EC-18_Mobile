package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import static com.example.home.MainActivity.dynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBMapperCRUDExample{

    //static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();


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
        /*final ArticleItem articolo = new ArticleItem();
        articolo.setId(17);
        articolo.setTitle("La Teoria del Tutto");*/

        //DynamoDBMapper mapper = new DynamoDBMapper(client);
        //mapper.save(articolo);

        //dynamoDBMapper.save(articolo);

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                dynamoDBMapper.save(articolo);
                // Item saved
            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {

                ArticleItem[] lista = new ArticleItem[10];
                lista[0] = dynamoDBMapper.load(
                        ArticleItem.class,
                        7899);

                // Item read
                // Log.d("News Item:", newsItem.toString());
            }
        }).start();
    }

}
