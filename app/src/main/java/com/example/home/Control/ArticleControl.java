package com.example.home.Control;


import com.example.home.Entity.ArticleEntity;

import java.util.ArrayList;

public class ArticleControl {
    private ArticleEntity article;

    /*public boolean create(String code, String gender, String name, String brand, Float price, String category, String type, String size, String quantity, String color, String fit, String composition, String warnings, String description, String attached) throws RequiredFieldsException {
        article = new ArticleEntity(code, gender, name, brand, price, category, type, size, quantity, color, fit, composition, warnings, description, attached);

        return article.create();
    }*/

    /*public ArticleEntity read(String code) {
        article = new ArticleEntity(code);

        return article.read();
    }*/

    /*public boolean update(String code, String gender, String name, String brand, Float price, String category, String type, String size, String quantity, String color, String fit, String composition, String warnings, String description, String attached) throws RequiredFieldsException {
        article = new ArticleEntity(code, gender, name, brand, price, category, type, size, quantity, color, fit, composition, warnings, description, attached);

        return article.update();
    }*/

    /*public boolean delete(String code) {
        article = new ArticleEntity(code);

        return article.delete();
    }*/

    public ArrayList<ArticleEntity> getList() {
        article = new ArticleEntity();

        return article.getList();
    }
}
