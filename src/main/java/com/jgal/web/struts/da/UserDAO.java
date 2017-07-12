package com.jgal.web.struts.da;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import com.jgal.web.struts.model.User;
 
public interface UserDAO {
    public List<User> getUsers();
    public void insertBatch();
}