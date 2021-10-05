package ru.senina.itmo.web.web_lab_2.dao;

import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.parser.AttemptsListJsonParser;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;

@Named()
@SessionScoped
@NoArgsConstructor
//todo do i need to create a specific annotation to declare the type of jop that this class does
public class AttemptsList implements Serializable {
    private @Inject AttemptsListJsonParser parser;

    @Setter
    private LinkedList<Attempt> list = new LinkedList<>();

    public void add(Attempt attempt) {
        list.add(attempt);
    }

    public Attempt[] getList(){
        return this.list.toArray(new Attempt[0]);
    }

    public String listToJson (){
        return parser.fromObjectToString(this);
    }
}