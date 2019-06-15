package com.spring.boot.service;

import com.spring.boot.dao.mapper.CountryMapper;
import com.spring.boot.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;

    public Country findByName(String name) {
        return countryMapper.findByName(name);
    }

    public int insert(String name,int id) {
        return countryMapper.insert(name,id);
    }

    public int delete(String name) {
        return countryMapper.delete(name);
    }

    public List<Country> getAllCountry() {
        return countryMapper.getAllCountry();
    }

}
