package ru.yanes.car.parts.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import ru.yanes.car.parts.dao.CountryDAO;
import ru.yanes.car.parts.entity.Country;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryDAO countryDAO;

    @Transactional
    public Country getCountry(){return new Country();}
}
