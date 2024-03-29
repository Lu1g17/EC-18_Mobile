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
import com.example.home.R;
import com.example.home.RequiredFieldsException;

import static com.example.home.Boundary.MainActivity.autenticazione;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button registration= findViewById(R.id.buttonRegistrati);
        Button login = findViewById(R.id.buttonAccedi);

        registration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Registration = new Intent(Login.this, RegistrationEmail.class);

                startActivity(Registration);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.editTextUsername);
                EditText password = findViewById(R.id.editTextPassword);

                try {
                    autenticazione =  new ClientControl().login(email.getText().toString(), password.getText().toString());

                    if (autenticazione != null) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                        alertDialog.setTitle("Avviso");
                        alertDialog.setMessage("Benvenuto " + autenticazione.getName() + " " + autenticazione.getSurname());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                        Intent login = new Intent(Login.this, MainActivity.class);
                                        startActivity(login);

                                    }
                                });
                        alertDialog.show();
                    } else {
                        AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                        alertDialog.setTitle("Errore");
                        alertDialog.setMessage("Credenziali errate");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                } catch (RequiredFieldsException re) {
                    System.err.println("Unable to check login because there are required fields not filled: ");
                    System.err.println(re.getField());

                    try {
                        throw new RequiredFieldsException(re.getField());
                    } catch (RequiredFieldsException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    System.err.println("Unable to scan");
                    System.err.println(e.getMessage());
                }
            }
        });
    }
}
