package com.example.OnlineBankingWebAppSpringMVC.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineBankingWebAppSpringMVC.dao.IBankingDao;
import com.example.OnlineBankingWebAppSpringMVC.entity.Admin;
import com.example.OnlineBankingWebAppSpringMVC.entity.Transcation;

@Service
@Transactional
public class BankingServiceImpl implements IBankingService{
    @Autowired
    IBankingDao dao;
    @Override
    public boolean checkL(String adminId, String password)
    {
        if(adminId.equals("admin") && password.equals("123"))
        {

            return true;
        }
        else
        {


            return false;
        }

    }

    @Override
    public void addDetails(Admin admin) {
        dao.addDetails(admin);
    }

    @Override
    public ArrayList<Transcation> retrieveDaily() {

        return dao.retrieveDaily();
    }

    @Override
    public ArrayList<Transcation> retrieveMonthly() {

        return dao.retrieveMonthly();
    }

    @Override
    public ArrayList<Transcation> retrieveQuarterly() {

        return dao.retrieveQuarterly();
    }

    @Override
    public ArrayList<Transcation> retrieveYearly() {

        return dao.retrieveYearly();
    }
}
