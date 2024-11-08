package es.unex.aos;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.*;

import es.unex.aos.resource.SumaResource;

@ApplicationPath("/")
public class SumaApp extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(SumaResource.class);
        return classes;
    }
}