package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.model.Market;
import com.example.demo.service.MarketService;

@RequestMapping("api/v1/market")
@RestController
public class MarketController {
    
    private final MarketService marketService;

    @Autowired
    public MarketController (MarketService marketService){
        this.marketService = marketService;
    }

    @PostMapping
    public void addMarket(@RequestBody Market market){
        marketService.addMarket(market);
    }

    @GetMapping
    public List<Market> getAllMarkets(){
        return marketService.getAllMarkets();
    }

    @GetMapping(path = "{id}")
    public Market getMarketByID(@PathVariable UUID id){
        return marketService.getMarketById(id);
    }

    @DeleteMapping(path = "{id}")
    public int removeMarket(@PathVariable UUID id){
        return marketService.removeMarket(id);
    }

    @PostMapping(path = "{id}/item")
    public int addItemById(@PathVariable UUID id, @RequestBody Item item){
        return marketService.addItem(id, item);
    }

    @DeleteMapping(path = "{id}/item/{name}")
    public int removeItemById(@PathVariable UUID id, @PathVariable String name){
        return marketService.removeItem(id, name);
    }


}
