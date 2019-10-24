package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Catalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        TextView abbigliamento = findViewById(R.id.clothingTextView);
        Button loginButton = findViewById(R.id.buttonLogin);
        ImageButton homeButton = findViewById(R.id.imageButton5);
        ImageButton search = findViewById(R.id.imageButton7);
        ImageButton shoppingCart = findViewById(R.id.imageButton8);
        ImageButton menu = findViewById(R.id.imageButton9);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(Catalog.this, Login.class);

                startActivity(login);
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(Catalog.this, MainActivity.class);

                startActivity(mainActivity);
            }

        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent search = new Intent(Catalog.this, Search.class);

                startActivity(search);
            }

        });

        /*shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(Catalog.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Catalog.this, Menu.class);

                startActivity(menu);
            }

        });*/
        abbigliamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("hai premuto su abbigliamento");
            }

        });

        TextView calzature = findViewById(R.id.footwearTextView);

        abbigliamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("hai premuto su calzature");
            }

        });

        TextView accessori = findViewById(R.id.accessoriesTextView);

        abbigliamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("hai premuto su accessori");
            }

        });

    }
}
