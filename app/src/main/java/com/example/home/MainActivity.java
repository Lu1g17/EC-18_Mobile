package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    static boolean autenticato = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.LoginButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, Login.class);

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

        /*shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(MainActivity.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });*/

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MainActivity.this, Menu.class);

                startActivity(menu);
            }

        });
    }
}
