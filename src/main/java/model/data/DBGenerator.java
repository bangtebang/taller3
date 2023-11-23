package model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(connection,nombreBD);
        crearTablaEventoMusical(create);
        crearTablaArtista(create);
        crearTablaAsistente(create);
        DBConnector.closeConnection();
    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaEventoMusical(DSLContext create){
        create.createTableIfNotExists("EventoMusical").column("nombre",VARCHAR(50))
                .constraint(primaryKey("nombre")).execute();
    }
    private static void crearTablaArtista(DSLContext create){
        create.createTableIfNotExists("Artista").column("rut",VARCHAR(50))
                .column("nombre",VARCHAR(100))
                .column("edad",INTEGER)
                .constraint(primaryKey("rut")).execute();
    }
    private static void crearTablaAsistente(DSLContext create){
        create.createTableIfNotExists("Asistente").column("rut",VARCHAR(50))
                .column("nombre",VARCHAR(100))
                .column("edad",INTEGER)
                .constraint(primaryKey("rut")).execute();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }
}
