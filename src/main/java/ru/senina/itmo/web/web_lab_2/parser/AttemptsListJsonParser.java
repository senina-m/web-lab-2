package ru.senina.itmo.web.web_lab_2.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.dao.AttemptsList;
import ru.senina.itmo.web.web_lab_2.exceptions.ParsingException;

public class AttemptsListJsonParser extends JsonParser<AttemptsList> {

    public AttemptsListJsonParser(ObjectMapper objectMapper, Class<AttemptsList> classT) {
        super(objectMapper, classT);
    }

    public String fromAttemptToString(Attempt attempt) throws ParsingException {
        try {
            return AttemptsListJsonParser.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(attempt);
        } catch (JsonProcessingException e) {
            throw new ParsingException("Something wrong with parsing attempt with coordinates "
                    + attempt.getCoordinates().getX() + ", " +
                    + attempt.getCoordinates().getY() + ", " +
                    + attempt.getCoordinates().getR() + ", " +
                     attempt.isDoFitArea());
        }
    }

    public Attempt fromStringToAttempt(String json) throws ParsingException {
        try {
            return AttemptsListJsonParser.getObjectMapper().readValue(json, Attempt.class);
        } catch (JsonProcessingException e) {
            throw new ParsingException("Something wrong with attempt string -> object parsing.");
        }
    }

    @Override
    public String fromObjectToString(AttemptsList list) throws ParsingException {
        try {
            return AttemptsListJsonParser.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(list.getList());
        } catch (JsonProcessingException e) {
            throw new ParsingException("Something wrong with parsing attempts list to string.");
        }
    }
}
