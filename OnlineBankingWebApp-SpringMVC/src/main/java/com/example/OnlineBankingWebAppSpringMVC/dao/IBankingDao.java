package com.example.OnlineBankingWebAppSpringMVC.dao;
import java.util.ArrayList;

import com.example.OnlineBankingWebAppSpringMVC.entity.Admin;
import com.example.OnlineBankingWebAppSpringMVC.entity.Transcation;

public interface IBankingDao {
    void addDetails(Admin admin);

    ArrayList<Transcation> retrieveDaily();

    ArrayList<Transcation> retrieveMonthly();

    ArrayList<Transcation> retrieveQuarterly();

    ArrayList<Transcation> retrieveYearly();
}
