package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.R;

import static com.example.home.Boundary.MainActivity.autenticazione;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        Button loginButton = findViewById(R.id.LoginButtonShoppingCart);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
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
                    Intent login = new Intent(ShoppingCart.this, Login.class);

                    startActivity(login);
                } else {
                    Intent profilo = new Intent(ShoppingCart.this, Profile.class);

                    startActivity(profilo);
                }
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(ShoppingCart.this, MainActivity.class);

                startActivity(mainActivity);
            }

        });

        catalog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent catalog = new Intent(ShoppingCart.this, Catalog.class);

                startActivity(catalog);
            }

        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent search = new Intent(ShoppingCart.this, Search.class);

                startActivity(search);
            }

        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(ShoppingCart.this, Menu.class);

                startActivity(menu);
            }

        });
    }

}
