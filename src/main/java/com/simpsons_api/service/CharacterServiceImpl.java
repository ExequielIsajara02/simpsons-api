package com.simpsons_api.service;

import com.simpsons_api.entity.Character;
import com.simpsons_api.persistence.CharacterJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterJPARepository characterRepository;

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public Optional<Character> getCharacter(int id) {
        return characterRepository.findById(id);
    }

    @Override
    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }


    @Override
    public void deleteCharacter(int id) {
        characterRepository.deleteById(id);
    }
}
