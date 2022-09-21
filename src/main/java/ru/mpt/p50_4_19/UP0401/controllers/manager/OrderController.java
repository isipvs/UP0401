package ru.mpt.p50_4_19.UP0401.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mpt.p50_4_19.UP0401.repositories.OrderRepository;

@Controller
public class OrderController {

    @GetMapping("order_list")
    public String orderList(Model model, OrderRepository or)
    {
        model.addAttribute("order_list", or.findAll( Sort.by("dbeg")) );
        return "order_list";
    }
}
