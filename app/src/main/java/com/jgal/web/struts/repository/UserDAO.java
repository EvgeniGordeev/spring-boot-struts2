package com.jgal.web.struts.repository;

import com.jgal.web.struts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT id, first_name, last_name, age, gender FROM users",
            (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("age"), rs.getString("gender")));
    }

    public void insertBatch() {
        jdbcTemplate.execute("DROP TABLE users IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE users(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), age VARCHAR(3), gender VARCHAR(1))");
        jdbcTemplate.batchUpdate("INSERT INTO users(first_name, last_name, age, gender) VALUES (?,?,?,?)", userData());
    }

    private List<Object[]> userData() {
        List<Object[]> users = new ArrayList<>();
        users.add("John Doe 25 M".split(" "));
        users.add("Jane Doe 23 F".split(" "));
        users.add("Sarah Bosch 34 F".split(" "));
        users.add("Michael Murray 20 M".split(" "));
        users.add("Barry Coy 19 M".split(" "));
        users.add("Daisy Chen 19 F".split(" "));
        users.add("May Williams 15 F".split(" "));
        users.add("Alex Johnson 40 M".split(" "));
        users.add("Ceasar McCoy 39 M".split(" "));
        users.add("Paula May 22 F".split(" "));
        return users;
    }

}
