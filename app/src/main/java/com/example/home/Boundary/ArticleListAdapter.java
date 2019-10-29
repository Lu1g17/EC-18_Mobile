package com.example.home.Boundary;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.home.Entity.ArticleEntity;
import com.example.home.R;

import java.util.ArrayList;

public class ArticleListAdapter extends ArrayAdapter<ArticleEntity> {

    private Context context;
    private int resource;
    private ArrayList<ArticleEntity> lista;
    private ImageView image;

    private static class Layout {
        TextView name;
        TextView brand;
        TextView price;
        ImageView attached;
    }

    public ArticleListAdapter(Context context, int resource, ArrayList<ArticleEntity> lista, ImageView image){
        super(context, resource, lista);

        this.context = context;
        this.resource = resource;
        this.lista = lista;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String brand = getItem(position).getBrand();
        Float price = getItem(position).getPrice();
        String attached = getItem(position).getAttached();

        Layout viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new Layout();
            viewHolder.name = (TextView)convertView.findViewById(R.id.NameTextViewCatalog);
            viewHolder.brand = (TextView)convertView.findViewById(R.id.BrandTextViewCatalog);
            viewHolder.price = (TextView)convertView.findViewById(R.id.PriceTextViewCatalog);
            viewHolder.attached = image;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Layout) convertView.getTag();
        }

        viewHolder.name.setText(name);
        viewHolder.brand.setText(brand);
        viewHolder.price.setText(String.valueOf(price));
        Glide.with(context).load(attached).into(viewHolder.attached);

        return convertView;
    }


}
