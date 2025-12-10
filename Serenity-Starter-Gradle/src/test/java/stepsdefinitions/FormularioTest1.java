package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.annotations.Managed;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import questions.IsMenuVisible;
import userinterface.sauceDemoPage;
import tasks.Login;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class FormularioTest1 {

    @Managed
    WebDriver browser;

    @Before
    public void setup() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Cris").can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }

    @Given("Cris desea realizar login en saucedemo")
    public void desea_realizar_login() {
        EnvironmentVariables environmentVariables = Serenity.environmentVariables(); /*Serenity.environmentVariables() es un helper de Serenity que devuelve el objeto con todas las variables de configuración cargadas en tiempo de ejecución.*/
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables) /*estas dos líneas obtienen en tiempo de ejecución la URL base configurada en tu proyecto (sin hardcodearla en el código).*/
                .getProperty("base.url");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(baseUrl),
                WaitUntil.the(sauceDemoPage.TXT_USER, isVisible()).forNoMoreThan(5).seconds()
        );
    }

    @When("ingreso a la seccion login llena {string} y {string}")
    public void ingreso_usuario_contrasenia_login(String user, String pass) {
        System.out.println("Usuario: " + user + " / Pass: " + pass);
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.satisfactorio(user, pass)
        );
    }

    @Then("Procedo a ingresar al aplicativo de manera correcta")
    public void proceder_login() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El menú del home está visible", IsMenuVisible.displayed(),is(true)));
    }

}
