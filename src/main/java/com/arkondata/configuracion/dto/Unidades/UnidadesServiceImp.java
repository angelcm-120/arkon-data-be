package com.arkondata.configuracion.dto.Unidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UnidadesServiceImp implements UnidadesService {

    @Autowired
    private UnidadesRepository unidadesRepository;

    /**
     * Metodo: getAllUnidades
     * @return devuelve todas las unidades
     */
    @Override
    public List<Unidades> getAllUnidades() {
        return unidadesRepository.findAll();
    }

    /**
     * Metodo: getAllUnidadesDisponibles
     * @return devuelve todas las unidades que están disponibles
     */
    @Override
    public List<Unidades> getAllUnidadesDisponibles() {
        return unidadesRepository.findByVehicleCurrentStatus(BigInteger.ONE);
    }

    /**
     * Metodo: getUnidadDisponibleId
     * @return devuelve una unidad en específico si es que está disponible
     */
    public Optional<Unidades> getUnidadDisponibleId(String id) {
        return unidadesRepository.findById(BigInteger.valueOf(Long.parseLong(id)));
    }

}