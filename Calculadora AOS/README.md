# Calculadora API

Este proyecto es una API REST para realizar operaciones aritméticas básicas (suma, resta, multiplicación y división) mediante servicios independientes. La API permite interactuar con estos servicios a través de diferentes endpoints.

## Requisitos previos

- **Java**: La API está diseñada para ejecutarse con **Java 17**.
- **Maven**: Se utiliza Maven en su versión **3.8.0** como herramienta de gestión de dependencias.
- **Servidor de aplicaciones**: WildFly (configurado mediante el plugin `wildfly-maven-plugin`).
- **Postman o cualquier cliente REST**: Para probar las solicitudes a los diferentes endpoints de la API.

## Endpoints de la API

- `GET /calculadora/bienvenido`: Devuelve un mensaje de bienvenida para verificar que la API está funcionando.
- `GET /calculadora/suma?operando1={valor}&operando2={valor}`: Realiza una suma de dos números.
- `GET /calculadora/resta?operando1={valor}&operando2={valor}`: Realiza una resta de dos números.
- `GET /calculadora/multiplicacion?operando1={valor}&operando2={valor}`: Realiza una multiplicación de dos números.
- `GET /calculadora/division?operando1={valor}&operando2={valor}`: Realiza una división de dos números. Si el divisor es cero, devuelve un error.

## Herramientas utilizadas

### Jakarta EE

Utilizado para construir la API REST con JAX-RS.

Dependencia en `pom.xml`:

```xml
<dependency>
  <groupId>jakarta.platform</groupId>
  <artifactId>jakarta.jakartaee-api</artifactId>
  <version>10.0.0</version>
  <scope>provided</scope>
</dependency>
```

### WildFly
Servidor de aplicaciones configurado mediante el plugin `wildfly-maven-plugin` para el despliegue.

Dependencia en `pom.xml`:
```xml
<plugin>
    <groupId>org.wildfly.plugins</groupId>
    <artifactId>wildfly-maven-plugin</artifactId>
    <version>4.2.2.Final</version>
</plugin>
```
### Jersey Client

Utilizado para realizar las peticiones HTTP hacia los servicios REST de las operaciones (Suma, Resta, Multiplicación y División).

Dependencia en `pom.xml`:

```xml
<dependency>
  <groupId>org.glassfish.jersey.core</groupId>
  <artifactId>jersey-client</artifactId>
  <version>4.0.0-M1</version>
</dependency>

```


### JSON Processing
Utilizado para manipular los resultados en formato JSON.

Dependencia en `pom.xml`:
```xml
<dependency>
  <groupId>org.json</groupId>
  <artifactId>json</artifactId>
  <version>20210307</version>
</dependency>
```

### Maven

Se utiliza Maven **3.8.0** para la gestión de dependencias y compilación del proyecto.

Plugin en `pom.xml`:
```xml
<plugin>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.8.0</version>
</plugin>
```


## Enlace a video descriptivo


Puedes acceder al video explicativo del proyecto haciendo clic en el siguiente enlace:

[Ver video explicativo](https://unexes-my.sharepoint.com/:v:/g/personal/dsanchezfe_alumnos_unex_es/EQaG5uoDtw5LgbjXXJ9GHYQB1Quj4TfkNtr-pDjH11K34g?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWZlcnJhbEFwcCI6Ik9uZURyaXZlRm9yQnVzaW5lc3MiLCJyZWZlcnJhbEFwcFBsYXRmb3JtIjoiV2ViIiwicmVmZXJyYWxNb2RlIjoidmlldyIsInJlZmVycmFsVmlldyI6Ik15RmlsZXNMaW5rQ29weSJ9fQ&e=kJusfy)
