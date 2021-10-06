submitGetRequest =  (coordinates, url) => {
    let params = objectToGetParameters(coordinates);
    console.log('Sending parameters:\n' + params);
    xmlHttpRequestHandler(url + "?" + params);
}

xmlHttpRequestHandler = (url) =>{
    const xhr = new XMLHttpRequest();
    xhr.open("GET", url, false);
    xhr.send(null);
}

fetchRequestHandler = async (url) =>{
    await fetch(url, {
        method: 'GET',
    });
}

objectToGetParameters = (object) => {
    let result = "";
    for (let param in object) {
        result = result + "&" + param + "=" + object[param];
    }
    return result.slice(1, result.length);
}
