package com.arkondata.configuracion.dto.Alcaldias;

import java.util.List;
import java.util.Optional;

public interface AlcaldiasService {
    public List<Alcaldias> getAllAlcaldias();
    public Optional<Alcaldias> getAlcaldiaId(String id);
}