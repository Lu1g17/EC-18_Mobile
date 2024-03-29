package com.example.home.Entity;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.home.Boundary.Article;
import com.example.home.RequiredFieldsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

import static com.example.home.Boundary.MainActivity.dynamoDBMapper;
import static java.lang.Thread.sleep;

@DynamoDBTable(tableName = "Article")
public class ArticleEntity {
        private String code, gender, name, brand, category, type, size, quantity, color, fit, composition, warnings, description, attached;
        private Float price;

        public ArticleEntity() {
            code = null;
            gender = null;
            name = null;
            brand = null;
            price = null;
            category = null;
            type = null;
            size = null;
            quantity = null;
            color = null;
            fit = null;
            composition = null;
            warnings = null;
            description = null;
            attached = null;
        }

        public ArticleEntity(String code, String gender, String name, String brand, Float price, String category, String type, String size, String quantity, String color, String fit, String composition, String warnings, String description, String attached) {
            setCode(code);
            setGender(gender);
            setName(name);
            setBrand(brand);
            setPrice(price);
            setCategory(category);
            setType(type);
            setSize(size);
            setQuantity(quantity);
            setColor(color);
            setFit(fit);
            setComposition(composition);
            setWarnings(warnings);
            setDescription(description);
            setAttached(attached);
        }

        public ArticleEntity(String code) {
            setCode(code);
        }

        @DynamoDBHashKey(attributeName = "Code")
        @DynamoDBAttribute(attributeName = "Code")
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            if (code == null)
                this.code = "Non definito";
            else
                this.code = code;
        }

        @DynamoDBAttribute(attributeName = "Title")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null)
                this.name = "Non definito";
            else
                this.name = name;
        }

        @DynamoDBAttribute(attributeName = "Price")
        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            if (price == null)
                this.price = new Float(0);
            else
                this.price = price;
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

        @DynamoDBAttribute(attributeName = "Brand")
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            if (brand == null)
                this.brand = "Non definito";
            else
                this.brand = brand;
        }

        @DynamoDBAttribute(attributeName = "Category")
        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            if (category == null)
                this.category = "Non definito";
            else
                this.category = category;
        }

        @DynamoDBAttribute(attributeName = "Typology")
        public String getType() {
            return type;
        }

        public void setType(String type) {
            if (type == null)
                this.type = "Non definito";
            else
                this.type = type;
        }

        @DynamoDBAttribute(attributeName = "Size")
        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            if (size == null)
                this.size = "Non definito";
            else
                this.size = size;
        }

        @DynamoDBAttribute(attributeName = "Quantity")
        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            if (quantity == null)
                this.quantity = "Non definito";
            else
                this.quantity = quantity;
        }

        @DynamoDBAttribute(attributeName = "Color")
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            if (color == null)
                this.color = "Non definito";
            else
                this.color = color;
        }

        @DynamoDBAttribute(attributeName = "Fit")
        public String getFit() {
            return fit;
        }

        public void setFit(String fit) {
            if (fit == null)
                this.fit = "Non definito";
            else
                this.fit = fit;
        }

        @DynamoDBAttribute(attributeName = "Composition")
        public String getComposition() {
            return composition;
        }

        public void setComposition(String composition) {
            if (composition == null)
                this.composition = "Non definito";
            else
                this.composition = composition;
        }

        @DynamoDBAttribute(attributeName = "Warnings")
        public String getWarnings() {
            return warnings;
        }

        public void setWarnings(String warnings) {
            if (warnings == null)
                this.warnings = "Non definito";
            else
                this.warnings = warnings;
        }

        @DynamoDBAttribute(attributeName = "Description")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            if (description == null)
                this.description = "Non definito";
            else
                this.description = description;
        }

        @DynamoDBAttribute(attributeName = "Attached")
        public String getAttached() {
            return attached;
        }

        public void setAttached(String attached) {
            if (attached == null)
                this.attached = "Non definito";
            else
                this.attached = attached;
        }

        public void checkRequiredFields() throws RequiredFieldsException {
            if (getCode().equals("Non definito"))
                throw new RequiredFieldsException("Codice Articolo");
            if (getGender().equals("Non definito"))
                throw new RequiredFieldsException("Genere");
            if (getName().equals("Non definito"))
                throw new RequiredFieldsException("Nome");
            if (getBrand().equals("Non definito"))
                throw new RequiredFieldsException("Marca");
            if (getPrice().equals("Non definito"))
                throw new RequiredFieldsException("Prezzo");
            if (getCategory().equals("Non definito"))
                throw new RequiredFieldsException("Categoria");
            if (getType().equals("Non definito"))
                throw new RequiredFieldsException("Tipo");
            if (getSize().equals("Non definito"))
                throw new RequiredFieldsException("Taglia");
            if (getQuantity().equals("Non definito"))
                throw new RequiredFieldsException("Quantità");
        }

    /*public boolean create() throws RequiredFieldsException {
        Table table = dynamoDB.getTable("Article");

        try {
            checkRequiredFields();

            System.out.println("Adding article new item...");
            PutItemOutcome outcome = table.putItem(new Item().withPrimaryKey("Code", code).withString("Gender", gender).withString("Title", name)
                    .withString("Brand", brand).withFloat("Price", price).withString("Category", category).withString("Typology", type)
                    .withString("Size", size).withString("Quantity", quantity).withString("Color", color).withString("Fit", fit)
                    .withString("Composition", composition).withString("Warnings", warnings).withString("Description", description).withString("Attached", attached));
            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

            return true;
        } catch (RequiredFieldsException re) {
            System.err.println("Unable to add item " + code + " because there are required fields not filled: ");
            System.err.println(re.getMessage());

            throw new RequiredFieldsException(re.getField());
        } catch (Exception e) {
            System.err.println("Unable to add item: " + code);
            System.err.println(e.getMessage());
        }

        return false;
    }*/

    public ArticleEntity read() {
        final ArticleEntity[] article = new ArticleEntity[1];

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                article[0] = dynamoDBMapper.load(ArticleEntity.class, code);
            }
        });

        t.start();

        try {
            t.join();
        } catch (Exception e) {

        }

        return article[0];
    }

    public ArrayList<ArticleEntity> getForegroundList() {
        final ArrayList<ArticleEntity> lista = new ArrayList<ArticleEntity>();

        Float price = new Float(80.0);

        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withN(Float.toString(price)));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("Price < :val1").withExpressionAttributeValues(eav);
        List<ArticleEntity> li = dynamoDBMapper.parallelScan(ArticleEntity.class, scanExpression, 16);

        lista.addAll(li);

        return lista;
    }

    public ArrayList<ArticleEntity> getList() {
        final ArrayList<ArticleEntity> lista = new ArrayList<ArticleEntity>();

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<ArticleEntity> li = dynamoDBMapper.parallelScan(ArticleEntity.class, scanExpression, 16);

        lista.addAll(li);

        return lista;
    }

    public ArrayList<ArticleEntity> getList(String name) {
        final ArrayList<ArticleEntity> lista = new ArrayList<ArticleEntity>();

        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(name));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("Title = :val1").withExpressionAttributeValues(eav);
        List<ArticleEntity> li = dynamoDBMapper.parallelScan(ArticleEntity.class, scanExpression, 16);

        lista.addAll(li);

        return lista;
    }

    public ArrayList<ArticleEntity> getList(String gender, String catgeory) {
        final ArrayList<ArticleEntity> lista = new ArrayList<ArticleEntity>();

        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(gender));
        eav.put(":val2", new AttributeValue().withS(catgeory));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("Gender = :val1 and Category = :val2").withExpressionAttributeValues(eav);
        List<ArticleEntity> li = dynamoDBMapper.parallelScan(ArticleEntity.class, scanExpression, 16);

        lista.addAll(li);

        return lista;
    }
}