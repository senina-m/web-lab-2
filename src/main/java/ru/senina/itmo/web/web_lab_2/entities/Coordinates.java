package ru.senina.itmo.web.web_lab_2.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class Coordinates implements Serializable {
    @Getter
    private double x;
    @Getter
    private double y;
    @Getter
    private double r;

    public Coordinates(double x, double y, double r) {
        setX(x);
        setY(y);
        setR(r);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
    this.r = r;
    }
}
