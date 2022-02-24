package com.ankit.rest.webservices.demo.HelloWorld;


public class HelloWorld {
    private String message;

    public HelloWorld(String msg) {
        this.message=msg;
    }

    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
}