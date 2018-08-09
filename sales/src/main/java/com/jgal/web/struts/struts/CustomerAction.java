package com.jgal.web.struts.struts;

import com.jgal.web.struts.model.Company;
import com.jgal.web.struts.service.CompanyService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Namespace("/customers")
public class CustomerAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<Company> companyList;

    @Autowired
    private CompanyService companyService;

    @Action(value = "index", results = {
        @Result(name = "success", location = "/customers.jsp")
    })
    public String index() {
        companyList = companyService.retrieveCustomers();
        return SUCCESS;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }
}
