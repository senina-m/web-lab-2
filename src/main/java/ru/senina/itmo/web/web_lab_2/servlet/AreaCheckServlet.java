package ru.senina.itmo.web.web_lab_2.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import ru.senina.itmo.web.web_lab_2.parser.AttemptsListJsonParser;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.entities.AttemptsList;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Level;

@Log
@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    private final AttemptsListJsonParser parser = new AttemptsListJsonParser(new ObjectMapper(), AttemptsList.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            Coordinates coordinates = (Coordinates) request.getAttribute("coordinates");

            HttpSession session = request.getSession();
            Attempt lastAttempt = new Attempt(coordinates, coordinatesCheck(coordinates));
            AttemptsList attemptsList = (AttemptsList) Optional.ofNullable(session.getAttribute("listOfAttempts")).orElse(new AttemptsList());
            attemptsList.add(lastAttempt);

            session.setAttribute("listOfAttempts", attemptsList);
            getServletContext().getRequestDispatcher("/plot.jsp").forward(request, response);
        }catch (Exception e){
            log.log(Level.WARNING, "wrong coordinates in area check servlet");
        }
    }

    private boolean coordinatesCheck(@NotNull Coordinates coordinates){
        double x = coordinates.getX();
        double y = coordinates.getY();
        double r = coordinates.getR();

        return  !((x <= 0 && y <= 0 && (Math.pow(x,2) + Math.pow(y, 2) <= Math.pow((r / 2), 2)))
                    || (x >= 0 && x <= r / 2 && y <= 0 && y >= -r)
                    || (x + r / 2 >= y && y >= 0 && x >= 0));
    }
}
