package ru.senina.itmo.web.web_lab_2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor @Getter @Setter
public class Coordinates implements Serializable {
    private double x;
    private double y;
    private double r;
}