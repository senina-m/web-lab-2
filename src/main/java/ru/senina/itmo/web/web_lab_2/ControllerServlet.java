package ru.senina.itmo.web.web_lab_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;


@WebServlet("")
public class ControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int x = Integer.parseInt(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            double r = Double.parseDouble(req.getParameter("r"));
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


