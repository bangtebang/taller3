Análisis de la problemática
============================
Se requiere de una app web para poder darle solucion a la creacion de eventos musicales que contengan artistas y asitentes
para ello se creo una app web la cual contiente las siguientes clases:
(clase principal que contiene a las demás clases como atributo)
- **Clase** `EventoMusical`:
    - **Atributos**:
        - `nombre`: Nombre del evento.

- **Clase** `Artista`:
    - **Atributos**:
        - `nombre`: Nombre del artista.
        - `edad`: edad del artista.
        - `rut`: rut del artista.
- **Clase** `Asistente`:
    - **Atributos**:
        - `nombre`: Nombre del asistente.
        - `edad`: edad del asistente.
        - `rut`: rut del asistente.
Tambien se crearon los archivos jsp para poder mostrar la interfaz grafica de la app web
        - `index.jsp`: pagina principal de la app web.
        - `registroEvento.jsp`: pagina para crear un evento.
        - `registroArtista.jsp`: pagina para crear un artista.
        - `registroAsistente.jsp`: pagina para crear un asistente.
          (mas un archivo css para darle estilo a las paginas
        - `style.css`: archivo css para darle estilo a las paginas
y sus respectivas clases para controlar la informacion
        - `RegistroEventoServlet.java`: controlador de la clase EventoMusical.
        - `RegistroArtistaServlet.java`: controlador de la clase Artista.
        - `RegistroAsistenteServlet.java`: controlador de la clase Asistente.
añadido a esto se creo una base de datos con las siguientes clases para hacer que funcione
        - `EventoDAO.java`: clase que contiene los metodos para la clase EventoMusical.
        - `ArtistaDAO.java`: clase que contiene los metodos para la clase Artista.
        - `AsistenteDAO.java`: clase que contiene los metodos para la clase Asistente.
          (clases creadoras de la base de datos)
        - `DBConnector.java`: clase que contiene los metodos para la conexion con la base de datos.
        - `DBCreator.java`: clase que contiene los metodos para crear la base de datos.