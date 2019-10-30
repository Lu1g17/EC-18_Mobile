package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ArticleControl;
import com.example.home.Entity.ArticleEntity;
import com.example.home.R;

import java.util.ArrayList;

public class Catalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);
        
        Button loginButton = findViewById(R.id.LoginButtonCatalog);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);

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

        shoppingCart.setOnClickListener(new View.OnClickListener(){
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

        });

        ArrayList<ArticleEntity> articoli = new ArticleControl().getList();
        ArticleListAdapter adapter = new ArticleListAdapter(Catalog.this, R.layout.image_layout, articoli);
        GridView view = (GridView) findViewById(R.id.GridViewCatalog);
        view.setAdapter(adapter);
    }
}
