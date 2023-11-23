package model.data.dao;

import model.EventoMusical;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class EventoDAO {
    public static void agregarEventoMusical(DSLContext query, EventoMusical eventoMusical){
        Table tablaEventoMusical= table(name("EventoMusical"));
        Field[] columnas = tablaEventoMusical.fields("nombre");
        query.insertInto(tablaEventoMusical, columnas[0])
                .values(eventoMusical.getNombre())
                .execute();
    }

    public static List obtenerEventoMusical(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("EventoMusical")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaEventosMusicales(resultados);
    }
    public static List obtenerEventosMusicales(DSLContext query){
        Result resultados = query.select().from(table("EventoMusical")).fetch();
        return obtenerListaEventosMusicales(resultados);
    }

    private static List obtenerListaEventosMusicales(Result resultados){
        List<EventoMusical> usuarios= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre = (String) resultados.getValue(fila,"nombre");
            usuarios.add(new EventoMusical(nombre));
        }
        return usuarios;
    }
    private static String[][] exportardatos(Result resultados){
        String[][] datosResultado=new String[resultados.size()][1];
        for(int registro = 0; registro < resultados.size(); registro ++){
            datosResultado[registro][0] = (String) resultados.getValue(registro,"nombre");
        }
        return datosResultado;
    }
    public static boolean validarExistenciaEventoMusical(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("EventoMusical")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
