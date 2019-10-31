package com.example.home.Control;

import com.example.home.Entity.ShoppingCartEntity;

public class ShoppingCartControl {

    ShoppingCartEntity shoppingCart;

    public boolean add(String fiscalCode, String code) {
        shoppingCart = new ShoppingCartEntity(fiscalCode, code);

        return shoppingCart.add();
    }
}
