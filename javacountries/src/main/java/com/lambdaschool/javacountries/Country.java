package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private long landmass;
    private long age;


    public Country(String name,
                   long population,
                   long landmass,
                   long age)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landmass = landmass;
        this.age = age;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandmass()
    {
        return landmass;
    }

    public void setLandmass(long landmass)
    {
        this.landmass = landmass;
    }

    public long getAge()
    {
        return age;
    }

    public void setAge(long age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landmass=" + landmass +
                ", age=" + age +
                '}';
    }
}
