Feature: Formulario login saucedemo

  Scenario Outline: login satisfactorio en https://www.saucedemo.com/
    Given Cris desea realizar login en saucedemo
    When ingreso a la seccion login llena "<usuario>" y "<contrasena>"
    Then Procedo a llenar el formulario de login para ingresar al aplicativo
    Examples:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |

