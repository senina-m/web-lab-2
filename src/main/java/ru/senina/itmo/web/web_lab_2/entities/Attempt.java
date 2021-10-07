package ru.senina.itmo.web.web_lab_2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor @Getter @Setter
public class Attempt implements Serializable {

    private Coordinates coordinates;
    private boolean doFitArea;
}
