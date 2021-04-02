package com.syed.cartzee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.syed.cartzee.FBase.HelperClass;
import com.syed.cartzee.FBase.UserHelperClass;
import com.syed.cartzee.Recycle.myAdapter;

public class Description extends AppCompatActivity  {
    ImageView v1;
    TextView t1,t2,t3;
    Button b1,b2;
    String s1,s2,s3;
    DatabaseReference dRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        v1=findViewById(R.id.imageView);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView7);
        b1=findViewById(R.id.buy1);
        b2=findViewById(R.id.crt);
        dRef= FirebaseDatabase.getInstance().getReference();
        getData();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                Intent i=new Intent(Description.this,Payment.class);
                i.putExtra("amount",s3);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }
    public void getData()
    {
        if(getIntent().hasExtra("image")&&getIntent().hasExtra("data1")&&getIntent().hasExtra("data2")&&getIntent().hasExtra("pri1"))
        {
            v1.setImageResource(getIntent().getIntExtra("image",1));
            t1.setText(getIntent().getStringExtra("data1"));
            t2.setText(getIntent().getStringExtra("data2"));
            t3.setText(getIntent().getStringExtra("pri1"));
            s3=t3.getText().toString();
            s1=t1.getText().toString();
            s2=t2.getText().toString();
        }
    }
    public void next() {
        Toast.makeText(Description.this,"Added to Cart",Toast.LENGTH_SHORT).show();
        HelperClass helperClass=new HelperClass(s1,s2,s3);
        dRef.child("Users").child(FirebaseAuth.getInstance().getUid()).child("Cart").child(s1).setValue(helperClass);
    }
}