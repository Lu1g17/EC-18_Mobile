package com.example.home.Boundary;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.home.Control.ArticleControl;
import com.example.home.Entity.ArticleEntity;
import com.example.home.R;
import java.util.ArrayList;

import static com.example.home.Boundary.MainActivity.autenticazione;


public class Catalog extends AppCompatActivity {

    public static String gender = null, category = null;
    Button manButton, womanButton, kidButton;
    TextView clothingButton, footwearButton, accessoriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        Button loginButton = findViewById(R.id.LoginButtonCatalog);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);
        manButton = findViewById(R.id.ManButtonCatalog);
        womanButton = findViewById(R.id.WomanButtonCatalog);
        kidButton = findViewById(R.id.KidButtonCatalog);
        clothingButton = findViewById(R.id.clothingTextViewCatalog);
        footwearButton = findViewById(R.id.footwearTextViewCatalog);
        accessoriesButton = findViewById(R.id.accessoriesTextViewCatalog);

        if (autenticazione == null) {
            loginButton.setText("LOGIN");
        } else {
            loginButton.setText(autenticazione.getName());
        }

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (autenticazione == null) {
                    Intent login = new Intent(Catalog.this, Login.class);

                    startActivity(login);
                } else {
                    Intent profilo = new Intent(Catalog.this, Profile.class);

                    startActivity(profilo);
                }
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

        manButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setGender("Uomo");
                refresh();
            }
        });

        womanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setGender("Donna");
                refresh();
            }
        });

        kidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setGender("Bambino");
                refresh();
            }
        });

        clothingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setCategory("Abbigliamento");
                refresh();
            }
        });

        footwearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setCategory("Calzature");
                refresh();
            }
        });

        accessoriesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setCategory("Accessori");
                refresh();
            }
        });

        if (gender == null)
            setGender("Uomo");
        else
            setGender(gender);

        if (category == null)
            setCategory("Abbigliamento");
        else
            setCategory(category);

        refresh();
    }

    public void refresh() {
        ArrayList<ArticleEntity> articoli = new ArticleControl().getList(gender, category);
        ArticleListAdapter adapter = new ArticleListAdapter(Catalog.this, R.layout.image_layout, articoli);
        GridView view = (GridView) findViewById(R.id.GridViewCatalog);
        view.setAdapter(adapter);
    }

    public void setGender(String gender) {
        this.gender = gender;

        if (gender.equals("Uomo")) {
            manButton.setBackgroundColor(Color.LTGRAY);
            womanButton.setBackgroundColor(Color.TRANSPARENT);
            kidButton.setBackgroundColor(Color.TRANSPARENT);
        } else if (gender.equals("Donna")) {
            manButton.setBackgroundColor(Color.TRANSPARENT);
            womanButton.setBackgroundColor(Color.LTGRAY);
            kidButton.setBackgroundColor(Color.TRANSPARENT);
        } else if (gender.equals("Bambino")) {
            manButton.setBackgroundColor(Color.TRANSPARENT);
            womanButton.setBackgroundColor(Color.TRANSPARENT);
            kidButton.setBackgroundColor(Color.LTGRAY);
        }
    }

    public void setCategory(String category) {
        this.category = category;

        if (category.equals("Abbigliamento")) {
            clothingButton.setTypeface(null, Typeface.BOLD_ITALIC);
            footwearButton.setTypeface(null, Typeface.NORMAL);
            accessoriesButton.setTypeface(null, Typeface.NORMAL);
        } else if (category.equals("Calzature")) {
            clothingButton.setTypeface(null, Typeface.NORMAL);
            footwearButton.setTypeface(null, Typeface.BOLD_ITALIC);
            accessoriesButton.setTypeface(null, Typeface.NORMAL);
        } else if (category.equals("Accessori")) {
            clothingButton.setTypeface(null, Typeface.NORMAL);
            footwearButton.setTypeface(null, Typeface.NORMAL);
            accessoriesButton.setTypeface(null, Typeface.BOLD_ITALIC);
        }
    }

}
