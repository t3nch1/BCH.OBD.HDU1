#Viaje: Como cliente quiero abrir una cuenta en el Banco de Chile And operar transaccionalmente en el momento.

Feature: Historia de Usuario: Rut And Número de Serie
  Como cliente, quiero poder ingresar mi Rut And el número de Documento de la cédula de identidad para que el Banco me permita aperturar una cuenta.
  Dado que estoy en la página 'Página de Ingreso de Rut And Número de Documento´ y he ingresado el Rut y Número de Serie y no soy cliente del Banco
  Cuandon hago clic en 'QUIERO UNA CUENTA' And mi ingreso de los datos es correcto
  Entonces puedo ver las tres (3) preguntas de seguridad en la 'Página de Preguntas de Seguridad'

#Criterios de Aceptación:

#• Que el Botón QUIERO UNA CUENTA esté deshabilitado hasta que exista un ingreso correcto de los campos indicados en la pantalla.
#• Que exista la validación del formato del Rut.
#• Que exista la validación del Número de Documento.
#• Que exista la validación si es cliente o no del Banco.
# Que no acepte caracteres especiales.
# Que exista conectividad con el servicio de EQUIFAX.

  Background:
    Given que ingreso al sitio web https://obd-front.s3.amazonaws.com/apertura-cuenta/index.html
    And se despliega la pagina de Onboarding Digital con el campo Rut, Numero de Documento, Botón QUIERO UNA CUENTA deshabilitado

#Definición de Scenario: Escenarios
  Scenario: Escenario 1: Presionar QUIERO UNA CUENTA sin completar Rut, Numero de Documento
    When presiono el botón QUIERO UNA CUENTA
    Then el sistema no permitirá continuar
    And en los campos Rut y Numero de Documento mostraran el mensaje Debe completar este campo

  Scenario: Escenario 2: Presionar QUIERO UNA CUENTA completando el Rut valido, Numero de Documento vacio
    When ingreso el rut 17250992-4
    And ingreso el Numero de Documento vacio
    And presiono el botón QUIERO UNA CUENTA
    Then el sistema no permitirá continuar
    And El Campo Numero de Documento mostraran el mensaje Debe completar este campo

  Scenario: Escenario 3: Presionar QUIERO UNA CUENTA completando el rut vacio, Numero de Documento valido
    When ingreso el rut vacio
    And ingreso el Numero de Documento 123_123_123
    And presiono el botón QUIERO UNA CUENTA
    Then el sistema no permitirá continuar
    And Campo Rut mostrara el mensaje Debe completar este campo

  Scenario Outline: Escenario 4: Presionar QUIERO UNA CUENTA completando el Rut valido, Numero de Documento valido
    When ingreso el rut <rut>
    And ingreso el Numero de Documento <numeroDeDocumento>
    And presiono el botón QUIERO UNA CUENTA
    Then el sistema me llevara a la 'Página de Ingreso de Preguntas de Seguridad’ para validar mis preguntas de verificación de identidad

    Examples:
      | rut           | numeroDeDocumento |
      | 17250992-4    | 123_123_123       |
      | 17_250_992-4  | 123123123         |
      | 17250992-4    | 123123123         |
      | 17_250_992-4  | 123_123_123       |
      | 8699898-K     | 123_123_123       |
      | 8_699_898-K   | 123_123_123       |
      | 8699898-k     | 123_123_123       |
      | 8_699_898-k   | 123_123_123       |
      | 8_699_898k    | 123_123_123       |
      | 172509924     | 123_123_123       |
      | 17_250_9924   | 123_123_123       |

#Validaciones de Formato

  Scenario Outline: Escenario 5: Presionar QUIERO UNA CUENTA completando el Rut Invalido
    When ingreso el rut <rut>
    And presiono el botón QUIERO UNA CUENTA
    Then el sistema no permitirá continuar
    And Campo Rut mostrara el mensaje Rut inválido

    Examples:
      | rut           |
      | 17250992-9    |
      | 17250992-k    |
      | 17250992-P    |
      | 123-K         |
      | 172_50_9_9_24 |
      | 172_50_9_9_2-4|

  Scenario Outline: Escenario 6: Presionar QUIERO UNA CUENTA completando el Numero de Documento invalido
    When ingreso el Numero de Documento <numeroDeDocumento>
    And presiono el botón QUIERO UNA CUENTA
    Then el sistema no permitirá continuar
    And Campo Numero de Documento me mostrara el mensaje Debe ingresar un Numero de documento valido

    Examples:
      | numeroDeDocumento |
      | 1_1               |
      | 12_123_345_2      |
      | 654_22_22_22      |
      | 654_d_2_2         |
      | tyr_qwe_qwe       |