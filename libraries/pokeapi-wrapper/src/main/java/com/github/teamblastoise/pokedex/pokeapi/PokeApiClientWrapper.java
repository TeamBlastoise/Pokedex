package com.github.teamblastoise.pokedex.pokeapi;

import com.github.teamblastoise.pokedex.pokeapi.model.PokemonDto;

import java.util.List;

public interface PokeApiClientWrapper {

    PokemonDto getPokemon(int id);

    List<Integer> getPokemonIds();

}
