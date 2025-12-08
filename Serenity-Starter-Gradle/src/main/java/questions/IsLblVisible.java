package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.sauceDemoPage;
import userinterface.sauceDemoPageHome;

public class IsLblVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return sauceDemoPageHome.LBL_SECCION_CHECKOUT.resolveFor(actor).isVisible();
    }

    public static IsLblVisible displayed() {
        return new IsLblVisible();
    }
}
