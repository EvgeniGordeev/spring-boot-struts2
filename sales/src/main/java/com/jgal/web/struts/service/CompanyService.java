package com.jgal.web.struts.service;

import com.jgal.web.struts.model.Company;
import com.jgal.web.struts.repository.CompanyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    public void createCustomers() {
        companyDAO.insertBatch();
    }

    public List<Company> retrieveCustomers() {
        return companyDAO.getCompanies();
    }

}
