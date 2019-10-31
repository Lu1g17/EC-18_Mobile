package com.example.home.Entity;

import android.accounts.Account;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.home.RequiredFieldsException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.example.home.Boundary.MainActivity.autenticazione;
import static com.example.home.Boundary.MainActivity.dynamoDBMapper;

@DynamoDBTable(tableName = "User")
public class ClientEntity {

    public AccountEntity account;
    private String email, password, fiscalCode, gender, name, surname, birthDate, birthNation, birthProvince, birthCity, residenceNation, residenceRegion, residenceProvince, residenceCity, residenceCAP, residenceAddress, shippingNation, shippingRegion, shippingProvince, shippingCity, shippingCAP, shippingAddress;

    public ClientEntity() {
        account = new AccountEntity();

        gender = null;
        name = null;
        surname = null;
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

    public ClientEntity(String email, String password, String fiscalCode, String gender, String name, String surname, String birthDate, String birthNation, String birthProvince, String birthCity, String residenceNation, String residenceRegion, String residenceProvince, String residenceCity, String residenceCAP, String residenceAddress, String shippingNation, String shippingRegion, String shippingProvince, String shippingCity, String shippingCAP, String shippingAddress) {
        account = new AccountEntity(fiscalCode, email, password, "User");

        setFiscalCode(fiscalCode);
        setGender(gender);
        setName(name);
        setSurname(surname);
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
        setShippingNation(shippingNation);
        setShippingRegion(shippingRegion);
        setShippingProvince(shippingProvince);
        setShippingCity(shippingCity);
        setShippingCAP(shippingCAP);
        setShippingAddress(shippingAddress);
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

    public ClientEntity clone() {
        ClientEntity clone = new ClientEntity();

        clone.account = new AccountEntity(this.account.getFiscalCode(), this.account.getEmail(), this.account.getPassword(), "User");

        clone.setName(this.getName());
        clone.setSurname(this.getSurname());
        clone.setGender(this.getGender());
        clone.setBirthDate(this.getBirthDate());
        clone.setFiscalCode(this.getFiscalCode());
        clone.setBirthNation(this.getBirthNation());
        clone.setBirthProvince(this.getBirthProvince());
        clone.setBirthCity(this.getBirthCity());
        clone.setResidenceNation(this.getResidenceNation());
        clone.setResidenceRegion(this.getResidenceRegion());
        clone.setResidenceProvince(this.getResidenceProvince());
        clone.setResidenceCity(this.getResidenceCity());
        clone.setResidenceAddress(this.getResidenceAddress());
        clone.setResidenceCAP(this.getResidenceCAP());
        clone.setShippingNation(this.getShippingNation());
        clone.setShippingRegion(this.getShippingRegion());
        clone.setShippingProvince(this.getShippingProvince());
        clone.setShippingCity(this.getShippingCity());
        clone.setShippingAddress(this.getShippingAddress());
        clone.setShippingCAP(this.getShippingCAP());

        return clone;
    }

    public boolean create() throws RequiredFieldsException {
        final ClientEntity clone = this.clone();

        clone.checkRequiredFields();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dynamoDBMapper.save(clone);
                dynamoDBMapper.save(clone.account);
            }
        });

        t.start();

        try {
            t.join();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update() throws RequiredFieldsException {
        final ClientEntity clone = this.clone();

        clone.checkRequiredFields();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dynamoDBMapper.save(clone);
            }
        });

        t.start();

        try {
            t.join();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkEmail(String email) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(email));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("Email = :val1").withExpressionAttributeValues(eav);
        List<AccountEntity> lista = dynamoDBMapper.parallelScan(AccountEntity.class, scanExpression, 16);

        Iterator<AccountEntity> iteratore = lista.iterator();
        if (iteratore.hasNext())
            return false;
        else
            return true;
    }

    private void checkFields() throws RequiredFieldsException {
        if(account.getEmail() == null)
            throw new RequiredFieldsException("Email");
        if(account.getPassword() == null)
            throw new RequiredFieldsException("Password");
    }

    public void checkRequiredFields() throws RequiredFieldsException {
        if ((getName().equals("")) || (getName() == null))
            throw new RequiredFieldsException("Nome");
        if ((getSurname().equals("")) || (getSurname() == null))
            throw new RequiredFieldsException("Cognome");
        if ((getGender().equals("")) || (getGender() == null))
            throw new RequiredFieldsException("Sesso");
        if ((getBirthDate().equals("")) || (getBirthDate() == null))
            throw new RequiredFieldsException("Data di Nascita");
        if ((getFiscalCode().equals("")) || (getFiscalCode() == null))
            throw new RequiredFieldsException("Codice Fiscale");
        if ((getBirthNation().equals("")) || (getBirthNation() == null))
            throw new RequiredFieldsException("Nazione di Nascita");
        if ((getBirthProvince().equals("")) || (getBirthProvince() == null))
            throw new RequiredFieldsException("Provincia di Nascita");
        if ((getBirthCity().equals("")) || (getBirthCity() == null))
            throw new RequiredFieldsException("Città di Nascita");
        if ((getResidenceNation().equals("")) || (getResidenceNation() == null))
            throw new RequiredFieldsException("Nazione di Residenza");
        if ((getResidenceRegion().equals("")) || (getResidenceRegion() == null))
            throw new RequiredFieldsException("Regione di Residenza");
        if ((getResidenceProvince().equals("")) || (getResidenceProvince() == null))
            throw new RequiredFieldsException("Provincia di Residenza");
        if ((getResidenceCity().equals("")) || (getResidenceCity() == null))
            throw new RequiredFieldsException("Città di Residenza");
        if ((getResidenceAddress().equals("")) || (getResidenceAddress() == null))
            throw new RequiredFieldsException("Indirizzo di Residenza");
        if ((getResidenceCAP().equals("")) || (getResidenceCAP() == null))
            throw new RequiredFieldsException("CAP di Residenza");
    }

    public ClientEntity login() throws RequiredFieldsException {

        try {
            checkFields();

            Map<String, String> names = new HashMap<String, String>();
            names.put("#typ", "Type");

            Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
            eav.put(":val1", new AttributeValue().withS(account.getEmail()));
            eav.put(":val2", new AttributeValue().withS("User"));

            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("Email = :val1 and #typ = :val2").withExpressionAttributeNames(names).withExpressionAttributeValues(eav);
            List<AccountEntity> lista = dynamoDBMapper.parallelScan(AccountEntity.class, scanExpression, 16);

            Iterator<AccountEntity> iteratore = lista.iterator();
            if (iteratore.hasNext()) {
                final AccountEntity accountResult = iteratore.next();

                if (account.getPassword().equals(accountResult.getPassword())) {
                    final ClientEntity[] client = new ClientEntity[1];

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            client[0] = dynamoDBMapper.load(ClientEntity.class, accountResult.getFiscalCode());
                            client[0].account = accountResult;
                        }
                    });

                    t.start();

                    try {
                        t.join();
                    } catch (Exception e) {}

                    return client[0];
                }
            }
        } catch (RequiredFieldsException re) {
            System.err.println("Unable to check login because there are required fields not filled: ");
            System.err.println(re.getField());

            throw new RequiredFieldsException(re.getField());
        } catch (Exception e) {
            System.err.println("Unable to scan");
            System.err.println(e.getMessage());
        }

        return null;
    }
}
