package ru.senina.itmo.web.web_lab_2.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.parser.JsonParser;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;

@Named()
@SessionScoped
@NoArgsConstructor
//todo do i need to create a specific annotation to declare the type of jop that this class does
public class AttemptsList implements Serializable {
//    private @Inject JsonParser<AttemptsList> parser; //todo inject parser

    @Setter
    private LinkedList<Attempt> list = new LinkedList<>();

    public void add(Attempt attempt) {
        list.add(attempt);
    }

    public Attempt[] getList(){
        return (Attempt[]) this.list.toArray();
    }

    public String listToJson (){
        return null; //todo parse to json
    }
}