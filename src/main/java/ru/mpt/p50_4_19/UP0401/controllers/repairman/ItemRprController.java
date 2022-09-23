package ru.mpt.p50_4_19.UP0401.controllers.repairman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mpt.p50_4_19.UP0401.services.ItemService;

@Controller
@RequestMapping("/rpr_items")
public class ItemRprController {

    final private ItemService itemService;

    @Autowired
    public ItemRprController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String itemList( Model model )
    {
        model.addAttribute("item_list", itemService.findRprAll() );
        model.addAttribute("empl_name", "Мастер ремонтник");
        return "repairman/item_list";
    }

    //Взять предмет мебели в работу
    @GetMapping("/{id}/take")
    public String takeItem( @PathVariable("id") int id )
    {
        itemService.takeToWork(id);
        return "redirect:/rpr_items";
    }

    // Завершение работы по предмету мебели
    @GetMapping("/{id}/close")
    public String closeItem( @PathVariable("id") int id )
    {
        itemService.makeComplete(id);
        return "redirect:/rpr_items";
    }

}
