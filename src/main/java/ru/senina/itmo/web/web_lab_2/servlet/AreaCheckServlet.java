package ru.senina.itmo.web.web_lab_2.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.senina.itmo.web.web_lab_2.parser.AttemptsListJsonParser;
import ru.senina.itmo.web.web_lab_2.ServerLog;
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


@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    private final AttemptsListJsonParser parser = new AttemptsListJsonParser(new ObjectMapper(), AttemptsList.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession();

            int x = Integer.parseInt(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            double r = Double.parseDouble(req.getParameter("r"));

            Coordinates coordinates = new Coordinates(x, y, r);

            Attempt lastAttempt = new Attempt(coordinates, coordinatesCheck(coordinates));

            AttemptsList attemptsList = (AttemptsList) Optional.ofNullable(session.getAttribute("listOfAttempts")).orElse(new AttemptsList());
            attemptsList.add(lastAttempt);

            String jsonListOfAttempts = parser.fromObjectToString(attemptsList);

            writeJsonResponse(resp.getWriter(), jsonListOfAttempts);


            session.setAttribute("listOfAttempts", attemptsList);
            session.setAttribute("jsonListOfAttempts", jsonListOfAttempts);
            req.setAttribute("dataValidationResult", true);
//            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }catch (NumberFormatException | NullPointerException exception ){
            req.setAttribute("dataValidationResult", false);
//            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }catch (Exception e){
            PrintWriter writer = resp.getWriter();
            writer.write("error");
            writer.close();
            ServerLog.log(Level.WARNING, "Error with parsing parameters of post request in AreaCheckerServlet. Exception: " + e.getMessage());
        }
    }

    private boolean coordinatesCheck(@NotNull Coordinates coordinates){
        int x = coordinates.getX();
        double y = coordinates.getY();
        double r = coordinates.getR();

        return  !((x <= 0 && y <= 0 && (Math.pow(x,2) + Math.pow(y, 2) <= Math.pow((r / 2), 2)))
                    || (x >= 0 && x <= r / 2 && y <= 0 && y >= -r)
                    || (x + r / 2 >= y && y >= 0 && x >= 0));
    }

    private void writeJsonResponse (PrintWriter writer, String json){
        writer.write(json);
        writer.close();
    }
}
