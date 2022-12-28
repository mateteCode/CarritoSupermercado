# CARRITO DE COMPRAS
- Trabajo Práctico para el curso de Codo a codo 4.0 Spring
- Alumno: Matías Lorenzo
- Comisión: 22814

## Requerimientos
Hacer un API Rest que simule un carrito de compras de distintos productos y generar el precio final de la compra.

# Tecnologías utilizadas
- Spring Boot
- Spring Data JPA
- MySQL Connector
- Lombok
- Model Mapper
- Java 17
- IntelliJ
- Postman
- XAMPP

## Instalación
- Crear una base de datos limpia con nombre carrito_db y editar el archivo application.properties con el usuario y la contraseña usadas en el gestor de bases de datos mysql.
- Se puede importar en Postman el archivo Carrito.postman_collection.json, ubicado en el path raiz con las colecciones de consultas de las API con el formato JSON correspondientes.

## Endpoints
### Entidad Marcas
- GET:    http://localhost:8080/marcas                    Listar las marcas
- POST:   http://localhost:8080/marcas/nuevo              Agregar una marca
- DELETE: http://localhost:8080/marcas/eliminar/{id}      Eliminar la marca asociada al id
- GET:    http://localhost:8080/marcas/obtener/{id}       Obtener la marca asociada al id

### Entidad Categorias
- GET:    http://localhost:8080/categorias                    Listar las marcas
- POST:   http://localhost:8080/categorias/nuevo              Agregar una marca
- DELETE: http://localhost:8080/categorias/eliminar/{id}      Eliminar la marca asociada al id
- GET:    http://localhost:8080/categorias/obtener/{id}       Obtener la marca asociada al id

### Entidad Tipos
- GET:    http://localhost:8080/tipos                     Listar los tipos
- POST:   http://localhost:8080/tipos/nuevo               Agregar un tipo
- DELETE: http://localhost:8080/tipos/eliminar/{id}       Eliminar el tipo asociado al id
- GET:    http://localhost:8080/tipos/obtener/{id}        Obtener el tipo asociado al id

### Entidad Productos
- GET:    http://localhost:8080/productos                     Listar los productos
- POST:   http://localhost:8080/productos/nuevo               Agregar un producto
- DELETE: http://localhost:8080/productos/eliminar/{id}       Eliminar el producto asociado al id
- GET:    http://localhost:8080/productos/obtener/{id}        Obtener el producto asociado al id

### Entidad Clientes
- GET:    http://localhost:8080/clientes                     Listar los clientes
- POST:   http://localhost:8080/clientes/nuevo               Agregar un tipo
- DELETE: http://localhost:8080/clientes/eliminar/{id}       Eliminar el tipo asociado al id
- GET:    http://localhost:8080/clientes/obtener/{id}        Obtener el tipo asociado al id

### Entidad Carritos
- GET:    http://localhost:8080/carrito                      Listar los carritos
- POST:   http://localhost:8080/carritos/nuevo               Agregar un carrito
- DELETE: http://localhost:8080/carritos/eliminar/{id}       Eliminar el carrito asociado al id
- GET:    http://localhost:8080/carritos/obtener/{id}        Obtener el carrito asociado al id

### Entidad Pedidos
- GET:    http://localhost:8080/pedidos                     Listar los pedidos
- POST:   http://localhost:8080/pedidos/nuevo               Agregar un pedido
- DELETE: http://localhost:8080/pedidos/eliminar/{id}       Eliminar pedido asociado al id
- GET:    http://localhost:8080/pedidos/obtener/{id}        Obtener el pedido asociado al id

## Futuras Mejoras
Agregarle JWT y Spring Security para darle seguridad para que solo los administradores puedan agregar productos y que cada cliente pueda ver sólo sus propias compras.