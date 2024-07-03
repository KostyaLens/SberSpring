package org.example;

public class NoClientsException extends Exception{
    NoClientsException(){}

    NoClientsException(String msg){
        super(msg);
    }
}
