package ru.senina.itmo.web.web_lab_2.servletFilters;

import lombok.extern.java.Log;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;
import ru.senina.itmo.web.web_lab_2.exceptions.CoordinatesOutOfBoundsException;
import ru.senina.itmo.web.web_lab_2.validators.CoordinatesValidator;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Takes all requests.
 * If there is some new coordinates -- validate them.
 */
@Log
@WebFilter("/*")
@Dependent
public class ValidationFilter implements Filter {
    private @Inject
    CoordinatesValidator validator;

    @Override
    public void init(FilterConfig fConfig) {
        log.log(Level.FINE, "validation filter started");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.log(Level.FINE, "Got a new request to filter!");
        HttpServletRequest httpRequest  = (HttpServletRequest) request;
        if ("POST".equals(httpRequest .getMethod())) {
            log.log(Level.FINE, "Post request came to Validation Filter");
            //todo: be able to response on post requests
        } else {
            try {
                double x = Double.parseDouble(request.getParameter("x"));
                double y = Double.parseDouble(request.getParameter("y"));
                double r = Double.parseDouble(request.getParameter("r"));
                log.log(Level.FINE, "Coordinates values are x: " + x + ", y: " + y + ", r: " + r);

                Coordinates coordinates = new Coordinates(x, y, r);
                validator.validate(coordinates);
                request.setAttribute("coordinates", coordinates);
                log.log(Level.FINE, "Coordinates from session " + request.getAttribute("coordinates"));
            } catch (NullPointerException | NumberFormatException | CoordinatesOutOfBoundsException e) {
                log.log(Level.WARNING, "Error detected by validation filter: " + e.getMessage());
            }
        }
        chain.doFilter(request, response);
    }
}