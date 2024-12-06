package io.sweagger.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPicsumTask implements Task {
    private final String endpoint;

    public GetPicsumTask(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint).with(
                        requestSpecification -> requestSpecification
                                .log().all()
                )
        );
    }

    public static Performable withEndpoint(String endpoint) {
        return instrumented(GetPicsumTask.class, endpoint);
    }
}
