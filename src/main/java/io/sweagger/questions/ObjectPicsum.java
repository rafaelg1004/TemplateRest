package io.sweagger.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ObjectPicsum implements Question<List<Object>> {

    @Override
    public List<Object> answeredBy(Actor actor) {
        // Aquí puedes extraer el contenido de la respuesta y validarlo
        return SerenityRest.lastResponse().jsonPath().getList("$");
    }

    public static ObjectPicsum validateImages() {
        return new ObjectPicsum();
    }
}

