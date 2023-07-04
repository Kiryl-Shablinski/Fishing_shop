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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/detailItem")
public class DetailItemController {
    final
    ItemRepo itemRepo;

    @Autowired
    ClientRepo clientRepo;

    public DetailItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable(value = "id") long id,
                                Model model){
        Optional<ItemModel> optional = itemRepo.findById(id);
        List<ItemModel> list = new ArrayList<>();
        optional.ifPresent(list::add);
        model.addAttribute("item",list);
        return "detail";
    }
    @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable(value = "id") long id,
                                 @RequestParam String name,
                                 @RequestParam String contact){
        ClientModel clientModel = new ClientModel();
        clientModel.setName(name);
        clientModel.setContact(contact);
        clientModel.setItem(String.valueOf(id));
        clientModel.setActual(true);
        clientRepo.save(clientModel);
        return new RedirectView("/");
    }
    }
