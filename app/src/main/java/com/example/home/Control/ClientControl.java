package com.example.home.Control;

import com.example.home.Entity.ClientEntity;
import com.example.home.RequiredFieldsException;

public class ClientControl {
    private ClientEntity client;

    /*public ClientEntity read(String fiscalCode) {
        client = new ClientEntity(fiscalCode);

        return client.read();
    }*/

    /*public boolean delete(String fiscalCode) {
        client = new ClientEntity(fiscalCode);

        return client.delete();
    }*/
    public ClientEntity login(String email, String password) throws RequiredFieldsException {
        client = new ClientEntity();

        System.out.println("\nEmail >" + email);
        System.out.println("\nPassword >" + password);
        client.account.setEmail(email);
        client.account.setPassword(password);

        return client.login();
    }
}
