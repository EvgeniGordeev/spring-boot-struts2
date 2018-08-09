package com.jgal.web.struts.service;

import com.jgal.web.struts.repository.UserDAO;
import com.jgal.web.struts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void putUsers() {
        userDAO.insertBatch();
    }

    public List<User> retrieveUsers() {
        return userDAO.getUsers();
    }

}
