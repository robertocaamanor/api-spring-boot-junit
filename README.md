# api-spring-boot-junit

Proyecto de creación de API Rest sencilla para una prueba técnica.

# Instrucciones

## Base de datos

Ejecutar el archivo `api-spring-boot-coopeuch.sql` en un servidor MySQL, el cual creará la base de datos que se requiere para guardar, consultar, actualizar y eliminar los datos.

## Microservicio

Si usas IntelliJ IDEA, hacer click derecho sobre el archivo pom.xml y en las opciones de Maven, seleccionar Reload Project. Luego, en la parte superior del programa, hacer click en la flecha verde para ejecutar el microservicio.

Dentro del MS se encuentran los siguientes endpoints:

###GET 
http://localhost:8080/api/persons

Hace un listado de todas las personas que están almacenadas en la base de datos

Resultado esperado:

`[
    {
        "id": 2,
        "name": "Macarena Ripamonti",
        "userName": "macaripa",
        "date": "2022-01-07T03:00:00.000+00:00"
    }
]`

http://localhost:8080/api/person/{id}

Hace un listado de la persona que está dentro de una base de datos según la ID consultada

Resultado esperado:

`{
    "id": 2,
    "name": "Macarena Ripamonti",
    "userName": "macaripa",
    "date": "2022-01-07T03:00:00.000+00:00"
}`

### POST

http://localhost:8080/api/person

Realiza el guardado de un nuevo nombre dentro de la base de datos.

Request:

`{
"date": "2022-01-07",
"name": "Irací Hassler",
"userName": "iracixstgo"
}`

Resultado esperado:

`{
"id": 3,
"name": "Irací Hassler",
"userName": "iracixstgo",
"date": "2022-01-07T17:15:38.555+00:00"
}`

### PUT
http://localhost:8080/api/person/{id}

Actualiza el dato dentro de un registro de una base de datos. Para ello se requiere que dentro del endpoint se envíe el ID del usuario que quiera modificar alguno de sus campos.

Request:

`{
"date": "2022-01-07",
"name": "Maca Ripa",
"userName": "mripamonti"
}`

Resultado esperado:

`{
"id": 2,
"name": "Maca Ripa",
"userName": "mripamonti",
"date": "2022-01-07T00:00:00.000+00:00"
}`

### DELETE

http://localhost:8080/api/person/{id}

Borra un registro de la base de datos según su ID

Resultado esperado:

`{
"response": "Usuario eliminado"
}`

## SwaggerUI

Una vez levantado el microservicio, se podrá acceder a la documentación a través del siguiente link: http://localhost:8080/swagger-ui.html.
