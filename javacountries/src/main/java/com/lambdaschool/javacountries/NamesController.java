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
@RequestMapping("/names")
public class NamesController
{
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries(){
        Comparator<Country> sortCountry = Comparator.comparing(Country::getName);
        JavacountriesApplication.countryList.countryList.sort(sortCountry);

        return new ResponseEntity<>(JavacountriesApplication.countryList.countryList,
                HttpStatus.OK);

    }
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getByLetter(@PathVariable char letter){
        List<Country> rtn = JavacountriesApplication.countryList.findCountriesByTester(c -> c.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter));
        Comparator<Country> sortCountries = Comparator.comparing(Country::getName);
        rtn.sort(sortCountries);
        return new ResponseEntity<>(rtn,HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
    produces = {"application/json"})
    public ResponseEntity<?> getByNameSize(@PathVariable int number){
        Comparator<Country> sortCountries = Comparator.comparing(Country::getName);
        List<Country> rtn = JavacountriesApplication.countryList.findCountriesByTester(c -> c.getName().length() >= number);
        rtn.sort(sortCountries);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

}
