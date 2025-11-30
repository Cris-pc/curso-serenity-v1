package stepsdefinitions;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;

public class ActorParameterTypes {

    @ParameterType(".*")
    public Actor actor(String name) {
        return Actor.named(name);
    }
}