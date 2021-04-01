package com.syed.cartzee.Recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.syed.cartzee.R;

public class dress extends AppCompatActivity {
    RecyclerView recyclerView;
    String s[],s1[],pri[];
    int images[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress);
        s=getResources().getStringArray(R.array.dresses);
        s1=getResources().getStringArray(R.array.description);
        pri=getResources().getStringArray(R.array.price);
        recyclerView=findViewById(R.id.recycle);
        myAdapter myAdapter=new myAdapter(this,s,s1,pri,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}