package com.example.OnlineBankingWebAppSpringMVC.service;

import java.util.ArrayList;

import com.example.OnlineBankingWebAppSpringMVC.entity.Admin;
import com.example.OnlineBankingWebAppSpringMVC.entity.Transcation;
public interface IBankingService{
    public boolean checkL(String adminId, String password);

    void addDetails(Admin admin);

    public ArrayList<Transcation> retrieveDaily();

    public ArrayList<Transcation> retrieveMonthly();

    public ArrayList<Transcation> retrieveQuarterly();

    public ArrayList<Transcation> retrieveYearly();
}
