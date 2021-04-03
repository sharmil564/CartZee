package com.syed.cartzee.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.syed.cartzee.R;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {

    List<FetchData> fetchDataList;

    public HelperAdapter(List<FetchData> fetchDataList) {
        this.fetchDataList = fetchDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items,parent,false);
        viewHolderClass viewHolderClass=new viewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        viewHolderClass viewHolderClass=(viewHolderClass)holder;
        FetchData fetchData=fetchDataList.get(position);
        viewHolderClass.nam.setText(fetchData.getProname());
        viewHolderClass.de.setText(fetchData.getProdesc());
        viewHolderClass.priice.setText(fetchData.getProamnt());
    }

    @Override
    public int getItemCount() {
        return fetchDataList.size();
    }
    public class viewHolderClass extends RecyclerView.ViewHolder
    {
        TextView nam,de,priice;
        public viewHolderClass(@NonNull View itemView) {
            super(itemView);
            nam=itemView.findViewById(R.id.rname);
            de=itemView.findViewById(R.id.rdes);
            priice=itemView.findViewById(R.id.rprice);
        }
    }
}
