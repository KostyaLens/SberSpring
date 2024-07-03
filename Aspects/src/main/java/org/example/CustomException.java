package org.example;

public class CustomException extends NullPointerException{
    CustomException(){}
    public CustomException(String msg){
        super(msg);
    }
}
