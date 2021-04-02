package com.syed.cartzee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.syed.cartzee.FBase.UserHelperClass;

public class cod extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseDatabase fBase;
    DatabaseReference dRef;
    String uid;
    EditText cname,caddress,cphone,cmail;
    Button cnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod);
        fAuth = FirebaseAuth.getInstance();
        fBase = FirebaseDatabase.getInstance();
        uid = fAuth.getUid();
        dRef = fBase.getReference().child("Users").child(uid).child("Details");
        cname = findViewById(R.id.cname1);
        cphone = findViewById(R.id.cphone1);
        caddress = findViewById(R.id.caddress1);
        cmail = findViewById(R.id.cmail1);
        cnext = findViewById(R.id.corder);
        dRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cname.setText(snapshot.child("fname").getValue().toString());
                cphone.setText(snapshot.child("mobile").getValue().toString());
                caddress.setText(snapshot.child("address").getValue().toString());
                cmail.setText(snapshot.child("email").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        cnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = cphone.getText().toString();
                String msg = "Order placed Successfully...Happy Shopping";
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(num,null,msg,null,null);
                Toast.makeText(cod.this,"Order placed Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}