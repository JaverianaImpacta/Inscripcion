package edu.javeriana.ingenieria.social.inscripcion.repositorio;

import edu.javeriana.ingenieria.social.inscripcion.dominio.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioInscripcion extends JpaRepository<Inscripcion, Integer> {
    List<Inscripcion> findAllByClase(Integer clase);

    List<Inscripcion> findAllByActiva(boolean activa);

    List<Inscripcion> findAllByEstudiante(Integer estudiante);

    Inscripcion findOneById(Integer id);
}
