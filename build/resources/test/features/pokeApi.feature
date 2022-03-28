Feature: Consumir recurso pokeapi
  Como usuario de pokeapi
  necesito obtener la lista del color de los pokemones disponibles en el sitio
  para poder saber cuales colores se encuentra disponibles

  Scenario: Pokemon registrado
    Given  el usuario necesita consultar que colores de pokemones estan en lista
    When se realiza la peticion valida el código de respuesta exitoso
    Then se validara que en los datos de retorno se encuentre el pokemon de color "black"


  Scenario: Recurso no encontrado
    Given  el usuario realiza una petición de pokemon no disponible
    Then se valida codigo de respuesta no exitoso