package com.syed.cartzee.Recycle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.syed.cartzee.Description;
import com.syed.cartzee.R;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    String data1[],data2[],pri1[];
    int images[];
    Context context;

    public myAdapter(Context ct,String s[],String s1[],String pri[],int image[])
    {
        context=ct;
        data1=s;
        data2=s1;
        pri1=pri;
        images=image;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txt1.setText(data1[position]);
        holder.txt2.setText(data2[position]);
        holder.txt3.setText(pri1[position]);
        //holder.txt4.setText("Rs");
        holder.img.setImageResource(images[position]);
        holder.CLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, Description.class);
                i.putExtra("data1",data1[position]);
                i.putExtra("data2",data2[position]);
                i.putExtra("pri1",pri1[position]);
                i.putExtra("image",images[position]);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return data1.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView txt1,txt2,txt3,txt4;
        ImageView img;
        ConstraintLayout CLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.textView29);
            txt2=itemView.findViewById(R.id.textView30);
            txt3=itemView.findViewById(R.id.textView32);
            //txt4=itemView.findViewById(R.id.textView31);
            img=itemView.findViewById(R.id.imageView4);
            CLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
