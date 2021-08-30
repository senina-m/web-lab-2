package ru.senina.itmo.web.web_lab_2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import ru.senina.itmo.web.web_lab_2.entities.Attempt;
import ru.senina.itmo.web.web_lab_2.entities.AttemptsList;
import ru.senina.itmo.web.web_lab_2.entities.Coordinates;
import ru.senina.itmo.web.web_lab_2.parser.AttemptsListJsonParser;

public class TestParsingAttemptsListToJson {

    //fixme: deserialization

    public static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    @Test
    public void testFromObjectToJson() {
        Attempt attempt1 = new Attempt(new Coordinates(1, 2, 4), true);
        Attempt attempt2 = new Attempt(new Coordinates(-4, -5, 2), false);
        Attempt attempt3 = new Attempt(new Coordinates(0, 0.3, 2.3), true);
        AttemptsList attemptsList = new AttemptsList();
        attemptsList.add(attempt1);
        attemptsList.add(attempt2);
        attemptsList.add(attempt3);

        AttemptsListJsonParser parser = new AttemptsListJsonParser(objectMapper, AttemptsList.class);
        String json = parser.fromObjectToString(attemptsList);
        System.out.println(json);
//        AttemptsList newObject = parser.fromStringToObject(json);
        System.out.println("Test finished");
    }

    @Test
    public void attemptSerialization() {
        Attempt attempt = new Attempt(new Coordinates(1, 2, 4), true);
        AttemptsListJsonParser parser = new AttemptsListJsonParser(objectMapper, AttemptsList.class);
        String json = parser.fromAttemptToString(attempt);
        System.out.println(json);
//        AttemptsList newAttempt = parser.fromStringToObject(json);
        System.out.println("Attempt test finished");
    }

}
