package com.arkondata.configuracion.dto.Unidades;

import java.util.List;
import java.util.Optional;

public interface UnidadesService {
    public List<Unidades> getAllUnidades();
    public List<Unidades> getAllUnidadesDisponibles();
    public Optional<Unidades> getUnidadDisponibleId(String id);
}