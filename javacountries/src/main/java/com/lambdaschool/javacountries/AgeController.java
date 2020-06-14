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
@RequestMapping("/age")
public class AgeController
{
    @GetMapping(value = "/age/{age}",
    produces = {"application/json"})
    public ResponseEntity<?> getByCountryAge(@PathVariable long age){
        List<Country> rtn = JavacountriesApplication.countryList.findCountriesByTester(c -> c.getAge() >= age );
        rtn.sort((c1,c2) -> (int)( c1.getId() - c2.getId()));
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
    produces = {"application/json"})
    public ResponseEntity<?> getByCountryMinAge(){
        Comparator<Country> sortCountries = Comparator.comparing(Country::getAge);
        JavacountriesApplication.countryList.countryList.sort(sortCountries);
        return new ResponseEntity<>(JavacountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getByCountryMaxAge(){
        Comparator<Country> sortCountries = Comparator.comparing(Country::getAge).reversed();
        JavacountriesApplication.countryList.countryList.sort(sortCountries);
        return new ResponseEntity<>(JavacountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }
}
