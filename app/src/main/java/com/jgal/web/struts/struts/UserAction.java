package com.jgal.web.struts.struts;

import com.jgal.web.struts.model.User;
import com.jgal.web.struts.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Namespace("/users")
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<User> users;

    @Autowired
    private UserService userService;

    @Action(value = "index", results = {
        @Result(name = "success", location = "/users.jsp")
    })
    public String index() {
        users = userService.retrieveUsers();
        return SUCCESS;
    }

    public List<User> getUsers() {
        return users;
    }
}
