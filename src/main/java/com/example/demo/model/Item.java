package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    

    private String name;
    private double price;

    public Item(@JsonProperty String name){
        this.name = name;
        price = 0;
    }

    public Item(@JsonProperty String name, 
                @JsonProperty double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getDouble(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }

}
