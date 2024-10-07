# RabbitMQ Spike Project

### RabbitMQ Docker Image
``` bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management
```
### Web interface

>http://localhost:15672/

- Loggin username:password -> guest:guest.

<img alt="Rabbit Interface" src="/images/Rabbit Interface.png"/>

### Spring Dependencies

Ingresar estas dependencias en [pom.xml](pom.xml)

``` xml
<!-- RabbitMQ -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.amqp</groupId>
    <artifactId>spring-rabbit-test</artifactId>
</dependency>
```

### application.properties

Configuraciones de conexión para ingresar en [application.properties](/src/main/resources/application.properties).

```
## RabbitMQ Properties ##
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

## Nombre de la cola ##
tpi.queue.name=cola-test
```

## Ejemplo de Consumer

Se genera la clase [Consumer.java](src/main/java/ar/edu/utn/frc/tup/lc/iv/rabbitmq/consumer/Consumer.java)
que tendrá los métodos necesarios para escuchar y recibir los mensajes de la cola configurada.

## Ejemplo de Publisher

Es necesario generar la clase de configuración
[RabbitMQConfig.java](src/main/java/ar/edu/utn/frc/tup/lc/iv/configs/RabbitMQConfig.java)
la cual genera el Java Bean necesario para poder instanciar
[Publisher.java](src/main/java/ar/edu/utn/frc/tup/lc/iv/rabbitmq/publisher/Publisher.java).

## Swagger

> http://localhost:8080/swagger-ui/index.html

# Fuentes

- https://www.youtube.com/watch?v=IdJ3bS-7cbg&t=786s
- https://mstryoda.medium.com/how-to-consume-messages-from-java-applications-with-rabbitmq-in-masstransit-e5c96b6618dd
- https://stackoverflow.com/questions/77499442/spring-boot-rabbitmq-attempt-to-deserialize-unauthorized-class-exception