package br.com.rpas.pokemonconsumer.service;

import br.com.rpas.pokemonconsumer.Excpetion.PokemonNotFoundException;
import br.com.rpas.pokemonconsumer.model.PokeApiResponse.PokeApiPaginationResponse;
import br.com.rpas.pokemonconsumer.model.Pokemon;
import br.com.rpas.pokemonconsumer.model.PokemonDetail.PokemonDetail;
import br.com.rpas.pokemonconsumer.service.Enum.PokeApiRequestValues;
import br.com.rpas.pokemonconsumer.client.PokemonServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    PokemonServiceClient pokemonServiceClient;

    @Override
    public List<Pokemon> getAll() {
        int limitPerPage = PokeApiRequestValues.LIMIT_PER_PAGE.value;
        return prepareRequest(limitPerPage);
    }

    @Override
    public PokemonDetail getFromIdOrName(String idOrName) {
        return pokemonServiceClient.sendRequestOfIdOrName(idOrName)
                .orElseThrow(() -> new PokemonNotFoundException(idOrName));
    }

    private List<Pokemon> prepareRequest(int limitPerPage) {
        return this.prepareRequest(limitPerPage
                , PokeApiRequestValues.INITIAL_PAGE_NUMBER.value
                , new ArrayList<>());
    }

    private List<Pokemon> prepareRequest(int limitPerPage
            , int pageNumber
            , List<Pokemon> pokemons) {

        int offset = limitPerPage * pageNumber;

        PokeApiPaginationResponse pokeApiResponse =
                pokemonServiceClient.sendRequestOfAll(offset, limitPerPage);

        pokemons.addAll(pokeApiResponse.getResults());

        if (pokeApiResponse.getNext() != null) {
            return this.prepareRequest(limitPerPage, ++pageNumber, pokemons);
        }

        return pokemons;
    }


}
