package es.unex.aos;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.*;

import es.unex.aos.resource.CalculadoraResource;

@ApplicationPath("/")
public class CalculadoraApp extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CalculadoraResource.class);
        return classes;
    }
}