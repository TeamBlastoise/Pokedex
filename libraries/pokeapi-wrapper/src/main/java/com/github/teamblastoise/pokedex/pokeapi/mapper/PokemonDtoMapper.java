package com.github.teamblastoise.pokedex.pokeapi.mapper;

import com.github.teamblastoise.pokedex.pokeapi.model.PokemonDto;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.mapstruct.Mapper;

@Mapper
public interface PokemonDtoMapper {

    PokemonDto map(Pokemon source);

}
