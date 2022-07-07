package com.example.market.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.market.model.Item;
import com.example.market.model.Market;

@Repository("marDao")
public class MarketDataAccessService implements MarketDao{

    public static List<Market> DB = new ArrayList<>();
    
    @Override
    public int insertMarket (UUID id, Market market){
        DB.add(new Market(id, market.getName()));
        return 1;
    }

    @Override
    public List<Market> selectAllMarkets(){
        return DB;
    }

    @Override
    public Market selectMarketById(UUID id) {
        for (Market market : DB){
            if (id.equals(market.getId())){
                return market;
            }
        }
        return null;
    }

    @Override
    public int deleteMarketById(UUID id) {
        if (selectMarketById(id) == null) return 0;
        DB.remove(selectMarketById(id));
        return 1;
    }

    @Override
    public int addMarketItem(UUID id, Item item) {
        if (selectMarketById(id) == null) return 0;
        selectMarketById(id).addItem(item);
        return 1;
    }

    @Override
    public int removeMarketItem(UUID id, UUID Iid) {
        if (selectMarketById(id) == null) return 0;
        selectMarketById(id).removeItemByID(Iid);
        return 1;
    }

}
