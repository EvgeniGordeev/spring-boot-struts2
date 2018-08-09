package com.jgal.web.struts.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import com.jgal.web.struts.model.User;
import com.jgal.web.struts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ${CLASS_NAME}.
 *
 * @author evgeni.gordeev
 * @version 8.0
 * @since 7/12/17
 */
@RestController
public class UserConroller {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/users",
        produces = {APPLICATION_JSON_VALUE, TEXT_PLAIN_VALUE})
    public List<User> getUsers() throws Exception {
        return userService.retrieveUsers();
    }
}
