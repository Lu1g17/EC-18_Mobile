package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.home.Control.ArticleControl;
import com.example.home.Entity.ArticleEntity;
import com.example.home.R;

import java.util.ArrayList;

import static com.example.home.Boundary.MainActivity.autenticazione;

public class Search extends AppCompatActivity {
    public static String name;
    public EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Button loginButton = findViewById(R.id.LoginButtonSearch);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);
        search = findViewById(R.id.SearchEditTextSearch);

        if (autenticazione == null) {
            loginButton.setText("LOGIN");
        } else {
            loginButton.setText(autenticazione.getName());
        }

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (autenticazione == null) {
                    Intent login = new Intent(Search.this, Login.class);

                    startActivity(login);
                } else {
                    Intent profilo = new Intent(Search.this, Profile.class);

                    startActivity(profilo);
                }
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

        search.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                refresh();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                refresh();
            }
        });

        refresh();
    }

    public void refresh() {
        ArrayList<ArticleEntity> articoli;

        name = search.getText().toString();

        if ((name != null) && (!name.equals("")))
            articoli = new ArticleControl().getList(name);
        else
            articoli = new ArticleControl().getList();

        ArticleListAdapter adapter = new ArticleListAdapter(Search.this, R.layout.image_layout, articoli);
        GridView view = (GridView) findViewById(R.id.GridViewSearch);
        view.setAdapter(adapter);
    }

}
