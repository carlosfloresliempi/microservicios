package com.carro.service.carroservice.servicios;

import com.carro.service.carroservice.entidades.Carro;
import com.carro.service.carroservice.repositorio.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAll(){
        return carroRepository.findAll();
    }
    public Carro getCarroByID(int id){
        return carroRepository.findById(id).orElse(null);
    }
    public Carro save(Carro carro){
        return carroRepository.save(carro);
    }

    public List<Carro> findByUsuario(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }
}
