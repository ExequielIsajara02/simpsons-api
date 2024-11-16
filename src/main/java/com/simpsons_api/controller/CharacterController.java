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
@CrossOrigin(value = "*")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping()
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characters = characterService.getAllCharacters();
        return ResponseEntity.ok(characters);
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
    public ResponseEntity<Void> saveCharacter(@RequestBody Character character) {
        characterService.saveCharacter(character);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCharacter(@PathVariable Integer id, @RequestBody Character characterUpdated) {
        Optional<Character> character = characterService.getCharacter(id);
        if(!character.isPresent()){
            return ResponseEntity.notFound().build();
        }
        characterUpdated.setId_character(character.get().getId_character());
        characterService.saveCharacter(characterUpdated);
        return ResponseEntity.ok(characterUpdated);
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
