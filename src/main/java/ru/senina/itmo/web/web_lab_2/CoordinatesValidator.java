package ru.senina.itmo.web.web_lab_2;

import ru.senina.itmo.web.web_lab_2.exceptions.CoordinatesOutOfBoundsException;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;

public class CoordinatesValidator {
    public void validate(Coordinates coordinates){
        double x = coordinates.getX();
        double y = coordinates.getY();
        double r = coordinates.getR();

        if (!(x >= -4 && x <= 4)) {
            throw new CoordinatesOutOfBoundsException(x, "x");
        }
        if (!(y >= -5 && y <= 3)) {
            throw new CoordinatesOutOfBoundsException(y, "y");
        }
        if (!(r >= 2 && r <= 5)) {
            throw new CoordinatesOutOfBoundsException(r, "r");
        }
    }

}
