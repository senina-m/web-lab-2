submitData = async (coordinates, url) => {
    console.log('Sending json:\n' + JSON.stringify(coordinates))

    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(coordinates)
    });

    if (response.ok) {
        let json = await response.json();
        console.log(json);
        return json;
    } else {
        throw new httpError("Ошибка HTTP: " + response.status);
    }
}