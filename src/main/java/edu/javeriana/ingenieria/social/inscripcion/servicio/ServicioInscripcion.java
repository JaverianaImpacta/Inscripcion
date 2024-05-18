package edu.javeriana.ingenieria.social.inscripcion.servicio;

import edu.javeriana.ingenieria.social.inscripcion.dominio.Inscripcion;
import edu.javeriana.ingenieria.social.inscripcion.repositorio.RepositorioInscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServicioInscripcion {
    @Autowired
    private RepositorioInscripcion repositorio;

    public List<Inscripcion> obtenerInscripciones(){
        return repositorio.findAll();
    }

    public List<Inscripcion> obtenerInscripciones(Integer clase){
        return repositorio.findAllByClase(clase);
    }

    public List<Inscripcion> obtenerInscripciones(boolean activa){
        return repositorio.findAllByActiva(activa);
    }

    public List<Inscripcion> obtenerInscripciones(boolean activa, Integer clase){
        List<Inscripcion> inscripciones = obtenerInscripciones(activa);
        return inscripciones.stream().filter(i -> Objects.equals(i.getClase(), clase)).toList();
    }

    public List<Inscripcion> obtenerInscripcionesEstudiante(Integer estudiante){
        return repositorio.findAllByEstudiante(estudiante);
    }

    public Inscripcion obtenerInscripcion(Integer estudiante, Integer clase){
        List<Inscripcion> inscripciones = obtenerInscripciones(true, clase);
        return inscripciones.stream().filter(i-> Objects.equals(i.getEstudiante(), estudiante)).findFirst().orElse(null);
    }

    public Inscripcion obtenerInscripcion(Integer id){
        return repositorio.findOneById(id);
    }

    public boolean inscripcionExiste(Integer id){
        return repositorio.existsById(id);
    }

}
