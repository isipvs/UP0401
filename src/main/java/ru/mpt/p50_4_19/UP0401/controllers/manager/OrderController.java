package ru.mpt.p50_4_19.UP0401.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mpt.p50_4_19.UP0401.services.OrderService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {

    final private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Получаем списко всех заказов
    @GetMapping()
    public String orderList( Model model )
    {
        model.addAttribute("order_list", orderService.findAll() );
        return "manager/order_list";
    }

    //Возращаем форму для заведения нового заказа
    @GetMapping("/new")
    public String getForm_NewOrder( Model model )
    {
        model.addAttribute("cus_list", orderService.getCusList());
        model.addAttribute("cur_date", LocalDateTime.now()      );
        model.addAttribute("url", "/orders");
        return "manager/order_new";
    }

    //@PostMapping()
    @GetMapping("/create")
    public String createOrder(
            @RequestParam("cus_id") int id,
            @RequestParam("note"  ) String note
        )
    {
//        if( bindingResult.hasErrors() )
//            return "manager/order_new";
        orderService.create(id, note);

        return "redirect:/orders";
    }

    @GetMapping("/{id}/page")
    public String orderInfo( Model model, @PathVariable("id") int id )
    {
        model.addAttribute("order", orderService.findOne(id));
        return "manager/card_order";
    }

    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") int id )
    {
        orderService.delete(id);
        return "redirect:/orders/list";
    }
}
