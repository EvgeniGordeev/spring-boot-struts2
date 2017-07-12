package com.jgal.web.struts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ${CLASS_NAME}.
 *
 * @author evgeni.gordeev
 * @version 8.0
 * @since 7/12/17
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "redirect:/users";
    }
}
