package co.edu.unicauca.asae.taller5asae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller5asae.service.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/busqueda-patron/{identificacion}")
    public ResponseEntity<?> buscarPorPatron(@PathVariable String identificacion, @RequestParam String nombres, 
            @RequestParam String apellidos, @RequestParam String correo){
        return this.docenteService.findAllPatronBusqueda(identificacion, nombres, apellidos, correo);
    }

    @GetMapping("/busqueda-ordenada")
    public ResponseEntity<?> buscarNombresOrdenados(@RequestParam String nombres){
        return this.docenteService.findAllBusquedaOrdenada(nombres);
    }

    @GetMapping("/busqueda-grupo-vinculacion/{grupoInv}")
    public ResponseEntity<?> buscarGrupoVinculacion(@PathVariable String grupoInv, @RequestParam String vinculacion){
        return this.docenteService.findAllGrupoInvAndVinculacion(grupoInv, vinculacion);
    }
    
}
