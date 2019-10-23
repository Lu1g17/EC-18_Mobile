package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        TextView profilo = findViewById(R.id.textViewprofilo);

        profilo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent profilo = new Intent(Menu.this, Profile.class);

                startActivity(profilo);
            }
        });

    }
}
