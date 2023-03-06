package com.example.fishing_shop.controllers;

import com.example.fishing_shop.models.ItemModel;
import com.example.fishing_shop.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class MainController {

    final
    ItemRepo itemRepo;

    public MainController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String getMainPage(Model model) {
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("items",list);
        return "index";
    }
}
