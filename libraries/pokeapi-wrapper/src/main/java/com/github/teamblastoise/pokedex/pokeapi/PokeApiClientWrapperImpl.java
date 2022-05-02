package com.github.teamblastoise.pokedex.pokeapi;

import com.github.teamblastoise.pokedex.pokeapi.mapper.PokemonDtoMapper;
import com.github.teamblastoise.pokedex.pokeapi.mapper.PokemonDtoMapperImpl;
import com.github.teamblastoise.pokedex.pokeapi.model.PokemonDto;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PokeApiClientWrapperImpl implements PokeApiClientWrapper {

    private final PokeApi pokeApi = new PokeApiClient();

    private final PokemonDtoMapper pokemonDtoMapper = new PokemonDtoMapperImpl();

    @Override
    public PokemonDto getPokemon(int id) {
        return pokemonDtoMapper.map(pokeApi.getPokemon(id));
    }

    @Override
    public List<Integer> getPokemonIds() {
        List<Integer> allPokemonIds = new ArrayList<>();
        Iterator<List<Integer>> pokemonIdIterator = new PokeIdsIterator(pokeApi);

        while (pokemonIdIterator.hasNext()) {
            allPokemonIds.addAll(pokemonIdIterator.next());
        }

        return allPokemonIds;
    }
}
