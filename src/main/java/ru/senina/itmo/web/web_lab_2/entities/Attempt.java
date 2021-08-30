package ru.senina.itmo.web.web_lab_2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
public class Attempt implements Serializable {

    @Setter @Getter
    private Coordinates coordinates;

    @Setter @Getter
    private boolean doFitArea;

}
