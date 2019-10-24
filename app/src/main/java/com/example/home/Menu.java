package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button loginButton = findViewById(R.id.LoginButton);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        TextView profilo = findViewById(R.id.ProfileTextView);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(Menu.this, Login.class);

                startActivity(login);
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(Menu.this, MainActivity.class);

                startActivity(mainActivity);
            }

        });

        catalog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent catalog = new Intent(Menu.this, Catalog.class);

                startActivity(catalog);
            }

        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent search = new Intent(Menu.this, Search.class);

                startActivity(search);
            }

        });

        /*shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(Menu.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });*/
        
        profilo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent profilo = new Intent(Menu.this, Profile.class);

                startActivity(profilo);
            }
        });

    }
}
