package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static boolean autenticato = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Blogin = findViewById(R.id.buttonLogin);
        ImageButton homeButton = findViewById(R.id.imageButton5);
        ImageButton catalog = findViewById(R.id.imageButton6);
        ImageButton search = findViewById(R.id.imageButton7);
        ImageButton shoppingCart = findViewById(R.id.imageButton8);
        ImageButton menu = findViewById(R.id.imageButton9);

        Blogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, Login.class);

                startActivity(login);
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(MainActivity.this, MainActivity.class);

                startActivity(mainActivity);
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

        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MainActivity.this, Menu.class);

                startActivity(menu);
            }

        });*/
    }
}
