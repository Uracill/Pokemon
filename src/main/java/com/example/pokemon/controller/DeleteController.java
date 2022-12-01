package com.example.pokemon.controller;

import com.example.pokemon.model.dto.PokemonDto;
import com.example.pokemon.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete")
public class DeleteController {

    private final MainService _mainService;

    public DeleteController(MainService mainService) {
        _mainService = mainService;
    }

    @GetMapping()
    public String deleteWithNoID() {
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteWithID(@PathVariable(value = "id") long id) {
//        PokemonDto deletedPokemonDto = _mainService.getPokemonDtoById(id);
//
//        _mainService.delete(deletedPokemonDto);
        _mainService.deleteById(id);
        return "redirect:/";
    }
}
