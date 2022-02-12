package co.edu.unicauca.asae.taller5asae.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller5asae.entity.Docente;

public interface DocenteRepository extends CrudRepository<Docente, Long>{

    public List<Docente> findByIdentificacionIgnoreCaseContainingOrNombresIgnoreCaseContainingOrApellidosIgnoreCaseContainingOrCorreoIgnoreCaseContaining(
        String identificacion, String nombres, String apellidos, String correo
        );
    public List<Docente> findByNombresIgnoreCaseOrderByIdentificacionDesc(String nombres);
    public List<Docente> findByGrupoInvAndTipoVinculacion(String grupoInv, String vinculacion);
    
}
