package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Catalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        TextView abbigliamento = findViewById(R.id.textViewabbigliamento);

        abbigliamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("hai premuto su abbigliamento");
            }

        });

        TextView calzature = findViewById(R.id.textViewcalzature);

        abbigliamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("hai premuto su calzature");
            }

        });

        TextView accessori = findViewById(R.id.textViewaccessori);

        abbigliamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("hai premuto su accessori");
            }

        });

    }
}
