package com.github.teamblastoise.pokedex.pokemonpopulator;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    private Integer id;

    private String name;

    protected PokemonEntity() {
    }

    public PokemonEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
