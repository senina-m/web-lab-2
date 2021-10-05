package ru.senina.itmo.web.web_lab_2.validators;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;

import javax.enterprise.context.Dependent;

@NoArgsConstructor
@Dependent
public class PlotAreaChecker {

    public boolean check(@NotNull Coordinates coordinates) {
        double x = coordinates.getX();
        double y = coordinates.getY();
        double r = coordinates.getR();

        return !((x <= 0 && y <= 0 && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow((r / 2), 2)))
                || (x >= 0 && x <= r / 2 && y <= 0 && y >= -r)
                || (x + r / 2 >= y && y >= 0 && x >= 0));
    }
}
