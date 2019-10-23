package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static boolean autenticato = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Blogin = findViewById(R.id.buttonLogin);

        Blogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(MainActivity.this, Login.class);

                startActivity(Login);
            }

        });

    }
}
