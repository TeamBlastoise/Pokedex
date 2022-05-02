package com.github.teamblastoise.pokedex.pokemonpopulator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.github.teamblastoise.pokedex")
public class PokemonPopulatorApplication implements CommandLineRunner {

    @Autowired
    private PokemonPopulator pokemonPopulator;

    public static void main(String[] args) {
        SpringApplication.run(PokemonPopulatorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        pokemonPopulator.updatePokemon();
    }
}
