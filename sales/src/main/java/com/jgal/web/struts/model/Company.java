package com.jgal.web.struts.model;

public class Company {
    private Integer id;
    private String name;
    private String revenue;

    public Company(Integer id, String name, String revenue) {
        super();
        this.id = id;
        this.name = name;
        this.revenue = revenue;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRevenue() {
        return revenue;
    }
}
