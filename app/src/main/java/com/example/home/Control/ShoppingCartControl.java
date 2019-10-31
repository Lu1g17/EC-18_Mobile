package com.example.home.Control;

import com.example.home.Entity.ShoppingCartEntity;

public class ShoppingCartControl {

    ShoppingCartEntity shoppingCart;

    public boolean add(String fiscalCode, String code, String nome, Float prezzo) {
        shoppingCart = new ShoppingCartEntity(fiscalCode, code, nome, prezzo);

        return shoppingCart.add();
    }
}
