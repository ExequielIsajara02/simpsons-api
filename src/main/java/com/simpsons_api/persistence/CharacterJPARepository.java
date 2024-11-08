package com.simpsons_api.persistence;

import com.simpsons_api.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterJPARepository extends JpaRepository<Character, Integer> {

}
