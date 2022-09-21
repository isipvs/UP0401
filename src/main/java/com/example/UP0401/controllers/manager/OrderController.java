package com.example.UP0401.controllers.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("order_list")
    public String orderList(Model model)
    {
        //model.addAttribute("order_list", );
        return "order_list";
    }
}
