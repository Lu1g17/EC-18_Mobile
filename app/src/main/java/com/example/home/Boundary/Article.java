package com.example.home.Boundary;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Control.ArticleControl;
import com.example.home.Entity.ArticleEntity;
import com.example.home.R;
import com.squareup.picasso.Picasso;

public class Article extends AppCompatActivity {

    String code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);

        code = getIntent().getExtras().getString("code");

        ArticleEntity article = new ArticleControl().read(code);

        ImageView attached = (ImageView) findViewById(R.id.ImageViewArticle);
        TextView code = (TextView) findViewById(R.id.GenderArticle);
        TextView gender = (TextView) findViewById(R.id.CodeArticle);
        TextView name = (TextView) findViewById(R.id.NameArticle);
        TextView brand = (TextView) findViewById(R.id.BrandArticle);
        TextView price = (TextView) findViewById(R.id.PriceArticle);
        TextView category = (TextView) findViewById(R.id.CategoryArticle);
        TextView type = (TextView) findViewById(R.id.TypeArticle);
        TextView size = (TextView) findViewById(R.id.SizeArticle);
        TextView quantity = (TextView) findViewById(R.id.QuantityArticle);
        TextView color = (TextView) findViewById(R.id.ColorArticle);
        TextView fit = (TextView) findViewById(R.id.FitArticle);
        TextView composition = (TextView) findViewById(R.id.CompositionArticle);
        TextView warnings = (TextView) findViewById(R.id.WarningsArticle);
        TextView description = (TextView) findViewById(R.id.DescriptionArticle);

        Picasso.with(this).load(article.getAttached()).into(attached);
        code.setText(article.getCode());
        gender.setText(article.getGender());
        name.setText(article.getName());
        brand.setText(article.getBrand());
        price.setText(String.valueOf(article.getPrice()));
        category.setText(article.getCategory());
        type.setText(article.getType());
        size.setText(article.getSize());
        quantity.setText(article.getQuantity());
        color.setText(article.getColor());
        fit.setText(article.getFit());
        composition.setText(article.getComposition());
        warnings.setText(article.getWarnings());
        description.setText(article.getDescription());
    }
}

