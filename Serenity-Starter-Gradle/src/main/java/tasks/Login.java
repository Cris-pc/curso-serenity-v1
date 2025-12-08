package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;


import userinterface.sauceDemoPage;

public class Login implements Task {

    private final String user;
    private final String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static Login satisfactorio(String user, String pass) {

        return Tasks.instrumented(Login.class, user, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor)   {
        actor.attemptsTo(
                Enter.theValue(user).into(sauceDemoPage.TXT_USER),
                Enter.theValue(pass).into(sauceDemoPage.TXT_PASS),
                Click.on(sauceDemoPage.BTN_INGRESAR)
        );
        // Pausa manual de 5 segundos
        try { Thread.sleep(5000);} catch (InterruptedException e) { throw new RuntimeException(e); }
    }
}
