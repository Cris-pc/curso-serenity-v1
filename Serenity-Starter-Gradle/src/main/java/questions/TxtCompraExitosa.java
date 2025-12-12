package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.sauceDemoPageHome;

public class TxtCompraExitosa implements Question<Boolean>  {


    @Override
    public Boolean answeredBy(Actor actor) {

        return sauceDemoPageHome.LBL_FINAL.resolveFor(actor).isVisible();
    }

    public static TxtCompraExitosa displayed() {

        return new TxtCompraExitosa();
    }
}
