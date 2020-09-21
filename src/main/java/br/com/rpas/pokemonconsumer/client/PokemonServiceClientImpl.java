package br.com.rpas.pokemonconsumer.client;

import br.com.rpas.pokemonconsumer.model.PokeApiResponse.PokeApiPaginationResponse;
import br.com.rpas.pokemonconsumer.model.PokemonDetail.PokemonDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class PokemonServiceClientImpl implements PokemonServiceClient {

    @Autowired
    private WebClient webClient;

    public PokeApiPaginationResponse sendRequestOfAll(int offset, int limitPerPage) {

        Mono<PokeApiPaginationResponse> monoPokemon = this.webClient
                .get()
                .uri("/pokemon/?offset={offset}&limit={limitPerPage}", offset, limitPerPage)
                .retrieve()
                .bodyToMono(PokeApiPaginationResponse.class);

        return monoPokemon.block();

    }

    public Optional<PokemonDetail> sendRequestOfIdOrName(String idOrName) {
        Mono<PokemonDetail> monoPokemon = this.webClient
                .get()
                .uri("/pokemon/{id}", idOrName)
                .retrieve()
                .bodyToMono(PokemonDetail.class);

        return Optional.of(monoPokemon.block());
    }

}
