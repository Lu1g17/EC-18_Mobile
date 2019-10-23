package com.example.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        ImageView Button01 = (ImageView) findViewById(R.id.imageViewpaypal);
        Button01.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.paypal.com/it/home");
                startActivity(new Intent(String.valueOf(Data.this), uri));
            }
        });

    }
}
