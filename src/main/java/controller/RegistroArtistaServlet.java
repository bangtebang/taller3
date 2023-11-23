package controller;
import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Artista;
import model.data.DBGenerator;
import org.jooq.DSLContext;
import model.data.dao.ArtistaDAO;
import static model.data.DBGenerator.iniciarBD;

@WebServlet(name = "registroArtistaServlet", value = "/registroArtista")
public class RegistroArtistaServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("EventosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroArtista.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if (req.getParameter("edad").length() != 0 && req.getParameter("nombre").length() != 0 &&
                req.getParameter("rut").length() != 0) {
            String nombre = req.getParameter("nombre");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            Artista artista = new Artista(nombre, edad, rut, null);
            try {
                if (agregarArtista(artista)) {
                    req.setAttribute("artista", artista);
                    respuesta = req.getRequestDispatcher("registroValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean agregarArtista(Artista usuario) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("EventosBD");
        List<Artista> usuarios = ArtistaDAO.obtenerArtista(query, "rut", usuario.getRut());
        if (usuarios.size() != 0) {
            return false;
        } else {
            ArtistaDAO.agregarArtista(query, usuario);
            return true;
        }
    }
}