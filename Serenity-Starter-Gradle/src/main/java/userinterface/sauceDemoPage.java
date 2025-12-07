package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class sauceDemoPage {
    public static final Target TXT_USER = Target.the("TXT de ingreso de usuario").located(By.id("user-name"));
    public static final Target TXT_PASS = Target.the("TXT de ingreso de contraseña").located(By.id("password"));
    public static final Target BTN_INGRESAR = Target.the("BTN LOGIN").located(By.id("login-button"));
    public static final Target MENU_CONTAINER = Target.the("menu container").located(By.id("menu_button_container"));
    public static final Target LBL_LOGINFAIL = Target.the("LABEL DE LOGIN ERRADO").located(By.xpath("//h3[@data-test='error' and text()='Epic sadface: Username and password do not match any user in this service']"));

}
