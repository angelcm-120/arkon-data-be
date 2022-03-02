package com.arkondata.configuracion.dto.Alcaldias;

import com.arkondata.configuracion.dto.Unidades.Unidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AlcaldiasRepository extends JpaRepository<Alcaldias, BigInteger> {

}