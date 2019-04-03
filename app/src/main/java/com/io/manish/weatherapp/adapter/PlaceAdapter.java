package com.io.manish.weatherapp.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.io.manish.weatherapp.main_activity.RecyclerItemClickListener;
import com.io.manish.weatherapp.model.Place;
import com.io.manish.weatherapp.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private ArrayList<Place> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public PlaceAdapter(ArrayList<Place> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtPlaceName.setText("Name : " + dataList.get(position).getName());
        holder.txtPlaceTemprature.setText("Temprature : " + dataList.get(position).getWeatherAttribute().getTemprature());
        holder.txtPlaceHumidity.setText("Humidity : " + dataList.get(position).getWeatherAttribute().getHumidity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        TextView txtPlaceName, txtPlaceTemprature, txtPlaceHumidity;

        PlaceViewHolder(View itemView) {
            super(itemView);
            txtPlaceName = itemView.findViewById(R.id.txt_place_name);
            txtPlaceTemprature = itemView.findViewById(R.id.txt_place_temprature);
            txtPlaceHumidity = itemView.findViewById(R.id.txt_place_humidity);

        }
    }
}