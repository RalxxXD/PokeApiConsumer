
[![CircleCI](https://circleci.com/gh/ramazan/Spring-Rest-Template-Example.svg?style=svg)](https://circleci.com/gh/ramazan/Spring-Rest-Template-Example)

# Spring Boot WebClient example.

Used technologies 
  <li>Spring 5
  <li> Spring Boot 2 
  <li>Spring Boot Web Flux 
  <li>Springfox Swagger 2
  <li>Springfox Swagger UI 
  

#### I used pokeapi.co API service for this example project.

#### End point Swagger: http://localhost:8080/api/pokemon-consumer/swagger-ui.html

### (Portuguese)
### Observações sobre o teste:

##### De modo geral foi uma atividade bem divertida. 
##### Como a API pokeapi nos fornece os dados de uma forma muito segmentada, foi necessário fazer mais de uma requisição para trazer todos os pokemons da api.
##### Eu escolhi realizar um recursão para resolver esse fluxo de uma forma mais limpa.
##### Ao mesmo tempo que encontramos uma repetição da forma que os dados são retornados, nos fazendo utilizar uma abstração de classe deixando o código mais organizado e menos repetitivo.

##### A escolha do Web Flux foi devido a como esse projeto poderia evoluir, sabendo que será necessario realizar varias requisições para a pokeApi uma vez que conseguimos recuperar todos os pokemons.

##### Podemos fazer todas as proximas requisições em paralelo, ganhando um bom tempo de resposta em novas funcionalidades.
##### Exemplo   
<li> Definir qual pokemon tem vantagem.
<li> Definir quais itens são melhores para um determinado pokemon.
<li> Comparar uma composição com outras do cenário.
<li> Entre outras.

##### Qualquer Duvida pode entrar em contato com o email:
raoni.paiva@hotmai.com 

<hr/>

