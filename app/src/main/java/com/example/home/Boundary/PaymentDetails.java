package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.R;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    TextView txtId,txtAmount,txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);

        txtId = (TextView)findViewById(R.id.NumberOrderDetails);
        txtAmount = (TextView)findViewById(R.id.AmountOrderDetails);
        txtStatus = (TextView)findViewById(R.id.StateOrderDetails);

        Intent intent = getIntent();

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));

        } catch (JSONException e){

            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount){
        try {
            txtId.setText(response.getString("id"));
            txtStatus.setText(response.getString("state"));
            txtAmount.setText("$" + paymentAmount);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
