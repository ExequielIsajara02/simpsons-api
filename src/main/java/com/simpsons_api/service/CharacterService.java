package com.simpsons_api.service;

import com.simpsons_api.entity.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterService {

    List<Character> getAllCharacters();
    Optional<Character> getCharacter(int id);
    Character saveCharacter(Character character);
    void deleteCharacter(int id);
}
