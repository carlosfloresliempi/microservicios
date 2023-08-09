package com.carro.service.carroservice.controlllers;

import com.carro.service.carroservice.entidades.Carro;
import com.carro.service.carroservice.servicios.CarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros  = carroService.getAll();
        if (carros.isEmpty()){
            return  ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(carros);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
        Carro carro = carroService.getCarroByID(id);
        if (carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }


    @PostMapping("/guardar")
    public ResponseEntity<Carro> guardar(@RequestBody Carro carro){
        return ResponseEntity.ok(carroService.save(carro));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable int usuarioId){
        List<Carro> carros = carroService.findByUsuario(usuarioId);
        if (carros == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

}
