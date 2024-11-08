package es.unex.aos.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/calculadora")
public class CalculadoraResource {

    public CalculadoraResource() {}

    // Devuelve un mensaje de bienvenida, asi aseguramos que se haya creado bien
    @GET
    @Path("/bienvenido")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bienvenido() {
        return Response.ok("Calculadora").build();
    }

    // Suma de dos números invocando al servicio Suma
    @GET
    @Path("/suma")
    @Produces(MediaType.APPLICATION_JSON)
    public Response suma(@QueryParam("operando1") int operando1, @QueryParam("operando2") int operando2) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Suma/suma")
                .queryParam("operando1", operando1)
                .queryParam("operando2", operando2);

        // Realiza la petición y obtiene el resultado en formato JSON
        String result = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Imprimir el contenido del resultado crudo para depuración
        System.out.println("Respuesta del servicio de suma: " + result);

        // Parsear el resultado JSON
        JSONObject json = new JSONObject(result);
        double resultado = json.getDouble("Resultado");

        client.close();

        return Response.ok("Resultado suma: " + resultado).build();
    }



    @GET
    @Path("/resta")
    @Produces(MediaType.APPLICATION_JSON)
    public Response resta(@QueryParam("operando1") int operando1, @QueryParam("operando2") int operando2) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Resta/resta")
                .queryParam("operando1", operando1)
                .queryParam("operando2", operando2);

        // Realiza la petición y obtiene el resultado en formato JSON
        String result = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Parsear el JSON
        JSONObject json = new JSONObject(result);
        double resultado = json.getDouble("Resultado");

        client.close();

        // Devuelve el resultado de la resta
        return Response.ok("Resultado resta: " + resultado).build();
    }


    @GET
    @Path("/multiplicacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response multiplicacion(@QueryParam("operando1") int operando1, @QueryParam("operando2") int operando2) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Multiplicacion/multiplicacion")
                .queryParam("operando1", operando1)
                .queryParam("operando2", operando2);

        // Realiza la petición y obtiene el resultado en formato JSON
        String result = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Parsear el JSON
        JSONObject json = new JSONObject(result);
        double resultado = json.getDouble("Resultado");

        client.close();

        // Devuelve el resultado de la multiplicación
        return Response.ok("Resultado multiplicación: " + resultado).build();
    }



    @GET
    @Path("/division")
    @Produces(MediaType.APPLICATION_JSON)
    public Response division(@QueryParam("operando1") int operando1, @QueryParam("operando2") int operando2) {
        // Validación para evitar la división por cero
        if (operando2 == 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: No se puede dividir por 0").build();
        }

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Division/division")
                .queryParam("operando1", operando1)
                .queryParam("operando2", operando2);

        // Realiza la petición y obtiene el resultado en formato JSON
        String result = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Parsear el JSON
        JSONObject json = new JSONObject(result);
        double resultado = json.getDouble("Resultado");

        client.close();

        // Devuelve el resultado de la división
        return Response.ok("Resultado división: " + resultado).build();
    }

}
