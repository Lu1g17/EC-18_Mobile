package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.home.R;
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

        TextView name = (TextView) findViewById(R.id.NameProfile);
        TextView surname = (TextView) findViewById(R.id.SurnameProfile);
        TextView gender = (TextView) findViewById(R.id.GenderProfile);
        TextView birthDate = (TextView) findViewById(R.id.BirthDateProfile);
        TextView fiscalCode = (TextView) findViewById(R.id.FiscalCodeProfile);
        TextView birthNation = (TextView) findViewById(R.id.BirthNationProfile);
        TextView birthProvince = (TextView) findViewById(R.id.BirthProvinceProfile);
        TextView birthCity = (TextView) findViewById(R.id.BirthCityProfile);
        TextView residenceNation = (TextView) findViewById(R.id.ResidenceNationProfile);
        TextView residenceRegion = (TextView) findViewById(R.id.ResidenceRegionProfile);
        TextView residenceProvince = (TextView) findViewById(R.id.ResidenceProvinceProfile);
        TextView residenceCity = (TextView) findViewById(R.id.ResidenceCityProfile);
        TextView residenceAddress = (TextView) findViewById(R.id.ResidenceAddressProfile);
        TextView residenceCap = (TextView) findViewById(R.id.ResidenceCAPProfile);
        TextView shippingNation = (TextView) findViewById(R.id.ShippingNationProfile);
        TextView shippingRegion = (TextView) findViewById(R.id.ShippingRegionProfile);
        TextView shippingProvince = (TextView) findViewById(R.id.ShippingProvinceProfile);
        TextView shippingCity = (TextView) findViewById(R.id.ShippingCityProfile);
        TextView shippingAddress = (TextView) findViewById(R.id.ShippingAddressProfile);
        TextView shippingCap = (TextView) findViewById(R.id.ShippingCAPProfile);

        if (autenticazione != null) {
            name.setText(autenticazione.getName());
            surname.setText(autenticazione.getSurname());
            gender.setText(autenticazione.getGender());
            birthDate.setText(autenticazione.getBirthDate());
            fiscalCode.setText(autenticazione.getFiscalCode());
            birthNation.setText(String.valueOf(autenticazione.getBirthNation()));
            birthProvince.setText(String.valueOf(autenticazione.getBirthProvince()));
            birthCity.setText(String.valueOf(autenticazione.getBirthCity()));
            residenceNation.setText(String.valueOf(autenticazione.getResidenceNation()));
            residenceRegion.setText(String.valueOf(autenticazione.getResidenceRegion()));
            residenceProvince.setText(String.valueOf(autenticazione.getResidenceProvince()));
            residenceCity.setText(String.valueOf(autenticazione.getResidenceCity()));
            residenceAddress.setText(String.valueOf(autenticazione.getResidenceAddress()));
            residenceCap.setText(String.valueOf(autenticazione.getResidenceCAP()));
            shippingNation.setText(String.valueOf(autenticazione.getShippingNation()));
            shippingRegion.setText(String.valueOf(autenticazione.getShippingRegion()));
            shippingProvince.setText(String.valueOf(autenticazione.getShippingProvince()));
            shippingCity.setText(String.valueOf(autenticazione.getShippingCity()));
            shippingAddress.setText(String.valueOf(autenticazione.getShippingAddress()));
            shippingCap.setText(String.valueOf(autenticazione.getShippingCAP()));
        }
    }
}
