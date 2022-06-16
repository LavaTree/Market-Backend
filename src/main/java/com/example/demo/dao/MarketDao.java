package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Item;
import com.example.demo.model.Market;

public interface MarketDao {
    
    int insertMarket(UUID id, Market market);

    default int insertMarket(Market market){
        UUID id = UUID.randomUUID();
        return insertMarket(id, market);
    }

    List<Market> selectAllMarkets();

    Market selectMarketById(UUID id);

    int deleteMarketById(UUID id);

    int addMarketItem(UUID id, Item item);

    int removeMarketItem(UUID id, String name);
}
