package ru.senina.itmo.web.web_lab_2.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senina.itmo.web.web_lab_2.ServerLog;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;
import ru.senina.itmo.web.web_lab_2.parser.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;


@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    private final JsonParser<Coordinates> parser = new JsonParser<>(new ObjectMapper(), Coordinates.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder json = new StringBuilder();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            Coordinates coordinates = parser.fromStringToObject(json.toString());
            getServletContext().getRequestDispatcher("/areaCheck").forward(req, resp);
        }catch (NumberFormatException | NullPointerException exception ){
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }catch (Exception e){
            PrintWriter writer = resp.getWriter();
            writer.write("error");
            writer.close();
            ServerLog.log(Level.WARNING, "Error with parsing parameters of post request in ControllerServlet. Exception: " + e.getMessage());
        }
        super.doPost(req, resp);
    }
}


