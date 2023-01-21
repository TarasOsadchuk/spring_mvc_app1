package com.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello, " + name + " " + surname + "!");
        model.addAttribute("message", "Hello, " + name + " " + surname + "!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String helloPage(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action,
                            Model model) {

        if (action.equals("multiplication")) {
            model.addAttribute("result", a + " * " + b + " = " + (a * b));
        } else if (action.equals("addition")) {
            model.addAttribute("result", a + " + " + b + " = " + (a + b));
        } else if (action.equals("subtraction")) {
            model.addAttribute("result", a + " - " + b + " = " + (a - b));
        } else if (action.equals("division")) {
            model.addAttribute("result", a + " / " + b + " = " + (a / (double)b));
        } else {
            model.addAttribute("result", "Enter the correct data");
        }
        return "first/calculator";
    }
}
