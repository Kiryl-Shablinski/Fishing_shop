package com.example.fishing_shop.controllers;

import com.example.fishing_shop.models.ItemModel;
import com.example.fishing_shop.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final
    ItemRepo itemRepo;

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
}
