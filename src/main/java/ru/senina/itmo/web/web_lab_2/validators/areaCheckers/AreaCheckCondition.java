package ru.senina.itmo.web.web_lab_2.validators.areaCheckers;

@FunctionalInterface
public interface AreaCheckCondition {
    boolean validate(double x, double y, double r);
}
