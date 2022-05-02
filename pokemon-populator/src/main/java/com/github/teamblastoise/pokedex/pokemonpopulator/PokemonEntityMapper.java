package com.github.teamblastoise.pokedex.pokemonpopulator;

import com.github.teamblastoise.pokedex.pokeapi.model.PokemonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonEntityMapper {

    PokemonEntity map(PokemonDto source);

}
