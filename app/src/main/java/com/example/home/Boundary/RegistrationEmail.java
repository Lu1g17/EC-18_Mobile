package com.example.home.Boundary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ClientControl;
import com.example.home.Entity.ClientEntity;
import com.example.home.R;

public class RegistrationEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_email);

        ImageButton go = (ImageButton) findViewById(R.id.GoImageButtonRegistrationEmail);
        final EditText email = findViewById(R.id.EmailRegistrationEmail);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientControl control = new ClientControl();

                if (control.checkEmail(email.getText().toString()) == true) {
                    Intent registration = new Intent(RegistrationEmail.this, RegistrationPassword.class);
                    registration.putExtra("email", email.getText().toString());
                    startActivity(registration);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(RegistrationEmail.this).create();
                    alertDialog.setTitle("Avviso");
                    alertDialog.setMessage("Email esistente");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

    }
}


