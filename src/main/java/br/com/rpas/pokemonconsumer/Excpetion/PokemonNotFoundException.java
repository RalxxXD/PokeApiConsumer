package br.com.rpas.pokemonconsumer.Excpetion;

public class PokemonNotFoundException extends  RuntimeException {

    public  PokemonNotFoundException(String idOrName) {
        super("Could not found any Pokemon through the value: " + idOrName);
    }

}
