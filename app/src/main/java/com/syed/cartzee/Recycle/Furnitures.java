package com.syed.cartzee.Recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.syed.cartzee.R;

public class Furnitures extends AppCompatActivity {

    RecyclerView recyclerView;
    String s[],s1[],pri[];
    int images[]={R.drawable.fpic1,R.drawable.fpic2,R.drawable.fpic3,R.drawable.fpic4,R.drawable.fpic5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furnitures);
        s=getResources().getStringArray(R.array.furnitures);
        s1=getResources().getStringArray(R.array.furnDes);
        pri=getResources().getStringArray(R.array.furnprice);
        recyclerView=findViewById(R.id.recycle2);
        myAdapter myAdapter=new myAdapter(this,s,s1,pri,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}