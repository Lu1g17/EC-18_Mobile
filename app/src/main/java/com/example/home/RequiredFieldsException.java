package com.example.home;

public class RequiredFieldsException extends Exception {
    String message;
    String field;

    public RequiredFieldsException() {}
    public RequiredFieldsException(String field) {
        this.field = field;
        message = "Required field not filled: " + field;
    }

    public String getField() {
        return field;
    }
};
