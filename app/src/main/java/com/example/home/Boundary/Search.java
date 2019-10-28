package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.home.R;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        ImageView prova = findViewById(R.id.imageView);
        Glide.with(this).load("data:image/jpeg;base64,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").into(prova);

        Button loginButton = findViewById(R.id.LoginButtonSearch);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(Search.this, Login.class);

                startActivity(login);
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(Search.this, MainActivity.class);

                startActivity(mainActivity);
            }

        });

        catalog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent catalog = new Intent(Search.this, Catalog.class);

                startActivity(catalog);
            }

        });

        shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(Search.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Search.this, Menu.class);

                startActivity(menu);
            }

        });
    }

}