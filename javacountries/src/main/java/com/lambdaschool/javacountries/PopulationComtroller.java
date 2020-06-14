package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("population")
public class PopulationComtroller
{

    @GetMapping(value = "/size/{people}",
    produces = {"application/json"})
    public ResponseEntity<?> getByPopulation(@PathVariable long people){
        Comparator<Country> sortCountries = Comparator.comparing(Country::getName);
        List<Country> rtn = new ArrayList<>();
        rtn = JavacountriesApplication.countryList.findCountriesByTester(c -> c.getPopulation() >= people);
        rtn.sort(sortCountries);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopCountry(){
        Comparator<Country> sortCountries = Comparator.comparing(Country::getPopulation);
        JavacountriesApplication.countryList.countryList.sort(sortCountries);
        return new ResponseEntity<>(JavacountriesApplication.countryList.countryList.get(0),HttpStatus.OK);
    }
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopCountry(){
        Comparator<Country> sortCountries = Comparator.comparing(Country::getPopulation).reversed();
        JavacountriesApplication.countryList.countryList.sort(sortCountries);
        return new ResponseEntity<>(JavacountriesApplication.countryList.countryList.get(0),HttpStatus.OK);
    }

    @GetMapping(value = "/median",
    produces = {"application/json"})
    public ResponseEntity<?> getMedianCountry(){
        double n = (JavacountriesApplication.countryList.countryList.size()) / 2;
//        n = (int)Math.floor(n);
        JavacountriesApplication.countryList.countryList.sort((c1,c2)-> (int)(c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(JavacountriesApplication.countryList.countryList.get((int)n + 1),HttpStatus.OK);
    }


}
