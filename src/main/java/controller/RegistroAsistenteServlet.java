package controller;
import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Asistente;
import model.data.DBGenerator;

import model.data.dao.AsistenteDAO;
import org.jooq.DSLContext;

import static model.data.DBGenerator.iniciarBD;
import static model.data.dao.AsistenteDAO.agregarAsistente;

@WebServlet(name = "registroAsistenteServlet", value = "/registroAsistente")
public class RegistroAsistenteServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("EventosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if (req.getParameter("edad").length() != 0 && req.getParameter("nombre").length() != 0 &&
                req.getParameter("rut").length() != 0) {
            String nombre = req.getParameter("nombre");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            Asistente asistente = new Asistente(nombre, edad, rut, null);
            try {
                if (agregarAsistente(asistente)) {
                    req.setAttribute("asistente", asistente);
                    respuesta = req.getRequestDispatcher("registroValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean agregarAsistente(Asistente usuario) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("EventosBD");
        List<Asistente> usuarios = AsistenteDAO.obtenerUsuario(query, "rut", usuario.getRut());
        if (usuarios.size() != 0) {
            return false;
        } else {
            AsistenteDAO.agregarAsistente(query, usuario);
            return true;
        }
    }
}