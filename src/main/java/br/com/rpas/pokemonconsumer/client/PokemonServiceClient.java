package br.com.rpas.pokemonconsumer.client;

import br.com.rpas.pokemonconsumer.model.PokeApiResponse.PokeApiPaginationResponse;
import br.com.rpas.pokemonconsumer.model.PokemonDetail.PokemonDetail;

import java.util.Optional;

public interface PokemonServiceClient {

    PokeApiPaginationResponse sendRequestOfAll(int offset, int limitPerPage);

    Optional<PokemonDetail> sendRequestOfIdOrName(String idOrName);

}
