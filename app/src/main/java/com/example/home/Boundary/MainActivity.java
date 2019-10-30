package com.example.home.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageButton;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.config.AWSConfiguration;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.example.home.Control.ArticleControl;
import com.example.home.Entity.ArticleEntity;
import com.example.home.Entity.ClientEntity;
import com.example.home.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ClientEntity autenticazione = null;
    public static DynamoDBMapper dynamoDBMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.LoginButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);

        if (autenticazione == null) {
            loginButton.setText("LOGIN");
        } else {
            loginButton.setText(autenticazione.getName());
        }

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (autenticazione == null) {
                    Intent login = new Intent(MainActivity.this, Login.class);

                    startActivity(login);
                } else {
                    Intent profilo = new Intent(MainActivity.this, Profile.class);

                    startActivity(profilo);
                }
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

        initConnectionDatabase();
        refresh();
    }

    public void refresh() {
        ArrayList<ArticleEntity> articoli = new ArticleControl().getForegroundList();
        ArticleListAdapter adapter = new ArticleListAdapter(MainActivity.this, R.layout.image_layout, articoli);
        GridView view = (GridView) findViewById(R.id.GridViewHome);
        view.setAdapter(adapter);
    }

    public void initConnectionDatabase() {
        AWSMobileClient.getInstance().initialize(this).execute();

        AWSCredentialsProvider credentialsProvider = AWSMobileClient.getInstance().getCredentialsProvider();
        AWSConfiguration configuration = AWSMobileClient.getInstance().getConfiguration();

        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);

        this.dynamoDBMapper = DynamoDBMapper.builder().dynamoDBClient(dynamoDBClient).awsConfiguration(configuration).build();
    }
}


























