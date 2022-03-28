package co.com.sofka.taks.pokeapitaks;

import co.com.sofka.taks.regresIn.GetUsersTaks;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

    public class PokeApiTaks implements Task {

        private final String page;

        public PokeApiTaks(String page){
            this.page = page;
        }

        public static Performable fromPagePoke(String page){
            return instrumented(PokeApiTaks.class, page);
        }
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Get.resource(page)
                            .with(requestSpecification
                                    -> requestSpecification.contentType(ContentType.JSON)
                                    .header("header1","value1"))
            );
        }
    }

