Feature: Formulario validacion proceso compra

  Scenario Outline: proceso compra en  https://www.saucedemo.com/
    Given Cris ingresa "<usuario>" y "<contrasena>" y accede a la pagina
    When Se encuentra en el home de la pagina selecciona Backpack y Onesie
    Then Procedo a verificar que los precios se hayan subido correctamente.
    Examples:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |


