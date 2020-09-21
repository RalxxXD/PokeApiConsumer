package br.com.rpas.pokemonconsumer.model.PokemonDetail;

import java.util.List;

public class PokemonDetail {

    private Long id;
    private String name;
    private float weight;
    private List<AbilityStatus> abilities;
    private List<Form> forms;

    public PokemonDetail(Long id, String name, float weight, List<AbilityStatus> abilities, List<Form> forms) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.abilities = abilities;
        this.forms = forms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public List<AbilityStatus> getAbilities() {
        return abilities;
    }

    public List<Form> getForms() {
        return forms;
    }
}
