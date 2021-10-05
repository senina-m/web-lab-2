<%@ page contentType="text/html;charset=UTF-8" %>

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
<body onload="drawPlot(undefined)">
<div class="title">
    <h1 class="title_label">Check if coordinates fit the area</h1>
    <div id="heat"> <a href="https://github.com/senina-m/"> Senina Mariya Michailovna P3212</a><br>
        Variant: 123450</div>
</div>

<h2>! THE INDEX.JSP PAGE !</h2>

<div class="top_box">
    <div class="plot">
        <div id='plot'></div>
    </div>

    <div class="table_form_box">
        <div class="form">
            <form class='form' action="${pageContext.request.contextPath}/controller" method="get">
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
                        <input type="submit" id="submitButton" class='validateBtn' value="Submit">
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <div class="description">
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