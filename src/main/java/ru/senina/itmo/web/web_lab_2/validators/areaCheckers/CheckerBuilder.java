package ru.senina.itmo.web.web_lab_2.validators.areaCheckers;

import java.util.ArrayList;

public class CheckerBuilder {
    private ArrayList<AreaCheckCondition> list;

    public void initChecker(){
        list = new ArrayList<>();
    }

    public void addTriangleIn4Quoter(){
        AreaCheckCondition triangleIn4QuoterCondition = (double x, double y, double r) ->
                (x - r / 2 <= y && y <= 0 && x >= 0);
        list.add(triangleIn4QuoterCondition);
    }

    public void addCircleIn3Quoter(){
        AreaCheckCondition circleIn3QuoterCondition = (double x, double y, double r) ->
                (x <= 0 && y <= 0 && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow((r / 2), 2)));
        list.add(circleIn3QuoterCondition);
    }

    public void addSquare1Quoter(){
        AreaCheckCondition squareIn1QuoterCondition = (double x, double y, double r) ->
                (x >= 0 && x <= r && y >= 0 && y <= r);
        list.add(squareIn1QuoterCondition);
    }

    public AreaChecker getChecker(){
        return new AreaChecker(list);
    }

}
