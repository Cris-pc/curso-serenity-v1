package stepsdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.ParameterType;



public class formularioTest1 {

    @Given("{actor} desea realizar login en saucedemo")
    public void desea_realizar_login_en_saucedemo(Actor actor) {
        System.out.println("test1");
    }

    @When("ingreso a la seccion login llena {string} y {string}")
    public void ingresoALaSeccionLoginLlenaUsuarioYContrasena(String usuario, String contrasena) {
        System.out.println("Usuario: " + usuario + ", Contraseña: " + contrasena);
    }

    @Then("Procedo a llenar el formulario de login para ingresar al aplicativo")
    public void procedo_a_llenar_el_formulario_de_login_para_ingresar_al_aplicativo() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("test1");

    }



}
