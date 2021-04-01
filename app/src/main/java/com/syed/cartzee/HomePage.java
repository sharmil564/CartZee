package com.syed.cartzee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.syed.cartzee.Recycle.dress;

public class HomePage extends AppCompatActivity {
    FirebaseAuth fAuth;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        fAuth=FirebaseAuth.getInstance();
        Button b1=findViewById(R.id.logout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                Toast.makeText(HomePage.this,"Logout Success!!",Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(HomePage.this,LoginPage.class);
                startActivity(i1);
            }
        });
        t1=findViewById(R.id.dresstxt1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this, dress.class);
                startActivity(i);
            }
        });

    }
}