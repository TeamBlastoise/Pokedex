package com.github.teamblastoise.pokedex.pokeapi;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

public class PokeIdsIterator implements Iterator<List<Integer>> {

    private final PokeApi pokeApi;

    private Integer nextOffset;

    public PokeIdsIterator(PokeApi pokeApi) {
        this.nextOffset = 0;
        this.pokeApi = pokeApi;
    }

    @Override
    public boolean hasNext() {
        return nextOffset != null;
    }

    @Override
    public List<Integer> next() {
        int pageSize = 100;

        if (!hasNext()) {
            throw new NoSuchElementException("Reached the last page of the response.");
        }

        NamedApiResourceList result = pokeApi.getPokemonList(nextOffset, pageSize);
        nextOffset = calculateNextOffset(result.getNext(), pageSize);
        return extractIds(result.getResults());
    }

    private Integer calculateNextOffset(String nextPage, int pageSize) {
        return nextPage != null ? nextOffset + pageSize : null;
    }

    private List<Integer> extractIds(List<NamedApiResource> results) {
        return results.stream()
                .map(NamedApiResource::getId)
                .collect(toList());
    }
}