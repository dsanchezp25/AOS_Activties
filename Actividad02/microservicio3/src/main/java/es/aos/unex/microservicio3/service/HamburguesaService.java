package es.aos.unex.microservicio3.service;

import es.aos.unex.microservicio3.model.Hamburguesa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HamburguesaService {
    private final List<Hamburguesa> hamburguesas = new ArrayList<>();
    private Long currentId = 1L;

    // Constructor para inicializar la lista con valores predeterminados, incluyendo cantidades
    public HamburguesaService() {
        hamburguesas.add(new Hamburguesa(currentId++, "Hamburguesa Clásica", 5.99, 10));
        hamburguesas.add(new Hamburguesa(currentId++, "Hamburguesa BBQ", 6.99, 5));
        hamburguesas.add(new Hamburguesa(currentId++, "Hamburguesa Vegana", 7.49, 0));
    }

    // Añadir una hamburguesa
    public Hamburguesa addHamburguesa(Hamburguesa hamburguesa) {
        hamburguesa.setId(currentId++);
        hamburguesas.add(hamburguesa);
        return hamburguesa;
    }

    // Obtener todas las hamburguesas
    public List<Hamburguesa> getAllHamburguesas() {
        return new ArrayList<>(hamburguesas);
    }

    // Obtener una hamburguesa por ID
    public Optional<Hamburguesa> getHamburguesaById(Long id) {
        return hamburguesas.stream().filter(h -> h.getId().equals(id)).findFirst();
    }

    // Eliminar una hamburguesa por ID
    public boolean deleteHamburguesa(Long id) {
        return hamburguesas.removeIf(h -> h.getId().equals(id));
    }
}
