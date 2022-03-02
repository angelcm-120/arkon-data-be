package com.arkondata.configuracion.dto;

import java.util.List;

public interface UnidadesService {
    public List<Unidades> getAllUnidades();
    public List<Unidades> getAllUnidadesDisponibles();
    public Unidades saveUnidad(Unidades unidades);
}