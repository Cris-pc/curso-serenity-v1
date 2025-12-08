package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.sauceDemoPage;

public class LoginErrorMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(sauceDemoPage.LBL_LOGINFAIL).answeredBy(actor);
    }

    public static LoginErrorMessage value() {

        return new LoginErrorMessage();
    }
}
