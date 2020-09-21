package br.com.rpas.pokemonconsumer.model.PokeApiResponse;

import br.com.rpas.pokemonconsumer.model.Pokemon;

import java.util.List;

public class PokeApiPaginationResponse {

    private long count;
    private String next;
    private String previous;
    private List<Pokemon> results;

    public PokeApiPaginationResponse(long count, String next, String previous, List<Pokemon> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public long getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }
}
