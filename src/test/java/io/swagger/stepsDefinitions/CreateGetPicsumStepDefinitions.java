package io.swagger.stepsDefinitions;

import io.cucumber.java.en.*;
import io.sweagger.tasks.GetPicsumTask;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.sweagger.constants.Constans.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.*;

public class CreateGetPicsumStepDefinitions {

    private static final String restAPIUrl = BASE_URL;

    @Given("I want to get a list of images from Lorem Picsum")
    public void iWantToGetAListOfImagesFromLoremPicsum() {
        Actor user = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));
    }

    @When("I send a GET request to the endpoint {string}")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        Actor user = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));
        user.attemptsTo(
                GetPicsumTask.withEndpoint(endpoint)
        );
    }

    @Then("I validate that the response code is {string}")
    public void iValidateThatTheResponseCodeIs(String code) {
        String actualCode = String.valueOf(SerenityRest.lastResponse().getStatusCode());
        Actor user = Actor.named("user");
        user.should(
                seeThat("The response code is", rest -> actualCode, equalTo(code))
        );
    }

    @Then("I validate that the response contains a list of images with the correct attributes")
    public void iValidateThatTheResponseContainsAListOfImages() {
        Actor user = Actor.named("user");

        // Verifica que el cuerpo de la respuesta contenga una lista de imágenes
        user.should(
                seeThat("The response contains images",
                        rest -> SerenityRest.lastResponse().jsonPath().getList("$"),
                        hasSize(greaterThan(0)))
        );

        // Validar que el primer elemento tenga los atributos esperados
        user.should(
                seeThat("The first image has an 'id' field",
                        rest -> SerenityRest.lastResponse().jsonPath().getString("[0].id"),
                        notNullValue())
        );

        user.should(
                seeThat("The first image has an 'author' field",
                        rest -> SerenityRest.lastResponse().jsonPath().getString("[0].author"),
                        notNullValue())
        );

        user.should(
                seeThat("The first image has a 'download_url' field",
                        rest -> SerenityRest.lastResponse().jsonPath().getString("[0].download_url"),
                        notNullValue())
        );
    }
}
