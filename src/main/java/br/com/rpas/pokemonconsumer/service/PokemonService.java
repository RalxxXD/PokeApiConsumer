package br.com.rpas.pokemonconsumer.service;

import br.com.rpas.pokemonconsumer.model.Pokemon;
import br.com.rpas.pokemonconsumer.model.PokemonDetail.PokemonDetail;

import java.util.List;

public interface PokemonService {

    public List<Pokemon> getAll();

    public PokemonDetail getFromIdOrName(String idOrName);
}
