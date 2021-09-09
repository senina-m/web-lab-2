package ru.senina.itmo.web.web_lab_2;

import lombok.extern.java.Log;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;
import ru.senina.itmo.web.web_lab_2.exceptions.CoordinatesOutOfBoundsException;
import ru.senina.itmo.web.web_lab_2.exceptions.NoCoordinatesParametersInRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;

@Log
@WebFilter("/*")
public class ValidationFilter implements Filter {
    private final CoordinatesValidator validator = new CoordinatesValidator();

    @Override
    public void init(FilterConfig fConfig) {
        log.log(Level.FINE, "validation filter started");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
        double x = Double.parseDouble(Optional
                .ofNullable(request.getParameter("x"))
                .orElseThrow(NoCoordinatesParametersInRequest::new));
        double y = Double.parseDouble(Optional
                .ofNullable(request.getParameter("y"))
                .orElseThrow(NoCoordinatesParametersInRequest::new));
        double r = Double.parseDouble(Optional
                .ofNullable(request.getParameter("y"))
                .orElseThrow(NoCoordinatesParametersInRequest::new));

        log.log(Level.FINE, "Coordinates values are x: " + x + ", y: " + y + ", r: " + r);

        Coordinates coordinates = new Coordinates(x, y, r);
            validator.validate(coordinates);
            request.setAttribute("coordinates", coordinates);
            removeCoordinatesAttributes(request, new String[]{"x", "y", "r"});
            chain.doFilter(request, response);
        } catch (CoordinatesOutOfBoundsException | NoCoordinatesParametersInRequest e) {
            log.log(Level.WARNING, e.getMessage());
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public void removeCoordinatesAttributes(ServletRequest request, String[] attributes) {
        for (String attribute : attributes) {
            request.removeAttribute(attribute);
        }
    }
}