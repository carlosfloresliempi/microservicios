package com.moto.service.motoservice.controllers;

import com.moto.service.motoservice.entidades.Moto;
import com.moto.service.motoservice.servicios.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

   @GetMapping("/listar")
   public ResponseEntity<List<Moto>> getAll() {
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motos);
    }

   @GetMapping("/buscarMoto/{id}")
   public ResponseEntity<Moto> obtenerMoto (@PathVariable("id") int id ){
       Moto moto = motoService.getMotoById(id);
       if (moto == null){
           return ResponseEntity.noContent().build();
       }
       return  ResponseEntity.ok(moto);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
       Moto nuevaMoto = motoService.save(moto);
       return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Moto> motos = motoService.byUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

}
