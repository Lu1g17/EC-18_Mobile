package com.example.home.Control;

import com.example.home.Entity.ClientEntity;
import com.example.home.RequiredFieldsException;

public class ClientControl {
    private ClientEntity client;

    public boolean create(String email, String password, String fiscalCode, String gender, String name, String surname, String birthDate, String birthNation, String birthProvince, String birthCity, String residenceNation, String residenceRegion, String residenceProvince, String residenceCity, String residenceCAP, String residenceAddress, String shippingNation, String shippingRegion, String shippingProvince, String shippingCity, String shippingCAP, String shippingAddress) throws RequiredFieldsException {
        client = new ClientEntity(email, password, fiscalCode, gender, name, surname, birthDate, birthNation, birthProvince, birthCity, residenceNation, residenceRegion, residenceProvince, residenceCity, residenceCAP, residenceAddress, shippingNation, shippingRegion, shippingProvince, shippingCity, shippingCAP, shippingAddress);

        return client.create();
    }

    public boolean update(String email, String password, String fiscalCode, String gender, String name, String surname, String birthDate, String birthNation, String birthProvince, String birthCity, String residenceNation, String residenceRegion, String residenceProvince, String residenceCity, String residenceCAP, String residenceAddress, String shippingNation, String shippingRegion, String shippingProvince, String shippingCity, String shippingCAP, String shippingAddress) throws RequiredFieldsException {
        client = new ClientEntity(email, password, fiscalCode, gender, name, surname, birthDate, birthNation, birthProvince, birthCity, residenceNation, residenceRegion, residenceProvince, residenceCity, residenceCAP, residenceAddress, shippingNation, shippingRegion, shippingProvince, shippingCity, shippingCAP, shippingAddress);

        return client.update();
    }

    public boolean checkEmail(String email) {
        client = new ClientEntity();

        return client.checkEmail(email);
    }

    public ClientEntity login(String email, String password) throws RequiredFieldsException {
        client = new ClientEntity();

        client.account.setEmail(email);
        client.account.setPassword(password);

        return client.login();
    }
}
