package co.com.sofka.questions.regres;

import co.com.sofka.models.users.Datum;
import co.com.sofka.models.users.Users;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestions implements Question {
    @Override
    public Users answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Users.class);

    }
}
