package com.example.home.Control;


import com.example.home.Entity.ArticleEntity;

import java.util.ArrayList;

public class ArticleControl {
    private ArticleEntity article;

    public ArticleEntity read(String code) {
        article = new ArticleEntity(code);

        return article.read();
    }

    public ArrayList<ArticleEntity> getForegroundList() {
        article = new ArticleEntity();

        return article.getForegroundList();
    }

    public ArrayList<ArticleEntity> getList() {
        article = new ArticleEntity();

        return article.getList();
    }

    public ArrayList<ArticleEntity> getList(String name) {
        article = new ArticleEntity();

        return article.getList(name);
    }

    public ArrayList<ArticleEntity> getList(String gender, String category) {
        article = new ArticleEntity();

        return article.getList(gender, category);
    }
}
