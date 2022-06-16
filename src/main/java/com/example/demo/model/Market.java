package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Market {
    
    private final UUID id;
    private final String name;
    private List<Item> offers = new ArrayList<>();

    public Market (@JsonProperty("id") UUID id, 
                   @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item){
        offers.add(item);
    }

    public void removeItemByName(String name){
        for (int i = 0; i < offers.size(); i++){
            if (offers.get(i).getName().equals(name)) offers.remove(i);
        }
    }

    public List<Item> getOffers(){
        return offers;
    }
    
}
