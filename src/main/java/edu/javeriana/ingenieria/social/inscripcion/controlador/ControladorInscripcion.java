package edu.javeriana.ingenieria.social.inscripcion.controlador;

import edu.javeriana.ingenieria.social.inscripcion.dominio.Inscripcion;
import edu.javeriana.ingenieria.social.inscripcion.servicio.ServicioInscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorInscripcion {
    @Autowired
    private ServicioInscripcion servicio;

    @GetMapping("listar")
    public List<Inscripcion> obtenerInscripciones() {
        return servicio.obtenerInscripciones();
    }

    @GetMapping("activas")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesActivas(@RequestParam boolean activa) {
        if(servicio.obtenerInscripciones(activa).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerInscripciones(activa), HttpStatus.OK);
    }

    @GetMapping("obtener")
    public ResponseEntity<Inscripcion> obtenerInscripcion(@RequestParam Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.inscripcionExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerInscripcion(id), HttpStatus.OK);
    }

    @GetMapping("obtenerClase")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesClase(@RequestParam Integer clase){
        if(clase == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerInscripciones(clase).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerInscripciones(clase), HttpStatus.OK);
    }

    @GetMapping("obtenerClaseActivos")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesClase(@RequestParam Integer clase, @RequestParam Boolean activa){
        if(clase == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerInscripciones(activa, clase).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerInscripciones(activa, clase), HttpStatus.OK);
    }

    @GetMapping("obtenerEstudiante")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesEstudiante(@RequestParam Integer estudiante){
        if(estudiante == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerInscripcionesEstudiante(estudiante).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerInscripcionesEstudiante(estudiante), HttpStatus.OK);
    }

    @GetMapping("obtenerInscripcion")
    public ResponseEntity<Inscripcion> obtenerInscripcion(@RequestParam Integer estudiante,  @RequestParam Integer clase){
        if(estudiante == null || clase == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerInscripcion(estudiante, clase) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerInscripcion(estudiante, clase), HttpStatus.OK);
    }
}
