package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class sauceDemoPageHome {
    public static final Target BTN_MOCHILA = Target.the("boton de mochila").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target BTN_BODY = Target.the("TXT de ingreso de contraseña").located(By.id("add-to-cart-sauce-labs-onesie"));
    public static final Target BTN_CARRITO = Target.the("BTN LOGIN").located(By.id("shopping_cart_container"));
    public static final Target ETIQUETA_PRECIO1 = Target.the("ETIQUETA PRECIO 1").located(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div"));
    public static final Target ETIQUETA_PRECIO2 = Target.the("ETIQUETA PRECIO 2").located(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[4]/div[2]/div[2]/div"));
    public static final Target BTN_CHECKOUT = Target.the("BOTON CHECKOUT").located(By.id("checkout"));
    public static final Target LBL_SECCION_CHECKOUT = Target.the("ETIQUETA CHECKOUT ").located(By.xpath("//div[@class='header_secondary_container' and @data-test='secondary-header']//span[@class='title' and @data-test='title' and contains(text(), 'Checkout: Your Information')]"));

}
