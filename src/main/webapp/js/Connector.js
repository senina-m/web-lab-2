submitData = async (coordinates, url) => {
    console.log('Sending json:\n' + JSON.stringify(coordinates))

    await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(coordinates)
    });
}