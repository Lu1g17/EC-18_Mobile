package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registration1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration1);
        //setContentView(R.layout.registration3);

        ImageButton Bregistration1 = (ImageButton) findViewById(R.id.imageButtonAvanti1);

        Bregistration1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration2 = new Intent(Registration1.this, Registration2.class);

                startActivity(registration2);
            }
        });

        /*

        ImageButton Bregistration3= (ImageButton) findViewById(R.id.imageButtonAvanti3);

        Bregistration3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registration3 = new Intent(Registration.this, Registration.class);

                startActivity(registration3);
            }
        });*/

    }
}


