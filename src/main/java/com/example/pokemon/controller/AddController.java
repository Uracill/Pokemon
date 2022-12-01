package com.example.pokemon.controller;

import com.example.pokemon.model.dv.DvGender;
import com.example.pokemon.model.dto.PokemonDto;
import com.example.pokemon.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddController {

    private final MainService _mainService;

    public AddController(MainService mainService) {
        _mainService = mainService;
    }

    @GetMapping("/add")
    public String openAddMask(Model model){
        model.addAttribute("newPokemon", new PokemonDto());
        model.addAttribute("gender_value", DvGender.values());
        return "add_pokemon";
    }

    @PostMapping("/addedPokemon")
    public String addPokemonToRepository(@ModelAttribute("newPokemon") @Valid PokemonDto pokemonDto, BindingResult bindingResult, Model model){

        if(nameNotContainsCharsOnly(pokemonDto)) {
//            bindingResult.rejectValue("name", "validation.charname");
            model.addAttribute("gender_value", DvGender.values());
            return "add_pokemon";
        }

        if(firstAndSecondTypeSame(pokemonDto)) {
            bindingResult.rejectValue("secondType", "validation.samename");
            model.addAttribute("gender_value", DvGender.values());
            return "add_pokemon";
        }

        if (bindingResult.hasErrors()) {
            //bindingResult.getFieldError();
            model.addAttribute("gender_value", DvGender.values());
            return "add_pokemon";
        }


        _mainService.add(pokemonDto);
        return "redirect:/";
    }

    private boolean nameNotContainsCharsOnly(PokemonDto pokemonDto) {
        return !pokemonDto.getName().matches("[a-zA-Z]{2,10}");
    }

    private boolean firstAndSecondTypeSame(PokemonDto pokemonDto) {
        return pokemonDto.getFirstType().equals(pokemonDto.getSecondType());
    }

}
