package br.com.rpas.pokemonconsumer.service.Enum;

public enum PokeApiRequestValues {
    LIMIT_PER_PAGE(200) ,
    INITIAL_PAGE_NUMBER(0);

    public final int value;

    private PokeApiRequestValues(int label){
        this.value = label;
    }
}
