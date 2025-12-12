package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import questions.IsLblVisible;
import questions.IsMenuVisible;
import questions.LoginErrorMessage;
import questions.TxtCompraExitosa;
import tasks.Login;
import tasks.ProcesoCompraFinal;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class FormularioTest4ProceCompra {
    @Managed
    WebDriver browser; /*crea y administra automáticamente una instancia de WebDriver (Chrome, Firefox, etc.)
✔ Se encarga de inicializar, cerrar y reiniciar el navegador según la configuración de Serenity.
✔ Evita que tengas que crear tú mismo el new ChromeDriver().*/

    @Before
    public void setup() {
        OnStage.setTheStage(Cast.ofStandardActors()); /*Esta línea inicializa el “escenario” Screenplay.*/
        OnStage.theActorCalled("Cris").can(BrowseTheWeb.with(browser)); /*Crea un actor llamado “Cris” Le asigna una habilidad:*/ //Aquí le das al actor la capacidad de interactuar con la web.
        browser.manage().window().maximize(); // maximiza el navegador
    }


    @Given("Cris ingresa {string} y {string} y accede al home de saucedemo")
    public void crisIngresaYYAccedeAlHomeDeSaucedemo(String user, String pass) {
        EnvironmentVariables environmentVariables = Serenity.environmentVariables();
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(baseUrl),
                Login.satisfactorio(user,pass)
        );
    }

    @When("Se encuentra en el home de la pagina selecciona tres productos y llena el checkout con {string}, {string} y {string}")
    public void seEncuentraEnElHomeDeLaPaginaSeleccionaTresProductosYLlenaElCheckoutConY(String nombre, String apellido, String code) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoCompraFinal.ValidacionPrecio(nombre,apellido,code)
        );
    }

    @Then("Procedo a completar el flujo de compra hasta visualizar Thank you for your order!.")
    public void procedoACompletarElFlujoDeCompraHastaVisualizarThankYouForYourOrder() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El menú del home está visible", TxtCompraExitosa.displayed(),is(true)));
    }


}
