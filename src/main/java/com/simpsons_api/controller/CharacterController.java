package com.simpsons_api.controller;

import com.simpsons_api.entity.Character;
import com.simpsons_api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping()
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PostMapping()
    public Character saveCharacter(@RequestBody Character character) {
        return characterService.saveCharacter(character);
    }
}
