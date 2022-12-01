package com.example.pokemon.controller;

import com.example.pokemon.model.dv.DvGender;
import com.example.pokemon.model.dto.PokemonDto;
import com.example.pokemon.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("edit")
public class EditController {

    private final MainService _mainService;

    public EditController(MainService mainService) {
        _mainService = mainService;
    }

    @GetMapping()
    public String editWithNoId() {
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String editWithId(@PathVariable(value = "id") long id, Model model) {
        PokemonDto editPokemon = _mainService.getPokemonDtoById(id);

        model.addAttribute("editPokemon", editPokemon);
        model.addAttribute("gender_value", DvGender.values());
        return "edit_pokemon";
    }

    @PostMapping("/edited/{id}")
    public String editedPokemon(Model model, @ModelAttribute("editPokemon") @Valid PokemonDto pokemonDto, BindingResult bindingResult) {

        if(nameNotContainsCharsOnly(pokemonDto)) {
            //bindingResult.rejectValue("name", "validation.charname");
            model.addAttribute("gender_value", DvGender.values());
            return "edit_pokemon";
        }

        if(firstAndSecondTypeSame(pokemonDto)) {
            bindingResult.rejectValue("secondType", "validation.samename");
            model.addAttribute("gender_value", DvGender.values());
            return "edit_pokemon";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("gender_value", DvGender.values());
            return "edit_pokemon";
        }

        _mainService.add(pokemonDto);  //notwendig, die id als Variable zu haben? Ansonsten wird eine freie ID dem Pokemon zugewiesen
        return "redirect:/";
    }

    private boolean nameNotContainsCharsOnly(PokemonDto pokemonDto) {
        return !pokemonDto.getName().matches("[a-zA-Z]{2,10}");
    }

    private boolean firstAndSecondTypeSame(PokemonDto pokemonDto) {
        return pokemonDto.getFirstType().equals(pokemonDto.getSecondType());
    }
}
