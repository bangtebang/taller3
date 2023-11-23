package model.data.dao;

import model.Artista;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class ArtistaDAO {
    public static void agregarArtista(DSLContext query, Artista artista){
        Table tablaUsuario= table(name("Artista"));
        Field[] columnas = tablaUsuario.fields("rut","nombre","edad");
        query.insertInto(tablaUsuario, columnas[0], columnas[1],columnas[2])
                .values(artista.getRut(),artista.getNombre(),artista.getEdad())
                .execute();
    }

    public static List obtenerArtista(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Artista")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArtistas(resultados);
    }
    public static List obtenerArtistas(DSLContext query){
        Result resultados = query.select().from(table("Artista")).fetch();
        return obtenerListaArtistas(resultados);
    }

    private static List obtenerListaArtistas(Result resultados){
        List<Artista> artistas= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            int edad = (int) resultados.getValue(fila,"edad");;
            artistas.add(new Artista(nombre,edad,rut,null));
        }
        return artistas;
    }
    private static String[][] exportardatos(Result resultados){
        String[][] datosResultado=new String[resultados.size()][4];
        for(int registro = 0; registro < resultados.size(); registro ++){
            datosResultado[registro][0] = (String) resultados.getValue(registro,"nombre");
            datosResultado[registro][1] = (String) resultados.getValue(registro,"edad");
        }
        return datosResultado;
    }
    public static boolean validarExistenciaArtista(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Artista")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
