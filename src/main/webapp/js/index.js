processData = function (event) {
    event.preventDefault();
    const form = document.getElementsByClassName('form');
    console.log('form: ' + form)
    console.log('Start processing form')
    let coordinates = validateForm();
    if (coordinates != null){
        submitData(coordinates, "http://127.0.0.1:8080/web-lab-2-1.0/controller").then(pointsArray => {
            drawPlot(pointsArray);
            drawTable(pointsArray);
        }).catch(err => console.log(err));
    }else{
        console.log('data validation error');
    }
}