package com.example.home.Boundary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ClientControl;
import com.example.home.R;
import com.example.home.RequiredFieldsException;

import static com.example.home.Boundary.MainActivity.autenticazione;

public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        ImageButton go = (ImageButton) findViewById(R.id.GoImageButtonRegistration);

        final EditText name = (EditText) findViewById(R.id.NameRegistration);
        final EditText surname = (EditText) findViewById(R.id.SurnameRegistration);
        final Spinner gender = findViewById(R.id.GenderRegistration);
        final EditText birthDate = (EditText) findViewById(R.id.BirthDateRegistration);
        final EditText fiscalCode = (EditText) findViewById(R.id.FiscalCodeRegistration);
        final EditText birthNation = (EditText) findViewById(R.id.BirthNationRegistration);
        final EditText birthProvince = (EditText) findViewById(R.id.BirthProvinceRegistration);
        final EditText birthCity = (EditText) findViewById(R.id.BirthCityRegistration);
        final EditText residenceNation = (EditText) findViewById(R.id.ResidenceNationRegistration);
        final EditText residenceRegion = (EditText) findViewById(R.id.ResidenceRegionRegistration);
        final EditText residenceProvince = (EditText) findViewById(R.id.ResidenceProvinceRegistration);
        final EditText residenceCity = (EditText) findViewById(R.id.ResidenceCityRegistration);
        final EditText residenceAddress = (EditText) findViewById(R.id.ResidenceAddressRegistration);
        final EditText residenceCap = (EditText) findViewById(R.id.ResidenceCAPRegistration);
        final EditText shippingNation = (EditText) findViewById(R.id.ShippingNationRegistration);
        final EditText shippingRegion = (EditText) findViewById(R.id.ShippingRegionRegistration);
        final EditText shippingProvince = (EditText) findViewById(R.id.ShippingProvinceRegistration);
        final EditText shippingCity = (EditText) findViewById(R.id.ShippingCityRegistration);
        final EditText shippingAddress = (EditText) findViewById(R.id.ShippingAddressRegistration);
        final EditText shippingCap = (EditText) findViewById(R.id.ShippingCAPRegistration);

        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ClientControl control = new ClientControl();

                try {
                    if (control.create(getIntent().getExtras().getString("email"), getIntent().getExtras().getString("password"), fiscalCode.getText().toString(), gender.getSelectedItem().toString(), name.getText().toString(), surname.getText().toString(), birthDate.getText().toString(), birthNation.getText().toString(), birthProvince.getText().toString(), birthCity.getText().toString(), residenceNation.getText().toString(), residenceRegion.getText().toString(), residenceProvince.getText().toString(), residenceCity.getText().toString(), residenceAddress.getText().toString(), residenceCap.getText().toString(), shippingNation.getText().toString(), shippingRegion.getText().toString(), shippingProvince.getText().toString(), shippingCity.getText().toString(), shippingAddress.getText().toString(), shippingCap.getText().toString()) == true) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Registration.this).create();
                        alertDialog.setTitle("Avviso");
                        alertDialog.setMessage("Registrazione Effettuata");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                        Intent login = new Intent(Registration.this, Login.class);
                                        startActivity(login);
                                    }
                                });
                        alertDialog.show();
                    }
                } catch (RequiredFieldsException re) {
                    AlertDialog alertDialog = new AlertDialog.Builder(Registration.this).create();
                    alertDialog.setTitle("Errore");
                    alertDialog.setMessage("Campo obbligatorio non inserito: " + re.getField());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } catch (Exception e) {
                    System.out.println("\nExc: " + e);
                }
            }
        });

        if (autenticazione != null) {
            int p = 1;

            if (autenticazione.getGender().equals("Uomo"))
                p = 1;
            else if (autenticazione.getGender().equals("Donna"))
                p = 2;

            name.setText(autenticazione.getName());
            surname.setText(autenticazione.getSurname());
            gender.setSelection(p);
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
