package com.example.home.Boundary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.home.Entity.ShoppingCartEntity;
import com.example.home.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ShoppingListAdapter extends ArrayAdapter<ShoppingCartEntity> {

    private Context context;
    private int resource;
    private ArrayList<ShoppingCartEntity> lista;
    public String code;

    private static class Layout {
        TextView name;
        TextView price;
        Spinner quantity;
    }

    public ShoppingListAdapter(Context context, int resource, ArrayList<ShoppingCartEntity> lista) {
        super(context, resource, lista);

        this.context = context;
        this.resource = resource;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        Float price = getItem(position).getPrice();
        String quantity = getItem(position).getQuantity();
        code = getItem(position).getCode();

        Layout viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new Layout();
            viewHolder.name = (TextView) convertView.findViewById(R.id.NameShopping);
            viewHolder.quantity = (TextView) convertView.findViewById(R.id.QuantityShopping);
            viewHolder.price = (TextView) convertView.findViewById(R.id.PriceShopping);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Layout) convertView.getTag();
        }

        viewHolder.name.setText(name);
        viewHolder.quantity.setText(String.valueOf(quantity));
        viewHolder.price.setText(String.valueOf(price));

        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent article = new Intent(context, Article.class);
                article.putExtra("code", code);
                context.startActivity(article);
            }
        });

        return convertView;
    }
}