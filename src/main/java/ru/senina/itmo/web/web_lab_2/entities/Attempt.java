package ru.senina.itmo.web.web_lab_2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Attempt {

    @Setter @Getter
    private Coordinates coordinates;

    @Setter @Getter
    private boolean isFitArea;

//    private Date attemptTime;

//    private Date scriptTime;

}
