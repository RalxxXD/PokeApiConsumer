package br.com.rpas.pokemonconsumer.model;

import br.com.rpas.pokemonconsumer.model.PokeApiResponse.PokeApiDefaultResponse;

public class Pokemon extends PokeApiDefaultResponse {

    public Pokemon(String name, String url) {
        super(name, url);
    }
}
