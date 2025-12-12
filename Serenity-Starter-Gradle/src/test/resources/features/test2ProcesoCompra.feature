Feature: Formulario validacion proceso compra

  Scenario Outline: proceso compra en  https://www.saucedemo.com/
    Given Cris ingresa "<usuario>" y "<contrasena>" y accede a la pagina
    When Se encuentra en el home de la pagina selecciona Backpack y Onesie
    Then Procedo a verificar que los precios se hayan subido correctamente.
    Examples:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |

  Scenario Outline: Proceder a realizar una compra con  flujo completo en  https://www.saucedemo.com/
    Given Cris ingresa "<usuario>" y "<contrasena>" y accede al home de saucedemo
    When Se encuentra en el home de la pagina selecciona tres productos y llena el checkout con "<nombre>", "<apellido>" y "<code>"
    Then Procedo a completar el flujo de compra hasta visualizar Thank you for your order!.
    Examples:
      | usuario       | contrasena   | nombre   | apellido| code |
      | standard_user | secret_sauce | Cristhian| Flores  | 1777 |