package br.com.rpas.pokemonconsumer.controller;

import br.com.rpas.pokemonconsumer.Excpetion.PokemonNotFoundException;
import br.com.rpas.pokemonconsumer.model.Pokemon;
import br.com.rpas.pokemonconsumer.model.PokemonDetail.PokemonDetail;
import br.com.rpas.pokemonconsumer.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@Controller("pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Cacheable("Pokemon")
    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity.ok(this.pokemonService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("idOrName")
    public ResponseEntity<Object> getFromIdOrName(@RequestParam("value") String idOrName) {
        try {
            return ResponseEntity.ok(this.pokemonService.getFromIdOrName(idOrName));
        } catch (PokemonNotFoundException pfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pfe.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

}
