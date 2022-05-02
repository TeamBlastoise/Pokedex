package com.github.teamblastoise.pokedex.pokemonpopulator;

import com.github.teamblastoise.pokedex.pokeapi.PokeApiClientWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Transactional
public class PokemonPopulator {
    private final PokeApiClientWrapper pokeApiClientWrapper;

    private final PokemonEntityMapper pokemonEntityMapper;

    private final PokemonRepository pokemonRepository;

    public PokemonPopulator(PokeApiClientWrapper pokeApiClientWrapper, PokemonEntityMapper pokemonEntityMapper,
                            PokemonRepository pokemonRepository) {
        this.pokeApiClientWrapper = pokeApiClientWrapper;
        this.pokemonEntityMapper = pokemonEntityMapper;
        this.pokemonRepository = pokemonRepository;
    }

    public void updatePokemon() {
        List<PokemonEntity> allPokemon = fetchAllPokemons();
        log.info("Fetched {} pokemons", allPokemon.size());

        pokemonRepository.saveAll(allPokemon);
    }

    private List<PokemonEntity> fetchAllPokemons() {
        return pokeApiClientWrapper.getPokemonIds().stream()
                .parallel()
                .peek(id -> log.info("Fetching pokemon with id {}", id))
                .map(pokeApiClientWrapper::getPokemon)
                .peek(pokemonDto -> log.info("Mapping pokemon with name {}", pokemonDto.name()))
                .map(pokemonEntityMapper::map)
                .collect(toList());
    }
}
