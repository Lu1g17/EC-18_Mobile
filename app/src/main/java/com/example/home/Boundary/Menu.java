package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.home.R;
import static com.example.home.Boundary.MainActivity.autenticazione;
import static com.example.home.Boundary.Catalog.gender;
import static com.example.home.Boundary.Catalog.category;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button loginButton = findViewById(R.id.LoginButtonMenu);
        Button logoutButton = findViewById(R.id.LogoutButtonMenu);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        final Spinner man = findViewById(R.id.ManSpinnerMenu);
        final Spinner woman = findViewById(R.id.WomanSpinnerMenu);
        final Spinner kid = findViewById(R.id.KidSpinnerMenu);

        if (autenticazione == null) {
            loginButton.setText("Login");
            logoutButton.setEnabled(false);
            logoutButton.setVisibility(View.GONE);
        } else {
            loginButton.setText(autenticazione.getName());
            logoutButton.setEnabled(true);
            logoutButton.setVisibility(View.VISIBLE);
        }

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (autenticazione == null) {
                    Intent login = new Intent(Menu.this, Login.class);

                    startActivity(login);
                } else {
                    Intent profilo = new Intent(Menu.this, Profile.class);

                    startActivity(profilo);
                }
            }

        });

        logoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                autenticazione = null;
                Intent home = new Intent(Menu.this, MainActivity.class);

                startActivity(home);
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

        shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(Menu.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });

        man.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (!selectedItem.equals("Uomo")) {
                    gender = "Uomo";
                    category = selectedItem;
                    Intent catalog = new Intent(Menu.this, Catalog.class);

                    startActivity(catalog);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });

        woman.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (!selectedItem.equals("Donna")) {
                    gender = "Donna";
                    category = selectedItem;
                    Intent catalog = new Intent(Menu.this, Catalog.class);

                    startActivity(catalog);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });

        kid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (!selectedItem.equals("Bambino")) {
                    gender = "Bambino";
                    category = selectedItem;
                    Intent catalog = new Intent(Menu.this, Catalog.class);

                    startActivity(catalog);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
