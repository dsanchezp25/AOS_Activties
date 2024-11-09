package es.aos.unex.microservicio3.controller;

import es.aos.unex.microservicio3.model.Hamburguesa;
import es.aos.unex.microservicio3.service.HamburguesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hamburguesas")
public class HamburguesaController {

    @Autowired
    private HamburguesaService hamburguesaService;

    @PostMapping
    public ResponseEntity<Hamburguesa> addHamburguesa(@RequestBody Hamburguesa hamburguesa) {
        return new ResponseEntity<>(hamburguesaService.addHamburguesa(hamburguesa), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Hamburguesa> getAllHamburguesas() {
        return hamburguesaService.getAllHamburguesas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hamburguesa> getHamburguesaById(@PathVariable Long id) {
        Optional<Hamburguesa> hamburguesa = hamburguesaService.getHamburguesaById(id);
        return hamburguesa.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/pedir")
    public ResponseEntity<String> pedirHamburguesa(@PathVariable Long id) {
        Optional<Hamburguesa> hamburguesa = hamburguesaService.getHamburguesaById(id);
        if (hamburguesa.isPresent()) {
            Hamburguesa h = hamburguesa.get();
            if (h.getCantidad() > 0) {
                h.setCantidad(h.getCantidad() - 1);
                return new ResponseEntity<>("Hamburguesa servida con éxito. Cantidad restante: " + h.getCantidad(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Lo siento, no quedan hamburguesas de este tipo.", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("Hamburguesa no encontrada.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHamburguesa(@PathVariable Long id) {
        if (hamburguesaService.deleteHamburguesa(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
