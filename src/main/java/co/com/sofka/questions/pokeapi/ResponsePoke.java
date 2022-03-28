package co.com.sofka.questions.pokeapi;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponsePoke implements Question {
    public static Question<Integer> was() {
        return new ResponsePoke();
    }

    public static ResponsePoke responsePoke(){
        return new ResponsePoke();
    }
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
