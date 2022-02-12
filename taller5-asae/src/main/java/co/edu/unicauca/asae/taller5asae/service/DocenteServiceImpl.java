package co.edu.unicauca.asae.taller5asae.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller5asae.entity.Docente;
import co.edu.unicauca.asae.taller5asae.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {
    
    @Autowired
    private DocenteRepository docenteRepo;

    @Override
    public ResponseEntity<?> save(Docente docente) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        try {
            Docente objDocente = this.docenteRepo.save(docente);
            respuesta = ResponseEntity.status(HttpStatus.CREATED).body(objDocente);
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al guardar el Docente en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> update(Long id, Docente docente) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        try {
            Docente objDocente = this.docenteRepo.findById(id).orElse(null);
            if (objDocente != null) {
                objDocente.setApellidos(docente.getApellidos());
                objDocente.setCategoriaMic(docente.getCategoriaMic());
                objDocente.setCorreo(docente.getCorreo());
                objDocente.setDepartamento(docente.getDepartamento());
                objDocente.setEscalafon(docente.getEscalafon());
                objDocente.setFacultad(docente.getFacultad());
                objDocente.setGenero(docente.getGenero());
                objDocente.setGrupoInv(docente.getGrupoInv());
                objDocente.setIdentificacion(docente.getIdentificacion());
                objDocente.setLineaInv(docente.getLineaInv());
                objDocente.setLinkCvLac(docente.getLinkCvLac());
                objDocente.setNombres(docente.getNombres());
                objDocente.setObservacion(docente.getObservacion());
                objDocente.setTelefono(docente.getTelefono());
                objDocente.setTipoIdentificacion(docente.getTipoIdentificacion());
                objDocente.setTipoVinculacion(docente.getTipoVinculacion());
                objDocente.setTitulo(docente.getTitulo());
                objDocente.setUniversidadTitulo(docente.getUniversidadTitulo());

                respuesta = ResponseEntity.ok().body(this.docenteRepo.save(objDocente));
            }else{
                respuestas.put("mensaje", "Error al realizar la actualizacion del Docente en la base de datos");
                respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException dae){
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", dae.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        try {
            Docente objDocente = this.docenteRepo.findById(id).orElse(null);
            this.docenteRepo.delete(objDocente);
        } catch (DataAccessException dae){
            respuestas.put("mensaje", "Error al encontrar el Docente en la base de datos");
            respuestas.put("descripción del error", dae.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        try {
            
        } catch (DataAccessException dae){
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", dae.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        try {
            
        } catch (DataAccessException dae){
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", dae.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> findAllPatronBusqueda(String identificacion, String nombres, String apellidos, String correo) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        List<Docente> docentesDB = null;
        try {
            docentesDB = this.docenteRepo.findByIdentificacionIgnoreCaseContainingOrNombresIgnoreCaseContainingOrApellidosIgnoreCaseContainingOrCorreoIgnoreCaseContaining(identificacion, nombres, apellidos , correo);
            if (docentesDB.isEmpty()){
                respuestas.put("mensaje", "No se encontro ninguna coincidencia en la busqueda de Docentes.");
                respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.NOT_FOUND);
            }else{
                respuesta = new ResponseEntity<List<Docente>>(docentesDB, HttpStatus.OK);
            }
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> findAllBusquedaOrdenada(String nombres) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        List<Docente> docentesDB = null;
        try {
            docentesDB = this.docenteRepo.findByNombresIgnoreCaseOrderByIdentificacionDesc(nombres);
            if (docentesDB.isEmpty()){
                respuestas.put("mensaje", "No se encontro ninguna coincidencia en la busqueda de Docentes.");
                respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.NOT_FOUND);
            }else{
                respuesta = new ResponseEntity<List<Docente>>(docentesDB, HttpStatus.OK);
            }
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @Override
    public ResponseEntity<?> findAllGrupoInvAndVinculacion(String grupoInv, String vinculacion) {
        HashMap<String, Object> respuestas = new HashMap<>();
        ResponseEntity<?> respuesta = null;
        List<Docente> docentesDB = null;
        try {
            docentesDB = this.docenteRepo.findByGrupoInvAndTipoVinculacion(grupoInv, vinculacion);
            if (docentesDB.isEmpty()){
                respuestas.put("mensaje", "No se encontro ninguna coincidencia en la busqueda de Docentes.");
                respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas, HttpStatus.NOT_FOUND);
            }else{
                respuesta = new ResponseEntity<List<Docente>>(docentesDB, HttpStatus.OK);
            }
        } catch (Exception e) {
            respuestas.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuestas.put("descripción del error", e.getMessage());
            respuesta = new ResponseEntity<HashMap<String, Object>>(respuestas,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

}
