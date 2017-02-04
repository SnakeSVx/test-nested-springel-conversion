package com.github.danielfernandez.test.web.controller;

import com.github.danielfernandez.test.business.Bean;
import com.github.danielfernandez.test.business.Field;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by daniel on 04/02/17.
 */
@Controller
public class MainController {


    @RequestMapping("/")
    public String main(final Model model) {

        final Bean bean = new Bean();
        bean.setFieldAbs(new Field(100));
        bean.setFieldConc(new Field(500));

        model.addAttribute("bean", bean);

        return "main";

    }

}
