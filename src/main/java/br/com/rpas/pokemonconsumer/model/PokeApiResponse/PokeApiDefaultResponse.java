package br.com.rpas.pokemonconsumer.model.PokeApiResponse;

public abstract class PokeApiDefaultResponse {

    private String name;
    private String url;

    public PokeApiDefaultResponse(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
