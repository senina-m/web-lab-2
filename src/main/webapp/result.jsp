<jsp:useBean id="attemptsList" scope="session" class="ru.senina.itmo.web.web_lab_2.dao.AttemptsList"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Area counter - lab 2</title>
    <script src="https://cdn.jsdelivr.net/npm/@svgdotjs/svg.js@3.0/dist/svg.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/Plot.js"></script>
    <script type="text/javascript" src="js/Connector.js"></script>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" media="handheld" href="styles/mobile.css">
    <link rel="stylesheet" media="screen and (min-width: 1150px)" href="styles/screen.css">
</head>
<body onload='{drawPlot(${attemptsList.listToJson()})}'>
<div class="title">
    <h1 class="title_label">Results</h1>
    <div id="heat"><a href="https://github.com/senina-m/"> Senina Mariya Michailovna P3212</a><br>
        Variant: 123450
    </div>
</div>

<div class="top_box">
    <div class="plot">
        <div id='plot'></div>
        <div>
            <input type="button" id="clearButton" class="clearButton" onclick="clearPlot()" value="Clear">
        </div>
    </div>
</div>

<h2><a href="plot.jsp"> Submit new coordinates! </a></h2>

<div id="table_block">
    <table id='table' class="styled-table">
        <thead>
        <tr>
            <td> x</td>
            <td> y</td>
            <td> r</td>
            <td> result</td>
        </tr>
        </thead>
        <tbody id="table_body">
        <c:forEach var="attempt" items="${attemptsList.list}">
            <tr>
                <td> ${attempt.coordinates.x}</td>
                <td> ${attempt.coordinates.y}</td>
                <td> ${attempt.coordinates.r}</td>
                <td> ${attempt.doFitArea} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="description">
    This service can let you check if the coordinates you have entered fits the area.
    The area size is fixed by the value of radius R. It has to be a double number from 2 to 5.
    The coordinates X and Y shows you where the point will be located on the plot. X has to be an integer number from -4
    to 4. And Y is a double number from -5 to 5.
    To enter values you can submit them in form OR just click for plot in the place you want them to be.

    Enjoy the service!
</div>
</body>
</html>