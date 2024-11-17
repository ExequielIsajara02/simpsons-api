package com.simpsons_api.service;

import com.simpsons_api.entity.Character;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface CharacterService {

    List<Character> getAllCharacters();
    List<Character> getMultipleCharacters(int number);
    Optional<Character> getCharacter(int id);
    Character saveCharacter(Character character);
    void deleteCharacter(int id);
}
