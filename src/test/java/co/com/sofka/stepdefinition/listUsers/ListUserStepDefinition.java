package co.com.sofka.stepdefinition.listUsers;


import co.com.sofka.models.users.Datum;
import co.com.sofka.questions.regres.GetUsersQuestions;
import co.com.sofka.questions.regres.ResponseCode;
import co.com.sofka.taks.regresIn.GetUsersTaks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


public class ListUserStepDefinition {
    private static final String restApiUrl = "https://reqres.in/api";
    Actor actor;

    @Given("que el administrador necesita consultar que usuarios se encuentran registrados")

        public void queElAdministradorNecesitaConsultarQueUsuariosSeEncuentranRegistrados() {
            actor = Actor.named("Mancipe")
                    .whoCan(CallAnApi.at(restApiUrl));
            actor.attemptsTo(
                    GetUsersTaks.fromPage("/users?page=2")
            );


        }

    @When("se valida el código de respuesta exitoso")
    public void se_valida_el_código_de_respuesta_exitoso() {

        actor.should(
                seeThat("El código de respuesta", ResponseCode.was(),equalTo(SC_OK))
        );


    }


    @Then("se validara que en los datos de retorno se encuentre el email del usuario {string}")
    public void se_validara_que_en_los_datos_de_retorno_se_encuentre_el_email_del_usuario(String email) {

     Datum usuarios = new GetUsersQuestions().answeredBy(actor).getData().stream()
             .filter(x -> x.getEmail().equals(email))
             .findFirst().orElse(null);


     actor.should(
             seeThat("La respuesta", act -> usuarios,notNullValue())
     );
     actor.should(
             seeThat("Nombre del correo", act -> usuarios.getEmail(),equalTo(email))
     );
    }


    @Given("se hace una peticion a la api")
    public void que_el_administrador_realiza_una_peticion() {
        actor = Actor.named("Mancipe")
                .whoCan(CallAnApi.at(restApiUrl));
        actor.attemptsTo(
                GetUsersTaks.fromPage("/users?page=2")
        );


    }


    @When("cuando se valida el codigo de respuesta")
    public void no_se_valida_el_código() {

        actor.should(
                seeThat("El código de respuesta", ResponseCode.was(),equalTo(SC_OK))
        );
    }


    @Then("el usuario {string} no se debe encontrar en la respuesta")
    public void el_código_de_respuesta_es_no_encontrado(String email) {

        Datum usuarios = new GetUsersQuestions().answeredBy(actor).getData().stream()
                .filter(x -> x.getEmail().equals(email))
                .findFirst().orElse(null);


        actor.should(
                seeThat("La respuesta", act -> usuarios, equalTo(null))
        );

    }


}

