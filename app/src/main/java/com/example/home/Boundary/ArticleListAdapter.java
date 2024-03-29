package com.example.home.Boundary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.home.Entity.ArticleEntity;
import com.example.home.R;
import java.util.ArrayList;
import com.squareup.picasso.Picasso;

public class ArticleListAdapter extends ArrayAdapter<ArticleEntity> {

    private Context context;
    private int resource;
    private ArrayList<ArticleEntity> lista;
    public String code;

    private static class Layout {
        TextView name;
        TextView brand;
        TextView price;
        ImageView attached;
    }

    public ArticleListAdapter(Context context, int resource, ArrayList<ArticleEntity> lista){
        super(context, resource, lista);

        this.context = context;
        this.resource = resource;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String brand = getItem(position).getBrand();
        Float price = getItem(position).getPrice();
        String attached = getItem(position).getAttached();
        code = getItem(position).getCode();

        Layout viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new Layout();
            viewHolder.name = (TextView)convertView.findViewById(R.id.NameCatalog);
            viewHolder.brand = (TextView)convertView.findViewById(R.id.BrandCatalog);
            viewHolder.price = (TextView)convertView.findViewById(R.id.PriceCatalog);
            viewHolder.attached = (ImageView) convertView.findViewById(R.id.ImageViewCatalog);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Layout) convertView.getTag();
        }

        viewHolder.name.setText(name);
        viewHolder.brand.setText(brand);
        viewHolder.price.setText(String.valueOf(price));
        Picasso.with(context).load(attached).into(viewHolder.attached);

        viewHolder.attached.setOnClickListener(new View.OnClickListener(){
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
