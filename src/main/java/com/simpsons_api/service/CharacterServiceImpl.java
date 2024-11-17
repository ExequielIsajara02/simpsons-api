package com.simpsons_api.service;

import com.simpsons_api.entity.Character;
import com.simpsons_api.persistence.CharacterJPARepository;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterJPARepository characterRepository;

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> getMultipleCharacters(int number) {
        List<Character> charactersList = characterRepository.findAll();

        // Convertimos la lista en un array de tipo Character[]
        Character[] characters = charactersList.toArray(new Character[0]);

        // Aseguramos que no pidamos más de los elementos que existen
        number = Math.min(number, characters.length);

        // Usamos Arrays.stream() con limit o Arrays.copyOfRange()
        List<Character> characterList2 = Arrays.stream(characters)
                .limit(number)  // O también puedes usar Arrays.copyOfRange
                .collect(Collectors.toList());

        return characterList2;
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
