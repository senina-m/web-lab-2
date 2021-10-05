package ru.senina.itmo.web.web_lab_2.exceptions;

public class NoCoordinatesParametersInRequest extends RuntimeException{

    public NoCoordinatesParametersInRequest(String paramName){
        super("Problem with parameter \""+paramName+ "\"");
    }
}
