package com.syed.cartzee.Recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.syed.cartzee.R;

public class Mobile extends AppCompatActivity {

    RecyclerView recyclerView;
    String s[],s1[],pri[];
    int images[]={R.drawable.mpic1,R.drawable.mpic2,R.drawable.mpic3,R.drawable.mpic4,R.drawable.mpic5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
        s=getResources().getStringArray(R.array.mobiles);
        s1=getResources().getStringArray(R.array.mobDes);
        pri=getResources().getStringArray(R.array.mobprice);
        recyclerView=findViewById(R.id.recycle1);
        myAdapter myAdapter=new myAdapter(this,s,s1,pri,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}