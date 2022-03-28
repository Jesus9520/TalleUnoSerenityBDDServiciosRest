package co.com.sofka.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;



    @RunWith(CucumberSerenityRunner.class)
    @CucumberOptions(
            snippets = CucumberOptions.SnippetType.CAMELCASE,
            features = {"src/test/resources/features/pokeApi.feature"},
            glue = {"co.com.sofka.stepdefinition.listUsers"}
    )
    public class SerenityTestPokeApi {

}
