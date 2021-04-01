package com.syed.cartzee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity  {
    ImageView v1;
    TextView t1,t2,t3;
    Button b1;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        v1=findViewById(R.id.imageView);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView7);
        b1=findViewById(R.id.buy1);
        getData();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Description.this,Payment.class);
                i.putExtra("amount",s1);
                startActivity(i);
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
            s1=t3.getText().toString();
        }
    }


}