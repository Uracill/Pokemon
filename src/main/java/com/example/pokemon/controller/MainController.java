package com.example.pokemon.controller;

import com.example.pokemon.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//TODO: Imports optimieren
@Controller
public class MainController {
    private final MainService _mainService;

    public MainController(MainService mainService) {
        _mainService = mainService;
    }

    @GetMapping("/")
    public String homePage(Model model, @RequestParam(defaultValue = "") String filter){
        model.addAttribute("pokemons", _mainService.getFilteredPokemonDtos(filter));
        model.addAttribute("filter", filter);
        return "main";
    }
}
