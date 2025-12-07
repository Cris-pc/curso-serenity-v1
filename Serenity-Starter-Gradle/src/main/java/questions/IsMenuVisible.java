package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.sauceDemoPage;

public class IsMenuVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return sauceDemoPage.MENU_CONTAINER.resolveFor(actor).isVisible();
    }

    public static IsMenuVisible displayed() {
        return new IsMenuVisible();
    }
}
