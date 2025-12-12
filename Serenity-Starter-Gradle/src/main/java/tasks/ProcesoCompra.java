package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.sauceDemoPageHome;
import net.serenitybdd.screenplay.questions.Text;

public class ProcesoCompra implements Task {


    public ProcesoCompra() { /*Constructor necesario para que Serenity pueda instanciar el Task*/

    }

    public static ProcesoCompra ValidacionPrecio() { //Método para crear la tarea correctamente

        return Tasks.instrumented(ProcesoCompra.class); //Crea una versión monitorizada por Serenity (con reportes y screenshots)
    }/*crear la instancia

inyectar dependencias

nombrar bien la tarea en el reporte

generar capturas por cada step*/



    @Override
    public <T extends Actor> void performAs(T actor)   {
        actor.attemptsTo(
                Click.on(sauceDemoPageHome.BTN_MOCHILA),
                Click.on(sauceDemoPageHome.BTN_BODY),
                Click.on(sauceDemoPageHome.BTN_CARRITO)
        );
        // Pausa manual de 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String precio1 = Text.of(sauceDemoPageHome.ETIQUETA_PRECIO1).answeredBy(actor);
        String precio2 = Text.of(sauceDemoPageHome.ETIQUETA_PRECIO2).answeredBy(actor);
        if (!precio1.equals("$29.99")) {
            throw new AssertionError("Precio 1 incorrecto: " + precio1);
        }

        if (!precio2.equals("$7.99")) {
            throw new AssertionError("Precio 2 incorrecto: " + precio2);
        }
        actor.attemptsTo(Click.on(sauceDemoPageHome.BTN_CHECKOUT));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
