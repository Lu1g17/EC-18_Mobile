package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ClientControl;
import com.example.home.Entity.ClientEntity;
import com.example.home.R;
import com.squareup.picasso.Picasso;
import static com.example.home.Boundary.MainActivity.autenticazione;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button update = findViewById(R.id.UpdateButtonProfile);
        ImageButton homeButton = findViewById(R.id.imageButtonHome);
        ImageButton catalog = findViewById(R.id.imageButtonCatalog);
        ImageButton search = findViewById(R.id.imageButtonSearch);
        ImageButton shoppingCart = findViewById(R.id.imageButtonShoppingCart);
        ImageButton menu = findViewById(R.id.imageButtonMenu);

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent update = new Intent(Profile.this, ProfileUpdate.class);

                startActivity(update);
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(Profile.this, MainActivity.class);

                startActivity(mainActivity);
            }

        });

        catalog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent catalog = new Intent(Profile.this, Catalog.class);

                startActivity(catalog);
            }

        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent search = new Intent(Profile.this, Search.class);

                startActivity(search);
            }

        });

        shoppingCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(Profile.this, ShoppingCart.class);

                startActivity(shoppingCart);
            }

        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Profile.this, Menu.class);

                startActivity(menu);
            }

        });

        /*TextView name = (TextView) findViewById(R.id.NameProfile);
        TextView surname = (TextView) findViewById(R.id.SurnameProfile);
        TextView gender = (TextView) findViewById(R.id.GenderProfile);
        TextView birthDate = (TextView) findViewById(R.id.BirthDateProfile);
        TextView fiscalCode = (TextView) findViewById(R.id.FiscalCodeProfile);
        TextView birthNation = (TextView) findViewById(R.id.BirthNationProfile);
        TextView birthProvince = (TextView) findViewById(R.id.BirthProvinceProfile);
        TextView birthCityProfile = (TextView) findViewById(R.id.BirthCityProfile);
        TextView birthNation = (TextView) findViewById(R.id.ResidenceNationProfile);
        TextView birthRegion = (TextView) findViewById(R.id.ResidenceRegionProfile);
        TextView birthProvince = (TextView) findViewById(R.id.ResidenceProvinceProfile);
        TextView birthCityProfile = (TextView) findViewById(R.id.ResidenceCityProfile);
        TextView birthAddress = (TextView) findViewById(R.id.ResidenceAddressProfile);
        TextView birthCap = (TextView) findViewById(R.id.ResidenceCAPProfile);
        TextView birthNation = (TextView) findViewById(R.id.BirthNationProfile);
        TextView birthRegion = (TextView) findViewById(R.id.BirthRegionProfile);
        TextView birthProvince = (TextView) findViewById(R.id.BirthProvinceProfile);
        TextView birthCityProfile = (TextView) findViewById(R.id.BirthCityProfile);
        TextView birthAddress = (TextView) findViewById(R.id.BirthAddressProfile);
        TextView birthCap = (TextView) findViewById(R.id.BirthCAPProfile);
        TextView birthNation = (TextView) findViewById(R.id.BirthNationProfile);
        TextView birthRegion = (TextView) findViewById(R.id.BirthRegionProfile);
        TextView birthProvince = (TextView) findViewById(R.id.BirthProvinceProfile);
        TextView birthCityProfile = (TextView) findViewById(R.id.BirthCityProfile);
        TextView birthAddress = (TextView) findViewById(R.id.BirthAddressProfile);
        TextView birthCap = (TextView) findViewById(R.id.BirthCAPProfile);

        name.setText(autenticazione.getName());
        surname.setText(autenticazione.getSurname());
        gender.setText(autenticazione.getGender());
        birthDate.setText(autenticazione.getBirthDate());
        fiscalCode.setText(autenticazione.getFiscalCode());
        birthNation.setText(String.valueOf(autenticazione.getBirthNation()));
        birthProvince.setText(String.valueOf(autenticazione.getBirthProvince()));
        birthCity.setText(String.valueOf(autenticazione.getBirthCity()));
        birthNation.setText(String.valueOf(autenticazione.getBirthNation()));
        birthRegion.setText(String.valueOf(autenticazione.getBirthRegion()));
        birthProvince.setText(String.valueOf(autenticazione.getBirthProvince()));
        birthCity.setText(String.valueOf(autenticazione.getBirthCity()));
        birthAddress.setText(String.valueOf(autenticazione.getBirthAddress()));
        birthCap.setText(String.valueOf(autenticazione.getBirthCAP()));        birthNation.setText(String.valueOf(autenticazione.getBirthNation()));
        birthRegion.setText(String.valueOf(autenticazione.getBirthRegion()));
        birthProvince.setText(String.valueOf(autenticazione.getBirthProvince()));
        birthCity.setText(String.valueOf(autenticazione.getBirthCity()));
        birthAddress.setText(String.valueOf(autenticazione.getBirthAddress()));
        birthCap.setText(String.valueOf(autenticazione.getBirthCAP()));        birthNation.setText(String.valueOf(autenticazione.getBirthNation()));
        birthRegion.setText(String.valueOf(autenticazione.getBirthRegion()));
        birthProvince.setText(String.valueOf(autenticazione.getBirthProvince()));
        birthCity.setText(String.valueOf(autenticazione.getBirthCity()));
        birthAddress.setText(String.valueOf(autenticazione.getBirthAddress()));
        birthCap.setText(String.valueOf(autenticazione.getBirthCAP()));*/
    }
}
