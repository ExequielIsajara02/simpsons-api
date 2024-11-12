package com.simpsons_api.controller;

import com.simpsons_api.entity.Character;
import com.simpsons_api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping()
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCharacter(@PathVariable Integer id){
        Optional<Character> character = characterService.getCharacter(id);
        if(!character.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(character);
    }

    @PostMapping()
    public Character saveCharacter(@RequestBody Character character) {
        return characterService.saveCharacter(character);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        Optional<Character> character = characterService.getCharacter(id);
        if(!character.isPresent()){
            return ResponseEntity.notFound().build();
        }
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }
}
