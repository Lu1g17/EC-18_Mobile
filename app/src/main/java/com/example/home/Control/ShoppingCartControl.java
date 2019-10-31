package com.example.home.Control;

import com.example.home.Entity.AccountEntity;
import com.example.home.Entity.ArticleEntity;
import com.example.home.Entity.ShoppingCartEntity;

import java.util.ArrayList;

public class ShoppingCartControl {

    ShoppingCartEntity shoppingCart;

    public boolean add(String fiscalCode, String code) {
        shoppingCart = new ShoppingCartEntity(fiscalCode, code);

        return shoppingCart.add();
    }

    public ArrayList<ArticleEntity> getList(String fiscalCode) {
        shoppingCart = new ShoppingCartEntity();

        return shoppingCart.getList(fiscalCode);
    }
}
