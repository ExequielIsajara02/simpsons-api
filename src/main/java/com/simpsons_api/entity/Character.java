package com.simpsons_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private int id_character;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "image_url")
    private String image_url;
}
