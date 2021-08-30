package ru.senina.itmo.web.web_lab_2.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.senina.itmo.web.web_lab_2.exceptions.CoordinatesOutOfBoundsException;

import java.io.Serializable;

@NoArgsConstructor
public class Coordinates implements Serializable {
    @Getter
    private int x;
    @Getter
    private double y;
    @Getter
    private double r;

    public Coordinates(int x, double y, double r) {
        setX(x);
        setY(y);
        setR(r);
    }

    public void setX(int x) {
        if (x >= -4 && x <= 4) {
            this.x = x;
        } else {
            throw new CoordinatesOutOfBoundsException(x, "x");
        }
    }

    public void setY(double y) {
        if (y >= -5 && y <= 3) {
            this.y = y;
        } else {
            throw new CoordinatesOutOfBoundsException(y, "y");
        }
    }

    public void setR(double r) {
        if (r >= 2 && r <= 5) {
            this.r = r;
        } else {
            throw new CoordinatesOutOfBoundsException(r, "r");
        }
    }
}
