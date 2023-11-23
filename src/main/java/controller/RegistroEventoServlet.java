package controller;
import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.EventoMusical;

import model.data.DBGenerator;

import model.data.dao.EventoDAO;
import org.jooq.DSLContext;

import static model.data.DBGenerator.iniciarBD;

@WebServlet(name = "registroEventoServlet", value = "/registroEvento")
public class RegistroEventoServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("EventosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroEvento.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if (req.getParameter("nombre").length() != 0) {
            String nombre = req.getParameter("nombre");
            EventoMusical evento = new EventoMusical(nombre);
            try {
                if (agregarEventoMusical(evento)) {
                    req.setAttribute("evento", evento);
                    respuesta = req.getRequestDispatcher("registroValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean agregarEventoMusical(EventoMusical usuario) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("EventosBD");
        List<EventoMusical> usuarios = EventoDAO.obtenerEventoMusical(query, "nombre", usuario.getNombre());
        if (usuarios.size() != 0) {
            return false;
        } else {
            EventoDAO.agregarEventoMusical(query, usuario);
            return true;
        }
    }
}