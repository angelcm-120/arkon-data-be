package com.arkondata.configuracion.dto.Alcaldias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlcaldiasServiceImp implements AlcaldiasService {

    @Autowired
    private AlcaldiasRepository alcaldiasRepository;

    /**
     * Metodo: getAllAlcaldias
     * @return devuelve todas las alcaldias
     */
    @Override
    public List<Alcaldias> getAllAlcaldias() {
        return alcaldiasRepository.findAll();
    }

    @Override
    public Optional<Alcaldias> getAlcaldiaId(String id) {
        return alcaldiasRepository.findById(BigInteger.valueOf(Long.parseLong(id)));
    }

}