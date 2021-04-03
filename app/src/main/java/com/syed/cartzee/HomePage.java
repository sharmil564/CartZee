package com.syed.cartzee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.syed.cartzee.Recycle.Appliance;
import com.syed.cartzee.Recycle.Furnitures;
import com.syed.cartzee.Recycle.Mobile;
import com.syed.cartzee.Recycle.dress;

public class HomePage extends AppCompatActivity {
    FirebaseAuth fAuth;
    CardView c1,c2,c3,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        fAuth=FirebaseAuth.getInstance();
        Button b1=findViewById(R.id.lgout);
        c1=findViewById(R.id.cardView);
        c2=findViewById(R.id.cardView1);
        c3=findViewById(R.id.cardView2);
        c4=findViewById(R.id.cardView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                Toast.makeText(HomePage.this,"Logout Success!!",Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(HomePage.this,LoginPage.class);
                startActivity(i1);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this, dress.class);
                startActivity(i);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this, Mobile.class);
                startActivity(i);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this, Furnitures.class);
                startActivity(i);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomePage.this, Appliance.class);
                startActivity(i);
            }
        });
    }
}