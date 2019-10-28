package com.example.home.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.config.AWSConfiguration;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.example.home.Control.Connection;
import com.example.home.R;

public class MainActivity extends AppCompatActivity {
    //static boolean autenticato = false;
    public static DynamoDBMapper dynamoDBMapper;
    public static Connection connessione = new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.LoginButton);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, Data.class);

                startActivity(login);
            }

        });

        catalog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent catalog = new Intent(MainActivity.this, Catalog.class);

                startActivity(catalog);
            }

        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent search = new Intent(MainActivity.this, Search.class);

                startActivity(search);
            }

        });

        shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(MainActivity.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MainActivity.this, Menu.class);

                startActivity(menu);
            }

        });

        //connessione.initConnectionDatabase();
        initConnectionDatabase();

        DynamoDBMapperCRUDExample elemento = new DynamoDBMapperCRUDExample();

        elemento.aggiungi(); //prova di lettura/aggiunta di un elemento
    }

    public void initConnectionDatabase(){

        AWSMobileClient.getInstance().initialize(this).execute();

        AWSCredentialsProvider credentialsProvider = AWSMobileClient.getInstance().getCredentialsProvider();
        AWSConfiguration configuration = AWSMobileClient.getInstance().getConfiguration();

        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);

        this.dynamoDBMapper = DynamoDBMapper.builder().dynamoDBClient(dynamoDBClient).awsConfiguration(configuration).build();
    }
}


























