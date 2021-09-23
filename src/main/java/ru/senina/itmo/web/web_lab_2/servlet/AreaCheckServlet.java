package ru.senina.itmo.web.web_lab_2.servlet;

import lombok.extern.java.Log;
import ru.senina.itmo.web.web_lab_2.validators.PlotAreaChecker;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.dao.AttemptsList;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Log
@WebServlet("/check")
public class AreaCheckServlet extends HttpServlet {
    private @Inject PlotAreaChecker areaChecker;
    private @Inject AttemptsList attemptsList;
    private final Lock writeLock = (new ReentrantReadWriteLock()).writeLock();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            Coordinates coordinates = (Coordinates) request.getAttribute("coordinates");
            Attempt lastAttempt = new Attempt(coordinates, areaChecker.check(coordinates));
            
            try {
                writeLock.lock();
                attemptsList.add(lastAttempt);
            }finally{
                writeLock.unlock();
            }
            getServletContext().getRequestDispatcher("/plot.jsp").forward(request, response);
        }catch (Exception e){
            log("wrong coordinates in area check servlet"); //fixme new way to log -- google how it works
        }
    }
}
