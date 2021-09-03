<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Area counter - lab 2</title>
    <script src="https://cdn.jsdelivr.net/npm/@svgdotjs/svg.js@3.0/dist/svg.min.js"></script>
    <script type="text/javascript" src="js/Plot.js"></script>
    <script type="text/javascript" src="js/Table.js"></script>
    <script type="text/javascript" src="js/CoordinatesValidator.js"></script>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" media="handheld" href="styles/mobile.css">
    <link rel="stylesheet" media="screen and (min-width: 1150px)" href="styles/screen.css">
</head>
<body>
<script>
    drawPlot(<%=session.getAttribute("jsonListOfAttempts")%>);
</script>
<div class="title">
    <h1 class="title_label">Check if coordinates fit the area</h1>
    <div id="heat"> Senina Mariya Michailovna P3212<br>Variant: 12019</div>
</div>

<div class="top_box">
    <div class="plot">
        <div id='plot'></div>
        <div>
            <input type="button" class="clearButton" onclick="clearPlot()" value="Clear">
        </div>
    </div>

    <div class="table_form_box">
        <div class="form">
            <form class='form'>
                <fieldset class="shadowbox">
                    <legend>Enter coordinates:</legend>
                    <div>
                        <div>
                            <label for="x">X: </label>
                            <select id="x" name="x" class='x'>
                                <option value="-4" selected="selected">-4</option>
                                <option value="-3">-3</option>
                                <option value="-2">-2</option>
                                <option value="-1">-1</option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                    </div>
                    <div>
                        <div>
                            <label for="y">Y:</label>
                            <input type="text" class='y field' id="y" name="y" value="1">
                        </div>
                    </div>
                    <div>
                        <div>
                            <label for="r">R:</label>
                            <input type="text" class='r field' id="r" name="r" value="2">
                        </div>
                    </div>
                    <div>
                        <input type="submit" id="submitButton" class='validateBtn' value="Submit"
                               onclick="processData(event)">
                    </div>
                </fieldset>
            </form>
        </div>
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
                <jsp:useBean id="attemptsList" scope="session"
                             class="ru.senina.itmo.web.web_lab_2.entities.AttemptsList"/>
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
    </div>
    <div class="description">
        <a href="hello-servlet">Hello Servlet</a>

        <ol id="notes">
            <li> Тег u нужен чтобы <u>подчеркнуть</u> слово</li>
            <li> Тег i нужен чтобы <i>написать курсивом</i></li>
            <li> Тег b нужен чтобы <b>сделать жирным</b></li>
        </ol>

        Описание происходящего на странице, если вам всё ещё не понятно, что происходит понятно и не будет но читайте
        дальше, как будто тут что-то очень умное написано... Описание происходящего на странице, если вам всё ещё не
        понятно, что происходит понятно и не будет но читайте дальше, как будто тут что-то очень умное
        написано...Описание происходящего на странице, если вам всё ещё не понятно, что происходит понятно и не будет но
        читайте дальше, как будто тут что-то очень умное написано...Описание происходящего на странице, если вам всё ещё
        не понятно, что происходит понятно и не будет но читайте дальше, как будто тут что-то очень умное
        написано...Описание происходящего на странице, если вам всё ещё не понятно, что происходит понятно и не будет но
        читайте дальше, как будто тут что-то очень умное написано...Описание происходящего на странице, если вам всё ещё
        не понятно, что происходит понятно и не будет но читайте дальше, как будто тут что-то очень умное
        написано...Описание происходящего на странице, если вам всё ещё не понятно, что происходит понятно и не будет но
        читайте дальше, как будто тут что-то очень умное написано...
    </div>
</div>
</body>
</html>