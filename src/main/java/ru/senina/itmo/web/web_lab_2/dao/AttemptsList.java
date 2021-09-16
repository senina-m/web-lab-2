package ru.senina.itmo.web.web_lab_2.dao;

import lombok.Getter;
import lombok.Setter;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;

import java.io.Serializable;
import java.util.LinkedList;

public class AttemptsList implements Serializable {

    @Getter @Setter
    private LinkedList<Attempt> list;

    public AttemptsList() {
        this.list = new LinkedList<>();
    }

    public void add(Attempt attempt) {
        list.add(attempt);
    }

}