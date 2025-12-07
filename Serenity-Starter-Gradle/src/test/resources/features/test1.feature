Feature: Formulario login saucedemo

  Scenario Outline: login satisfactorio en https://www.saucedemo.com/
    Given Cris desea realizar login en saucedemo
    When ingreso a la seccion login llena "<usuario>" y "<contrasena>"
    Then Procedo a ingresar al aplicativo de manera correcta
    Examples:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |

  Scenario Outline: login Fallido en https://www.saucedemo.com/
    Given Cris desea realizar login en saucedemo con credenciales incorrectas
    When ingreso a la seccion login llena "<usuario>" y "<contrasena>" incorrectos
    Then Procedo a visualizar login incorrecto
    Examples:
      | usuario       | contrasena   |
      | standard_user | secret_sace  |

