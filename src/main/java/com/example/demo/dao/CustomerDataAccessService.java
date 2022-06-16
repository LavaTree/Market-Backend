package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository("cusDao")
public class CustomerDataAccessService implements CustomerDao{

    public static List<Customer> DB = new ArrayList<>();
    
    @Override
    public int insertPerson (UUID id, Customer person){
        DB.add(new Customer(id, person.getName(), 0));
        return 1;
    }

    @Override
    public List<Customer> selectAllPeople(){
        return DB;
    }

    @Override
    public Customer selectPersonById(UUID id) {
        for (Customer person : DB){
            if (id.equals(person.getId())){
                return person;
            }
        }
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        if (selectPersonById(id) == null) return 0;
        DB.remove(selectPersonById(id));
        return 1;
    }

    @Override
    public int updatePersonName(UUID id, String name) {
        if (DB.indexOf(selectPersonById(id)) < 0) return 0;
        selectPersonById(id).setName(name);
        return 1;
    }

    @Override
    public int addBalanceById(UUID id, double amount) {
        if (DB.indexOf(selectPersonById(id)) < 0) return 0;
        selectPersonById(id).addBalance(amount);
        return 1;
    }

    @Override
    public int subBalanceById(UUID id, double amount) {
        if (DB.indexOf(selectPersonById(id)) < 0 || selectPersonById(id).getBalance() < amount) return 0;
        selectPersonById(id).subBalance(amount);
        return 1;
    }
}
