package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "User")
//@DynamoDBTable(tableName = "Account")

public class ClientEntity {

    private String fiscalCode, gender, name, surname, email, password, birthDate, birthNation, birthProvince, birthCity, residenceNation, residenceRegion, residenceProvince, residenceCity, residenceCAP, residenceAddress, shippingNation, shippingRegion, shippingProvince, shippingCity, shippingCAP, shippingAddress;

    public ClientEntity() {
        gender = null;
        name = null;
        surname = null;
        email = null;
        password = null;
        birthDate = null;
        birthNation = null;
        birthProvince = null;
        birthCity = null;
        residenceNation = null;
        residenceRegion = null;
        residenceProvince = null;
        residenceCity = null;
        residenceCAP = null;
        residenceAddress = null;
        shippingNation = null;
        shippingRegion = null;
        shippingProvince = null;
        shippingCity = null;
        shippingCAP = null;
        shippingAddress = null;
    }

    public ClientEntity(String fiscalCode, String gender, String name, String surname, String email, String password, String birthDate, String birthNation, String birthProvince, String birthCity, String residenceNation, String residenceRegion, String residenceProvince, String residenceCity, String residenceCAP, String residenceAddress, String shippingNation, String shippingRegion, String shippingProvince, String shippingCity, String shippingCAP, String shippingAddress) {
        setFiscalCode(fiscalCode);
        setGender(gender);
        setName(name);
        setSurname(surname);
        //setEmail(email);
        //setPassword(password);
        setBirthDate(birthDate);
        setBirthNation(birthNation);
        setBirthProvince(birthProvince);
        setBirthCity(birthCity);
        setResidenceNation(residenceNation);
        setResidenceRegion(residenceRegion);
        setResidenceProvince(residenceProvince);
        setResidenceCity(residenceCity);
        setResidenceCAP(residenceCAP);
        setResidenceAddress(residenceAddress);
        setShippingNation(residenceNation);
        setShippingRegion(residenceRegion);
        setShippingProvince(residenceProvince);
        setShippingCity(residenceCity);
        setShippingCAP(residenceCAP);
        setShippingAddress(residenceAddress);
    }

    public ClientEntity(String fiscalCode) {
        setFiscalCode(fiscalCode);
    }

    @DynamoDBAttribute(attributeName = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null)
            this.gender = "Non definito";
        else
            this.gender = gender;
    }

    @DynamoDBAttribute(attributeName = "Nominative")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            this.name = "Non definito";
        else
            this.name = name;
    }

    @DynamoDBAttribute(attributeName = "Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null)
            this.surname = "Non definito";
        else
            this.surname = surname;
    }

    /*@DynamoDBAttribute(attributeName = "Email") //E' un campo di account non di user
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null)
            this.email = "Non definito";
        else
            this.email = email;
    }*/

    @DynamoDBAttribute(attributeName = "BirthDate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate == null)
            this.birthDate = "Non definito";
        else
            this.birthDate = birthDate;
    }

    /*@DynamoDBAttribute(attributeName = "Password") //E' un campo di account non di user
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null)
            this.password = "Non definito";
        else
            this.password = password;
    }*/

    @DynamoDBHashKey(attributeName = "FiscalCode")
    @DynamoDBAttribute(attributeName = "FiscalCode")
    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        if (fiscalCode == null)
            this.fiscalCode = "Non definito";
        else
            this.fiscalCode = fiscalCode;
    }

    @DynamoDBAttribute(attributeName = "BirthNation")
    public String getBirthNation() {
        return birthNation;
    }

    public void setBirthNation(String birthNation) {
        if (birthNation == null)
            this.birthNation = "Non definito";
        else
            this.birthNation = birthNation;
    }

    @DynamoDBAttribute(attributeName = "BirthProvince")
    public String getBirthProvince() {
        return birthProvince;
    }

    public void setBirthProvince(String birthProvince) {
        if (birthProvince == null)
            this.birthProvince = "Non definito";
        else
            this.birthProvince = birthProvince;
    }

    @DynamoDBAttribute(attributeName = "BirthCity")
    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        if (birthCity == null)
            this.birthCity = "Non definito";
        else
            this.birthCity = birthCity;
    }

    @DynamoDBAttribute(attributeName = "ResidenceNation")
    public String getResidenceNation() {
        return residenceNation;
    }

    public void setResidenceNation(String residenceNation) {
        if (residenceNation == null)
            this.residenceNation = "Non definito";
        else
            this.residenceNation = residenceNation;
    }

    @DynamoDBAttribute(attributeName = "ResidenceRegion")
    public String getResidenceRegion() {
        return residenceRegion;
    }

    public void setResidenceRegion(String residenceRegion) {
        if (residenceRegion == null)
            this.residenceRegion = "Non definito";
        else
            this.residenceRegion = residenceRegion;
    }

    @DynamoDBAttribute(attributeName = "ResidenceProvince")
    public String getResidenceProvince() {
        return residenceProvince;
    }

    public void setResidenceProvince(String residenceProvince) {
        if (residenceProvince == null)
            this.residenceProvince = "Non definito";
        else
            this.residenceProvince = residenceProvince;
    }

    @DynamoDBAttribute(attributeName = "ResidenceCity")
    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        if (residenceCity == null)
            this.residenceCity = "Non definito";
        else
            this.residenceCity = residenceCity;
    }

    @DynamoDBAttribute(attributeName = "ResidenceCAP")
    public String getResidenceCAP() {
        return residenceCAP;
    }

    public void setResidenceCAP(String residenceCAP) {
        if (residenceCAP == null)
            this.residenceCAP = "Non definito";
        else
            this.residenceCAP = residenceCAP;
    }

    @DynamoDBAttribute(attributeName = "ResidenceAddress")
    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        if (residenceAddress == null)
            this.residenceAddress = "Non definito";
        else
            this.residenceAddress = residenceAddress;
    }

    @DynamoDBAttribute(attributeName = "ShippingNation")
    public String getShippingNation() {
        return shippingNation;
    }

    public void setShippingNation(String shippingNation) {
        if (shippingNation == null)
            this.shippingNation = "Non definito";
        else
            this.shippingNation = shippingNation;
    }

    @DynamoDBAttribute(attributeName = "ShippingRegion")
    public String getShippingRegion() {
        return shippingRegion;
    }

    public void setShippingRegion(String shippingRegion) {
        if (shippingRegion == null)
            this.shippingRegion = "Non definito";
        else
            this.shippingRegion = shippingRegion;
    }

    @DynamoDBAttribute(attributeName = "ShippingProvince")
    public String getShippingProvince() {
        return shippingProvince;
    }

    public void setShippingProvince(String shippingProvince) {
        if (shippingProvince == null)
            this.shippingProvince = "Non definito";
        else
            this.shippingProvince = shippingProvince;
    }

    @DynamoDBAttribute(attributeName = "ShippingCity")
    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        if (shippingCity == null)
            this.shippingCity = "Non definito";
        else
            this.shippingCity = shippingCity;
    }

    @DynamoDBAttribute(attributeName = "ShippingCAP")
    public String getShippingCAP() {
        return shippingCAP;
    }

    public void setShippingCAP(String shippingCAP) {
        if (shippingCAP == null)
            this.shippingCAP = "Non definito";
        else
            this.shippingCAP = shippingCAP;
    }

    @DynamoDBAttribute(attributeName = "ShippingAddress")
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        if (shippingAddress == null)
            this.shippingAddress = "Non definito";
        else
            this.shippingAddress = shippingAddress;
    }

    /*public ClientEntity read() {
        Table table = dynamoDB.getTable("User");
        Table tableAccount = dynamoDB.getTable("Account");

        try {
            GetItemSpec spec = new GetItemSpec().withPrimaryKey("FiscalCode", this.fiscalCode);
            GetItemSpec specAccount = new GetItemSpec().withPrimaryKey("FiscalCode", this.fiscalCode);

            System.out.println("Attempting to read the item...");
            Item outcome = table.getItem(spec);
            Item outcomeAccount = tableAccount.getItem(specAccount);
            System.out.println("GetItem succeeded: " + outcome + outcomeAccount);

            this.fiscalCode = outcome.getString("FiscalCode");
            this.gender = outcome.getString("Gender");
            this.name = outcome.getString("Nominative");
            this.surname = outcome.getString("Surname");
            this.email = outcomeAccount.getString("Email");
            this.password = outcomeAccount.getString("Password");
            this.birthDate = outcome.getString("BirthDate");
            this.birthNation = outcome.getString("BirthNation");
            this.birthProvince = outcome.getString("BirthProvince");
            this.birthCity = outcome.getString("BirthCity");
            this.residenceNation = outcome.getString("ResidenceNation");
            this.residenceRegion = outcome.getString("ResidenceRegion");
            this.residenceProvince = outcome.getString("ResidenceProvince");
            this.residenceCity = outcome.getString("ResidenceCity");
            this.residenceCAP = outcome.getString("ResidenceCAP");
            this.residenceAddress = outcome.getString("ResidenceAddress");
            this.shippingNation = outcome.getString("ShippingNation");
            this.shippingRegion = outcome.getString("ShippingRegion");
            this.shippingProvince = outcome.getString("ShippingProvince");
            this.shippingCity = outcome.getString("ShippingCity");
            this.shippingCAP = outcome.getString("ShippingCAP");
            this.shippingAddress = outcome.getString("ShippingAddress");

            return this;
        } catch (Exception e) {
            System.err.println("Unable to read item: " + this.fiscalCode);
            System.err.println(e.getMessage());
        }

        return null;
    }*/

    /*public boolean delete() {
        Table table = dynamoDB.getTable("User");
        Table tableAccount = dynamoDB.getTable("Account");

        try {
            DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("FiscalCode", fiscalCode);
            DeleteItemSpec deleteItemSpecAccount = new DeleteItemSpec().withPrimaryKey("FiscalCode", fiscalCode);

            System.out.println("Attempting article conditional delete...");
            DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
            DeleteItemOutcome outcomeAccount = tableAccount.deleteItem(deleteItemSpecAccount);
            System.out.println("DeleteItem succeeded");

            return true;
        } catch (Exception e) {
            System.err.println("Unable to delete item: " + fiscalCode);
            System.err.println(e.getMessage());
        }

        return false;
    }*/
}
