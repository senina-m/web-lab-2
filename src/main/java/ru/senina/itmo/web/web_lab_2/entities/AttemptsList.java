package ru.senina.itmo.web.web_lab_2.entities;

import java.util.LinkedList;

public class AttemptsList {
    private final LinkedList<Attempt> list;

    public AttemptsList() {
        this.list = new LinkedList<>();
    }

    public AttemptsList(LinkedList<Attempt> list) {
        this.list = list;
    }

    public void add(Attempt attempt) {
        list.add(attempt);
    }

}