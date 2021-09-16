package ru.senina.itmo.web.web_lab_2.servlet;

import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;

import static java.lang.Boolean.parseBoolean;

@Log
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Optional.of(parseBoolean(req.getParameter("coordinates"))).orElse(false)) {
            getServletContext().getRequestDispatcher("/areaCheck").forward(req, resp);
        } else {
            log.log(Level.WARNING, "Wrong arguments in controller servlet");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        super.doPost(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Optional.of(parseBoolean(req.getParameter("coordinates"))).orElse(false)) {
            getServletContext().getRequestDispatcher("/areaCheck").forward(req, resp);
        } else {
            log.log(Level.WARNING, "Wrong arguments in controller servlet");
            getServletContext().getRequestDispatcher("/testPage.jsp").forward(req, resp);
        }
        super.doGet(req, resp);
    }
}


