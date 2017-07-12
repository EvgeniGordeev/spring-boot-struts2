package com.jgal.web.struts.service;


import com.jgal.web.struts.model.User;

import java.util.List;

public interface ServiceFacade {
    void putUsers();
    List<User> retrieveUsers();
}