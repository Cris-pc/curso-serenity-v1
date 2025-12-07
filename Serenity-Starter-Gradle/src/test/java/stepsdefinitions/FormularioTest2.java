package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import questions.LoginErrorMessage;
import tasks.LoginFail;
import userinterface.sauceDemoPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.core.IsEqual.equalTo;

public class FormularioTest2 {

    @Managed
    WebDriver browser;

    @Before
    public void setup() {
        browser.get("about:blank");
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Cris").can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }


    @Given("Cris desea realizar login en saucedemo con credenciales incorrectas")
    public void cris_desea_realizar_login_en_saucedemo_con_credenciales_incorrectas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://www.saucedemo.com"),
                WaitUntil.the(sauceDemoPage.TXT_USER, isVisible()).forNoMoreThan(5).seconds()
        );
    }
    @When("ingreso a la seccion login llena {string} y {string} incorrectos")
    public void ingreso_a_la_seccion_login_llena_y_incorrectos(String user, String pass) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginFail.fallido(user,pass)
        );
    }
    @Then("Procedo a visualizar login incorrecto")
    public void procedo_a_visualizar_login_incorrecto() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        LoginErrorMessage.value(),equalTo("Epic sadface: Username and password do not match any user in this service")
                )
        );

    }





}
