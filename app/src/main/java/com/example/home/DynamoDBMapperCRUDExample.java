package com.example.home;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import static com.example.home.MainActivity.dynamoDBMapper;

public class DynamoDBMapperCRUDExample{

    @DynamoDBTable(tableName = "Article")
    public static class ArticleItem{
        private String code, gender, name, brand, category, type, size, quantity, color, fit, composition, warnings, description, attached;
        private Float price;

        @DynamoDBHashKey(attributeName = "Code")
        @DynamoDBAttribute(attributeName = "Code")
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @DynamoDBAttribute(attributeName = "Title")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @DynamoDBAttribute(attributeName = "Price")
        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        @DynamoDBAttribute(attributeName = "Gender")
        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @DynamoDBAttribute(attributeName = "Brand")
        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        @DynamoDBAttribute(attributeName = "Category")
        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @DynamoDBAttribute(attributeName = "Typology")
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @DynamoDBAttribute(attributeName = "Size")
        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        @DynamoDBAttribute(attributeName = "Quantity")
        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        @DynamoDBAttribute(attributeName = "Color")
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @DynamoDBAttribute(attributeName = "Fit")
        public String getFit() {
            return fit;
        }

        public void setFit(String fit) {
            this.fit = fit;
        }

        @DynamoDBAttribute(attributeName = "Composition")
        public String getComposition() {
            return composition;
        }

        public void setComposition(String composition) {
            this.composition = composition;
        }

        @DynamoDBAttribute(attributeName = "Warnings")
        public String getWarnings() {
            return warnings;
        }

        public void setWarnings(String warnings) {
            this.warnings = warnings;
        }

        @DynamoDBAttribute(attributeName = "Description")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @DynamoDBAttribute(attributeName = "Attached")
        public String getAttached() {
            return attached;
        }

        public void setAttached(String attached) {
            this.attached = attached;
        }
    }

    public static void aggiungi() {
        /*final ArticleItem articolo = new ArticleItem();
        articolo.setId(17);
        articolo.setTitle("La Teoria del Tutto");*/

        //DynamoDBMapper mapper = new DynamoDBMapper(client);
        //mapper.save(articolo);

        //dynamoDBMapper.save(articolo);

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                dynamoDBMapper.save(articolo);
                // Item saved
            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {

                ArticleItem[] lista = new ArticleItem[10];
                lista[0] = dynamoDBMapper.load(ArticleItem.class,"7899");


                System.out.println("QUESTO È L'ITEM CON CODICE" + lista[0].code + ": >" + lista[0].brand);
                // Item read
                // Log.d("News Item:", newsItem.toString());
            }
        }).start();
    }

}
