package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.sauceDemoPage;
import userinterface.sauceDemoPageHome;

public class ProcesoCompraFinal implements Task {
    private final String nombre;
    private final String apellido;
    private final String code;


    public ProcesoCompraFinal(String nombre, String apellido, String code) { /*Constructor necesario para que Serenity pueda instanciar el Task*/
        this.nombre = nombre;
        this.apellido = apellido;
        this.code = code;
    }

    public static ProcesoCompraFinal ValidacionPrecio(String nombre,String apellido, String code) { //Método para crear la tarea correctamente

        return Tasks.instrumented(ProcesoCompraFinal.class , nombre , apellido ,  code); //Crea una versión monitorizada por Serenity (con reportes y screenshots)
    }/*crear la instancia

inyectar dependencias

nombrar bien la tarea en el reporte

generar capturas por cada step*/



    @Override
    public <T extends Actor> void performAs(T actor)   {
        actor.attemptsTo(
                Click.on(sauceDemoPageHome.BTN_MOCHILA),
                Click.on(sauceDemoPageHome.BTN_BODY),
                Click.on(sauceDemoPageHome.BTN_JACKET),
                Click.on(sauceDemoPageHome.BTN_CARRITO),
                Click.on(sauceDemoPageHome.BTN_CHECKOUT),
                Enter.theValue(nombre).into(sauceDemoPageHome.TXT_NAME),
                Enter.theValue(apellido).into(sauceDemoPageHome.TXT_LASTNAME),
                Enter.theValue(code).into(sauceDemoPageHome.TXT_CODE),
                Click.on(sauceDemoPageHome.BTN_CONTINUE),
                Click.on(sauceDemoPageHome.BTN_FINISH)
        );


    }
}
