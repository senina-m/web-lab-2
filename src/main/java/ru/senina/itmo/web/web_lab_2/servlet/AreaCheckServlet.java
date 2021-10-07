package ru.senina.itmo.web.web_lab_2.servlet;

import lombok.extern.java.Log;
import ru.senina.itmo.web.web_lab_2.dao.AttemptsList;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;
import ru.senina.itmo.web.web_lab_2.validators.PlotAreaChecker;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;

/**
 * Adding attempt object to session bean.
 * Redirect to plot page after coordinates checking.
 */
@Log
@WebServlet("/controller/check")
public class AreaCheckServlet extends HttpServlet {
    private @Inject PlotAreaChecker areaChecker;
    private @Inject AttemptsList attemptsList;
    private final Lock writeLock = (new ReentrantReadWriteLock()).writeLock();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response){
        log.log(Level.FINE, "Got request to check area!");
        try{
            Coordinates coordinates = (Coordinates) request.getAttribute("coordinates");
            Attempt lastAttempt = new Attempt(coordinates, areaChecker.check(coordinates));
            log.log(Level.FINE, "AttemptsList:\n" + attemptsList.listToJson());
            try { //FIXME а такая ситуация вообще возможна? Чтобы от одного клиента запросы приходили одновременно?
                writeLock.lock();
                attemptsList.add(lastAttempt);
                log.log(Level.FINE, "Added last attempt to attempts list");
            }finally{
                writeLock.unlock();
            }
            log.log(Level.FINE, "Redirect bask to plot.jsp");
            getServletContext().getRequestDispatcher("/plot.jsp").forward(request, response);
        }catch (Exception e){
            log("wrong coordinates in area check servlet"); //fixme new way to log -- google how it works
        }
    }
}
