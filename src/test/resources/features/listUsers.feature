# new feature
# Tags: optional

Feature: Consumir recurso Regres
  Como un administrador verificado en sistema
  necesito validar la lista de usuarios disponibles en la página
  para poder  verificar cuales son los registrados

  Scenario: Usuario registrado
    Given que el administrador necesita consultar que usuarios se encuentran registrados
    When se valida el código de respuesta exitoso
    Then se validara que en los datos de retorno se encuentre el email del usuario "michael.lawson@reqres.in"



  Scenario: Usuario no encontrado
    Given se hace una peticion a la api
    When cuando se valida el codigo de respuesta
    Then el usuario "nodebestar@reqres.in" no se debe encontrar en la respuesta