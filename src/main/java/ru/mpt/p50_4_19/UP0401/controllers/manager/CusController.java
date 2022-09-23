package ru.mpt.p50_4_19.UP0401.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mpt.p50_4_19.UP0401.services.CusService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/customers")
public class CusController {

    final private CusService cusService;

    @Autowired
    public CusController(CusService cusService) {
        this.cusService = cusService;
    }

    // Получаем список всех клиентов
    @GetMapping()
    public String cusList( Model model )
    {
        model.addAttribute("cus_list", cusService.findAll() );
        return "manager/cus_list";
    }

    //Возращаем форму для заведения нового заказа
    @GetMapping("/new")
    public String getForm_NewCus( Model model )
    {
        return "manager/card_cus";
    }


    @PostMapping()
    public String createCus(
            @PathVariable("name"  ) String name,
            @PathVariable("email" ) String email,
            @PathVariable("phone" ) String phone
        )
    {
//        if( bindingResult.hasErrors() )
//            return "manager/order_new";
        cusService.create(name, email, phone);
        return "redirect:/customers";
    }



    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") int id )
    {
        cusService.delete(id);
        return "redirect:/customers";
    }
}
