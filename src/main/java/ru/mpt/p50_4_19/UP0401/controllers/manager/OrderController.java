package ru.mpt.p50_4_19.UP0401.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mpt.p50_4_19.UP0401.models.POrder;
import ru.mpt.p50_4_19.UP0401.services.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    final private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/list")
    public String orderList( Model model )
    {
        model.addAttribute("order_list", orderService.findAll() );
        return "order_list";
    }

    @GetMapping("/new")
    public String getForm_NewOrder(@ModelAttribute("order") POrder order )
    {
        return "order/new";
    }

    @PostMapping
    public String createOrder( @ModelAttribute("order") @Valid POrder order, BindingResult bindingResult )
    {
        if( bindingResult.hasErrors() )
            return "order/new";


        orderService.save(order);
        return "redirect:/list";
    }

    @GetMapping("/{id}/page")
    public String orderInfo( Model model, @PathVariable("id") int id )
    {
        model.addAttribute("order", orderService.findOne(id));
        return "order/order_page";
    }

    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") int id )
    {
        orderService.delete(id);
        return "redirect:/list";
    }
}
