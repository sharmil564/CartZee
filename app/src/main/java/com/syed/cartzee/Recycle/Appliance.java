package com.syed.cartzee.Recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.syed.cartzee.R;

public class Appliance extends AppCompatActivity {
    RecyclerView recyclerView;
    String s[],s1[],pri[];
    int images[]={R.drawable.apic1,R.drawable.apic2,R.drawable.apic3,R.drawable.apic4,R.drawable.apic5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance);
        s=getResources().getStringArray(R.array.Appliances);
        s1=getResources().getStringArray(R.array.applDes);
        pri=getResources().getStringArray(R.array.applprice);
        recyclerView=findViewById(R.id.recycle3);
        myAdapter myAdapter=new myAdapter(this,s,s1,pri,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}