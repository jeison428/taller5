package co.edu.unicauca.asae.taller5asae.service;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.taller5asae.entity.Docente;

public interface DocenteService {

    public ResponseEntity<?> save (Docente docente);
    public ResponseEntity<?> update(Long id, Docente docente);
    public ResponseEntity<?> delete(Long id);
    public ResponseEntity<?> findAll();
    public ResponseEntity<?> findById(Long id);
    public ResponseEntity<?> findAllPatronBusqueda(String identificacion, String nombres, String apellidos, String correo);
    public ResponseEntity<?> findAllBusquedaOrdenada(String nombres);
    public ResponseEntity<?> findAllGrupoInvAndVinculacion(String grupoInv, String vinculacion);
    
}
