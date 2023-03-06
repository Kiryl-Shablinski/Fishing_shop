package com.example.fishing_shop.controllers;

import com.example.fishing_shop.models.ItemModel;
import com.example.fishing_shop.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/detailItem")
public class DetailItemController {
    final
    ItemRepo itemRepo;

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
    }
