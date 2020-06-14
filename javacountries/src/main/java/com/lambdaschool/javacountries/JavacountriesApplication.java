package com.lambdaschool.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacountriesApplication
{
    public static CountryList countryList;

    public static void main(String[] args)
    {
        countryList = new CountryList();
        SpringApplication.run(JavacountriesApplication.class,
                args);
    }

}
