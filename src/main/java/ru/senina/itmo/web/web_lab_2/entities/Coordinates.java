package ru.senina.itmo.web.web_lab_2.entities;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor @Getter @Setter @ToString
public class Coordinates implements Serializable {
    private double x;
    private double y;
    private double r;
}