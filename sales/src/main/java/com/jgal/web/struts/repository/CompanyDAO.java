package com.jgal.web.struts.repository;

import com.jgal.web.struts.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Company> getCompanies() {
        return jdbcTemplate.query("SELECT id, name, revenue FROM customers",
            (rs, rowNum) -> new Company(rs.getInt("id"), rs.getString("name"), rs.getString("revenue")));
    }

    public void insertBatch() {
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, name VARCHAR(255), revenue VARCHAR(10))");
        jdbcTemplate.batchUpdate("INSERT INTO customers(name, revenue) VALUES (?,?)", customerData());
    }

    private List<Object[]> customerData() {
        List<Object[]> users = new ArrayList<>();
        users.add("MicroSoft 25000".split(" "));
        users.add("Apple 23000".split(" "));
        return users;
    }

}
