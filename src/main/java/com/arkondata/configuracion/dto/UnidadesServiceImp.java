package com.arkondata.configuracion.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
@Transactional
public class UnidadesServiceImp implements UnidadesService {

    @Autowired
    private UnidadesRepository unidadesRepository;

    @Override
    public List<Unidades> getAllUnidades() {
        return unidadesRepository.findAll();
    }

    @Override
    public List<Unidades> getAllUnidadesDisponibles() {
        return unidadesRepository.findByVehicleCurrentStatus(BigInteger.ONE);
    }

    @Override
    public Unidades saveUnidad(Unidades unidad) {
        return unidadesRepository.save(unidad);
    }

}