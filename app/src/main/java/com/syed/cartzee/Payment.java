package com.syed.cartzee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONException;
import org.json.JSONObject;

import io.grpc.InternalWithLogId;

public class Payment extends AppCompatActivity implements PaymentResultWithDataListener {
    String s1;
    TextView t1;
    int amount;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        t1=findViewById(R.id.textView10);
        b1=findViewById(R.id.cod);
        b2=findViewById(R.id.online);
        if(getIntent().hasExtra("amount"))
        {
            t1.setText(getIntent().getStringExtra("amount"));
            s1=t1.getText().toString();
            amount=Integer.parseInt(s1);
            amount=amount*100;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Payment.this,cod.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout checkout=new Checkout();
                checkout.setKeyID("rzp_test_kfSxhBcQPEZYtJ");
                checkout.setImage(R.drawable.logo);
                JSONObject object=new JSONObject();
                try {
                    object.put("name", "Sharmil");
                    object.put("description", "Test Payment");
                    object.put("theme.color", "#0093DD");
                    object.put("currency", "INR");
                    object.put("prefill.contact", "1234567890");
                    object.put("amount", amount);
                    object.put("prefill.email", "sharmil564@gmail.com");
                    checkout.open(Payment.this,object);
                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}