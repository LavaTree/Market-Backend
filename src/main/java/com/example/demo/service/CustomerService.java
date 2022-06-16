package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService (@Qualifier("cusDao") CustomerDao customerDao){
        this.customerDao = customerDao;
    }
    
    public int addPerson (Customer customer){
        return customerDao.insertPerson(customer);
    }

    public List<Customer> getAllPeople(){
        return customerDao.selectAllPeople();
    }

    public Customer getPersonById(UUID id){
        return customerDao.selectPersonById(id);
    }

    public int removePerson (UUID id){
        return customerDao.deletePersonById(id);
    }

    public int changePersonName (UUID id, String name){
        return customerDao.updatePersonName(id, name);
    }

    public int increaseBalanceById (UUID id, double balance){
        return customerDao.addBalanceById(id, balance);
    }

    
    public int decreaseBalanceById (UUID id, double balance){
        return customerDao.subBalanceById(id, balance);
    }

}
