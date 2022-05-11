package com.example.camera.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camera.MainActivity;
import com.example.camera.R;

public class My_Rv_Adpter extends BaseAdapter {

    Activity activity;
    String[] city;
    int[] img;
    private TextView txt1;
    private ImageView imge;

    public My_Rv_Adpter(MainActivity mainActivity, String[] city, int[] img) {
        activity = mainActivity;
        this.city = city;
        this.img = img;

    }

    @Override
    public int getCount() {
        return city.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(activity).inflate(R.layout.item, viewGroup, false);
        txt1 = view1.findViewById(R.id.txt1);
        imge = view1.findViewById(R.id.img);
        txt1.setText(city[i]);
        imge.setImageResource(img[i]);
        return view1;
    }
}

