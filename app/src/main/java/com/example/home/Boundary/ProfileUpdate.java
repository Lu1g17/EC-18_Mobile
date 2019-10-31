package com.example.home.Boundary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ClientControl;
import com.example.home.Entity.ClientEntity;
import com.example.home.R;
import com.example.home.RequiredFieldsException;

import static com.example.home.Boundary.MainActivity.autenticazione;

public class ProfileUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_update);

        Button confirm = findViewById(R.id.ConfirmProfileUpdate);
        final EditText name = (EditText) findViewById(R.id.NameProfileUpdate);
        final EditText surname = (EditText) findViewById(R.id.SurnameProfileUpdate);
        final EditText gender = (EditText) findViewById(R.id.GenderProfileUpdate);
        final EditText birthDate = (EditText) findViewById(R.id.BirthDateProfileUpdate);
        final EditText fiscalCode = (EditText) findViewById(R.id.FiscalCodeProfileUpdate);
        final EditText birthNation = (EditText) findViewById(R.id.BirthNationProfileUpdate);
        final EditText birthProvince = (EditText) findViewById(R.id.BirthProvinceProfileUpdate);
        final EditText birthCity = (EditText) findViewById(R.id.BirthCityProfileUpdate);
        final EditText residenceNation = (EditText) findViewById(R.id.ResidenceNationProfileUpdate);
        final EditText residenceRegion = (EditText) findViewById(R.id.ResidenceRegionProfileUpdate);
        final EditText residenceProvince = (EditText) findViewById(R.id.ResidenceProvinceProfileUpdate);
        final EditText residenceCity = (EditText) findViewById(R.id.ResidenceCityProfileUpdate);
        final EditText residenceAddress = (EditText) findViewById(R.id.ResidenceAddressProfileUpdate);
        final EditText residenceCap = (EditText) findViewById(R.id.ResidenceCAPProfileUpdate);
        final EditText shippingNation = (EditText) findViewById(R.id.ShippingNationProfileUpdate);
        final EditText shippingRegion = (EditText) findViewById(R.id.ShippingRegionProfileUpdate);
        final EditText shippingProvince = (EditText) findViewById(R.id.ShippingProvinceProfileUpdate);
        final EditText shippingCity = (EditText) findViewById(R.id.ShippingCityProfileUpdate);
        final EditText shippingAddress = (EditText) findViewById(R.id.ShippingAddressProfileUpdate);
        final EditText shippingCap = (EditText) findViewById(R.id.ShippingCAPProfileUpdate);

        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ClientControl control = new ClientControl();

                try {
                    if (control.update(autenticazione.account.getEmail(), autenticazione.account.getPassword(), autenticazione.account.getFiscalCode(), gender.getText().toString(), name.getText().toString(), surname.getText().toString(), birthDate.getText().toString(), birthNation.getText().toString(), birthProvince.getText().toString(), birthCity.getText().toString(), residenceNation.getText().toString(), residenceRegion.getText().toString(), residenceProvince.getText().toString(), residenceCity.getText().toString(), residenceAddress.getText().toString(), residenceCap.getText().toString(), shippingNation.getText().toString(), shippingRegion.getText().toString(), shippingProvince.getText().toString(), shippingCity.getText().toString(), shippingAddress.getText().toString(), shippingCap.getText().toString()) == true) {
                        autenticazione = control.login(autenticazione.account.getEmail(), autenticazione.account.getPassword());

                        Intent profile = new Intent(ProfileUpdate.this, Profile.class);
                        startActivity(profile);
                    }
                } catch (RequiredFieldsException re) {
                    AlertDialog alertDialog = new AlertDialog.Builder(ProfileUpdate.this).create();
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
