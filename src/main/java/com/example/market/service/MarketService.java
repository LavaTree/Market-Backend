package com.example.market.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.market.dao.MarketDao;
import com.example.market.model.Item;
import com.example.market.model.Market;

@Service
public class MarketService {

    private final MarketDao marketDao;

    @Autowired
    public MarketService (@Qualifier("marDao") MarketDao marketDao){
        this.marketDao = marketDao;
    }
    
    public int addMarket (Market market){
        return marketDao.insertMarket(market);
    }

    public List<Market> getAllMarkets(){
        return marketDao.selectAllMarkets();
    }

    public Market getMarketById(UUID id){
        return marketDao.selectMarketById(id);
    }

    public int removeMarket (UUID id){
        return marketDao.deleteMarketById(id);
    }

    public int addItem(UUID id, Item item){
        return marketDao.addMarketItem(id, item);
    }

    public int removeItem(UUID id, UUID Iid){
        return marketDao.removeMarketItem(id, Iid);
    }

}
