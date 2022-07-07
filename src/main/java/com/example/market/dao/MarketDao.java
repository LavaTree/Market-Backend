package com.example.market.dao;

import java.util.List;
import java.util.UUID;

import com.example.market.model.Item;
import com.example.market.model.Market;

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

    int removeMarketItem(UUID id, UUID Iid);
}
