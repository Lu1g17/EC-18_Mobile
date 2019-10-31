package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ArticleControl;
import com.example.home.Control.ShoppingCartControl;
import com.example.home.Entity.ShoppingCartEntity;
import com.example.home.Entity.ShoppingCartEntity;
import com.example.home.R;

import java.util.ArrayList;

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

        if (autenticazione != null) {
            ArrayList<ShoppingCartEntity> articoli = new ShoppingCartControl().getList(autenticazione.getFiscalCode());
            ShoppingListAdapter adapter = new ShoppingListAdapter(ShoppingCart.this, R.layout.shoppingcart_layout, articoli);
            GridView view = (GridView) findViewById(R.id.GridViewShoppingCart);
            view.setAdapter(adapter);
        }
    }

}
