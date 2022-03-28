package co.com.sofka.questions.pokeapi;

import co.com.sofka.models.pokemons.UsersPoke;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

    public class GetPokeQuestions implements Question {
        @Override
        public UsersPoke answeredBy(Actor actor) {
            return SerenityRest.lastResponse().as(UsersPoke.class);

        }
    }
