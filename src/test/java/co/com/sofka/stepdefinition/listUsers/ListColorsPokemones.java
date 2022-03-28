package co.com.sofka.stepdefinition.listUsers;

import co.com.sofka.models.pokemons.Result;
import co.com.sofka.models.pokemons.UsersPoke;
import co.com.sofka.questions.pokeapi.GetPokeQuestions;


import co.com.sofka.questions.pokeapi.ResponsePoke;
import co.com.sofka.taks.pokeapitaks.PokeApiTaks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ListColorsPokemones {
    private static final String restApiUrl = "https://pokeapi.co/api";
    Actor actor;


    @Given("el usuario necesita consultar que colores de pokemones estan en lista")
    public void el_usuario_necesita_consultar_que_colores_de_pokemones_estan_en_lista() {
        actor = Actor.named("Mancipe")
                .whoCan(CallAnApi.at(restApiUrl));
        actor.attemptsTo(
                PokeApiTaks.fromPagePoke("/v2/pokemon-color/")
        );
    }


    @When("se realiza la peticion valida el código de respuesta exitoso")
    public void se_realiza_la_peticion_valida_el_código_de_respuesta_exitoso() {
        actor.should(
                seeThat("El código de respuesta", ResponsePoke.was(),equalTo(SC_OK))
        );
    }


    @Then("se validara que en los datos de retorno se encuentre el pokemon de color {string}")
    public void se_validara_que_en_los_datos_de_retorno_se_encuentre_el_pokemon_de_color(String name) {
        Result pokemon = new GetPokeQuestions().answeredBy(actor).getResults().stream()
                .filter(x -> x.getName().equals(name)).findFirst().orElse(null);

                actor.should(
                        seeThat("La respuesta", act -> pokemon, notNullValue())
                );
        actor.should(
                seeThat("Color del Pokemon", act -> pokemon.getName(),equalTo(name))
        );

    }

    @Given("el usuario realiza una petición de pokemon no disponible")
    public void el_usuario_realiza_una_petición_de_pokemon_no_disponible() {
        actor = Actor.named("Mancipe")
                .whoCan(CallAnApi.at(restApiUrl));
        actor.attemptsTo(
                PokeApiTaks.fromPagePoke("/v2/pokemon-color/")
        );
    }


    @Then("se valida codigo de respuesta no exitoso")
    public void se_calida_codigo_de_respuesta_no_exitoso() {
        actor.should(
                seeThat("El código de respuesta", ResponsePoke.was(),equalTo(SC_OK))
        );

    }

}
