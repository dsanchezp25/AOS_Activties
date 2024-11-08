package es.unex.aos.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/resta")
public class RestaResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response resta(@QueryParam("operando1") int operando1, @QueryParam("operando2") int operando2) {
        int resultado = operando1 - operando2;
        return Response.ok("{\"Resultado\":" + resultado + "}").build();
    }
}
