package com.arkondata.utils.db;

import com.arkondata.models.db.Daos;
import com.arkondata.models.db.Parametro;
import com.arkondata.utils.enums.DB;
import com.arkondata.utils.enums.TipoConsulta;
import com.arkondata.utils.enums.TipoDato;
import com.arkondata.utils.enums.TipoInputOutput;
import com.arkondata.utils.log.Log;
import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static com.arkondata.utils.db.Utilerias.parametrosList;

/**
 * Nombre de proyecto: core
 * Sistema:COB-CLOUD
 * Cloud y DevOps
 * Nombre de clase: Consultas
 * Descripción:  Clase utileria para el manejo de las consultas hacia las bases de datos.
 * Fecha de Modificación:2021-08-10
 * Persona que modifico: MACM
 * Descripción de modificación:

 */
@lombok.Generated
@java.lang.SuppressWarnings({"squid:S3776", "squid:S2095", "squid:S1541","squid:S1874","squid:S2143"})
public class Consultas {
    /**
     * logs
     */
    private static final Log LOGGER = new Log();
    private JdbcTemplate jdbcTemplate = null;
    private String title = null;

    /**
     * Nombre de proyecto: core
     * Sistema:COB-CLOUD
     * Cloud y DevOps
     * Nombre de constructor: Consultas
     * Descripción:  Constructor de consultas, recibe un jdbctemplate instanciado con la conexión a la db que se
     * utilizará
     * para ejecutar la consulta
     * Fecha de Modificación:2021-08-10
     * Persona que modifico: MACM
     * Descripción de modificación:

     */
    /**
     * Constructor Consultas
     *
     * @param jdbcTemplate
     * 	recibe el jdbcTemplate instanciado del servicio en ejecución.
     */
    public Consultas(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.title = Thread.currentThread()
                .getStackTrace()[1].getMethodName();
    }

    /**
     * Nombre de proyecto: core
     * Sistema:COB-CLOUD
     * Cloud y DevOps
     * Nombre de método: consulta
     * Descripción:  Método consulta utilizado para invocar querys o funciones db y retornar resultados en modo map
     * string
     * objects
     * Fecha de Modificación:2021-08-10
     * Persona que modifico: MACM
     * Descripción de modificación:

     */
    /**
     * Función de consulta principal
     *
     * @param daos
     * 	modelo daos a ejecutar
     *
     * @return resultMap de los datos obtenidos de la base de datos.
     */
    public Map<String, Object> consulta(Daos daos) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (jdbcTemplate != null && daos != null && daos.getTipoConsulta()
                    .equals(TipoConsulta.DB_FUNCION)
                    && (daos.getDb()
                    .equals(DB.DB_ORACLE)||daos.getDb()
                    .equals(DB.DB_MSQL) )) {
                List<SqlParameter> paramList = parametrosList(daos.getParametros());

                resultMap = jdbcTemplate.call(new CallableStatementCreator() {
                    /**
                     * Nombre de proyecto: core
                     * Sistema:COB-CLOUD
                     * Cloud y DevOps
                     * Nombre de método: createCallableStatement
                     * Descripción:  Método para el manejo de los call statement para
                     * consumos hacia db
                     * Fecha de Modificación:2021-08-10
                     * Persona que modifico: MACM
                     * Descripción de modificación:

                     */
                    @lombok.Generated
                    @Override
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        return buildCS(daos, con);
                    }
                },paramList);
            }
            else {
                resultMap.put("Exception", "Modelo DAOS Incorrecto");
            }
            return resultMap;
        }
        catch (Exception ex) {
            Map<String, Object> resultMapError = new HashMap<>();
            resultMapError.put("Exception", ex);

            LOGGER.escribeLog(true, Level.INFO, "", title, "", "", "", ex);

            return resultMapError;

        }
    }

    /**
     * Nombre de proyecto: core
     * Sistema:COB-CLOUD
     * Cloud y DevOps
     * Nombre de método: buildCS
     * Descripción:  Método para el manejo de los call statement para consumos hacia db
     * Fecha de Modificación:2021-08-10
     * Persona que modifico: MACM
     * Descripción de modificación:

     */
    /**
     * @param daos
     * @param con
     *
     * @return
     *
     * @throws SQLException
     */
    private CallableStatement buildCS(Daos daos, Connection con) throws
            SQLException {
        CallableStatement cs = con.prepareCall(daos.getFuncion());
        for (Parametro parametro : daos.getParametros()) {
            try {
                setParametros(cs, parametro);
            }
            catch (Exception ex) {
                LOGGER.escribeLogMS(true, Level.INFO, "Consultas", "",
                        "", "", ex.getMessage(), ex);
            }
        }
        return cs;
    }

    /**
     * Nombre de proyecto: core
     * Sistema:COB-CLOUD
     * Cloud y DevOps
     * Nombre de método: setParametros
     * Fecha de Modificación:2021-08-10
     * Persona que modifico: MACM
     * Descripción de modificación:

     */
    /**
     * @param cs
     * @param parametro
     *
     * @return
     *
     * @throws SQLException
     */
    private CallableStatement setParametros(CallableStatement cs, Parametro parametro) throws
            SQLException {
        if (parametro.getTipoIO()
                .equals(TipoInputOutput.DB_ENTRADA)) {
            if (parametro.getTipo()
                    .equals(TipoDato.INTEGER)) {
                cs.setInt(parametro.getIndice(), Integer.parseInt(parametro.getValor()));
            }
            else if (parametro.getTipo()
                    .equals(TipoDato.BIGINT)) {
                cs.setLong(parametro.getIndice(), Long.parseLong(parametro.getValor()));
            }
            else if (parametro.getTipo()
                    .equals(TipoDato.VARCHAR)
                    || parametro.getTipo()
                    .equals(TipoDato.CHAR)
                    || parametro.getTipo()
                    .equals(TipoDato.NVARCHAR)
            ) {
                cs.setString(parametro.getIndice(), parametro.getValor());
            }
            else if (parametro.getTipo()
                    .equals(TipoDato.LONGVARCHAR)
                    || parametro.getTipo()
                    .equals(TipoDato.LONGNVARCHAR)) {
                cs.setString(parametro.getIndice(), parametro.getValor());
            }
            else if (parametro.getTipo()
                    .equals(TipoDato.BOOLEAN)) {
                cs.setBoolean(parametro.getIndice(),
                        Boolean.parseBoolean(parametro.getValor()));
            }
            else if (parametro.getTipo()
                    .equals(TipoDato.DATE)) {
                cs.setDate(parametro.getIndice(),
                        new Date(Long.parseLong(parametro.getValor())));
            }
            else {
                if (parametro.getTipo()
                        .equals(TipoDato.DECIMAL) ||
                        parametro.getTipo()
                                .equals(TipoDato.FLOAT)) {
                    cs.setDouble(parametro.getIndice(),
                            Double.parseDouble(parametro.getValor()));
                }
            }
        }
        else {
            if (parametro.getTipo()
                    .equals(TipoDato.ORACLECURSOR)) {
                cs.registerOutParameter(parametro.getIndice(), OracleTypes.CURSOR);
            }
            else {
                cs.registerOutParameter(parametro.getIndice(), OracleTypes.NUMBER);
            }
        }
        return cs;
    }
}
