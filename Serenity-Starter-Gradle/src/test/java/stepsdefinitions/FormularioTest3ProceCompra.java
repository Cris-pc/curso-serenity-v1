package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import questions.IsLblVisible;
import questions.IsMenuVisible;
import questions.LoginErrorMessage;
import tasks.Login;
import tasks.LoginFail;
import tasks.ProcesoCompra;
import userinterface.sauceDemoPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class FormularioTest3ProceCompra {

    @Managed
    WebDriver browser;

    @Before
    public void setup() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Cris").can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }



    @Given("Cris ingresa {string} y {string} y accede a la pagina")
    public void cris_ingresa_y_y_accede_a_la_pagina(String user, String pass) {
        EnvironmentVariables environmentVariables = Serenity.environmentVariables(); /*Serenity.environmentVariables() es un helper de Serenity que devuelve el objeto con todas las variables de configuración cargadas en tiempo de ejecución.*/
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables) /*estas dos líneas obtienen en tiempo de ejecución la URL base configurada en tu proyecto (sin hardcodearla en el código).*/
                .getProperty("base.url");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(baseUrl),
                Login.satisfactorio(user,pass)
        );

    }
    @When("Se encuentra en el home de la pagina selecciona Backpack y Onesie")
    public void se_encuentra_en_el_home_de_la_pagina_selecciona_backpack_y_onesie() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoCompra.ValidacionPrecio()
        );


    }
    @Then("Procedo a verificar que los precios se hayan subido correctamente.")
    public void procedo_a_verificar_que_los_precios_se_hayan_subido_correctamente() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El label esta visible", IsLblVisible.displayed(),is(true))
        );

    }






}
