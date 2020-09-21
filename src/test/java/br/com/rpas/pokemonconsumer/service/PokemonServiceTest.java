package br.com.rpas.pokemonconsumer.service;

import br.com.rpas.pokemonconsumer.client.PokemonServiceClient;
import br.com.rpas.pokemonconsumer.client.PokemonServiceClientImpl;
import br.com.rpas.pokemonconsumer.model.PokeApiResponse.PokeApiPaginationResponse;
import br.com.rpas.pokemonconsumer.model.Pokemon;
import br.com.rpas.pokemonconsumer.model.PokemonDetail.PokemonDetail;
import br.com.rpas.pokemonconsumer.service.Enum.PokeApiRequestValues;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @Mock
    private PokemonServiceClientImpl pokemonServiceClient;

    @InjectMocks
    private  PokemonServiceImpl pokemonService;

    @Test
    void shouldRetrievePokemonUsingId() {

        final PokemonDetail pokemon = new PokemonDetail(1L,"bubasauro", 15, new ArrayList<>(), new ArrayList<>());

        given(pokemonServiceClient.sendRequestOfIdOrName(pokemon.getId().toString())).willReturn(Optional.of(pokemon));

        PokemonDetail pokemonDetailSearched = pokemonService.getFromIdOrName("1");

        assert pokemonDetailSearched.getName().equals(pokemon.getName());
    }

    @Test
    void shouldRetrieveAListOfPokemons() {

        List<Pokemon> pokemons = new ArrayList<>();
        final Pokemon charmander = new Pokemon("charmander", "");
        pokemons.add(charmander);
        final Pokemon bulbasauro = new Pokemon("bulbasauro", "");
        pokemons.add(bulbasauro);

        PokeApiPaginationResponse pokeApiPaginationResponse =
                new PokeApiPaginationResponse(2L,null,null,pokemons);

        given(pokemonServiceClient.sendRequestOfAll(0, PokeApiRequestValues.LIMIT_PER_PAGE.value))
                .willReturn(pokeApiPaginationResponse);

        final List<Pokemon> response = pokemonService.getAll();

        assert response.size() == pokemons.size();
    }


}
