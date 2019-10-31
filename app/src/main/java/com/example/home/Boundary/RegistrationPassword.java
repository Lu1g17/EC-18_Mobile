package com.example.home.Boundary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.home.R;

public class RegistrationPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_password);

        ImageButton go = (ImageButton) findViewById(R.id.GoImageButtonRegistrationPassword);
        final EditText password = findViewById(R.id.PasswordRegistrationPassword);

        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (password.length() > 5) {
                    Intent registration = new Intent(RegistrationPassword.this, Registration.class);
                    registration.putExtra("email", getIntent().getExtras().getString("email"));
                    registration.putExtra("password", password.getText().toString());
                    startActivity(registration);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(RegistrationPassword.this).create();
                    alertDialog.setTitle("Errore");
                    alertDialog.setMessage("Password di lunghezza inferiore a 5 caratteri");
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
