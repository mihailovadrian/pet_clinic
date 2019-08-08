package com.mihailov.pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {
    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndex() {
        return "owners/index";
    }
}
