package com.example.fishing_shop.controllers;

import com.example.fishing_shop.models.ClientModel;
import com.example.fishing_shop.models.ItemModel;
import com.example.fishing_shop.repos.ClientRepo;
import com.example.fishing_shop.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final
    ItemRepo itemRepo;
    @Autowired
    ClientRepo clientRepo;

    public AdminController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String getAdminPage(){
        return"admin";
    }

    @GetMapping("/addItem")
    public String getAddPage(){
        return "add";
    }

    @PostMapping("/addItem")
    public RedirectView saveItem(@RequestParam String title,
                                 @RequestParam String disc,
                                 @RequestParam String photoUrl){
        ItemModel itemModel = new ItemModel();
                itemModel.setTitle(title);
                itemModel.setDisc(disc);
                itemModel.setUrl(photoUrl);
                itemRepo.save(itemModel);

        return new RedirectView("/admin");
    }
@GetMapping("/checkClients")
    public String getClients(Model model){
        List<ClientModel> clientList = clientRepo.findClientModelsByActual(true);
        model.addAttribute("clientList",clientList);
return "clients";
}

@GetMapping("/checkClients/notactual{id}")
    public RedirectView notActual(@PathVariable(value = "id") long id){
        return new RedirectView();
}
}