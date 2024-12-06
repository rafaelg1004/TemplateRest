package io.swagger.runners;

import io.cucumber.junit.CucumberOptions;
import io.sweagger.utils.BeforeSuite;
import io.sweagger.utils.DataToFeature;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;


@CucumberOptions(
        features = "src/test/resources/features/createGetPicsum.feature",  // Asegúrate de que el archivo .feature esté en esta ruta
        glue = "io.swagger.stepsDefinitions",  // Paquete donde están las definiciones de los pasos
        tags = "@Get",  // Puedes usar un tag para correr un conjunto específico de pruebas
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@RunWith(RunnerPersonalizado.class)
public class CreateGetPicsumRunner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/createGetPicsum.feature");
    }

}
