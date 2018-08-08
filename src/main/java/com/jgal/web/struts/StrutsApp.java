package com.jgal.web.struts;

import com.jgal.web.struts.service.ServiceFacade;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StrutsApp extends SpringBootServletInitializer implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(StrutsApp.class);
    @Autowired
    private ServiceFacade userService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StrutsApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StrutsApp.class, args);
        log.info("Started application at {}", "http://localhost:8080");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> registrationBean = new FilterRegistrationBean<>();
        StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
        registrationBean.setFilter(struts);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.putUsers();
    }

}
