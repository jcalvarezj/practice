const XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;

const API = 'https://rickandmortyapi.com/api/character/'

function fetchData(apiUrl, callback) {
    const xhttp = new XMLHttpRequest();
    xhttp.open('GET', apiUrl, true);

    xhttp.onreadystatechange = function(event) {
        if (xhttp.readyState === 4) {
            if (xhttp.status === 200)
                callback(null, JSON.parse(xhttp.responseText));
            else {
                const error = new Error(`Error ${apiUrl}`);
                callback(error, null);
            }
        }
    };

    xhttp.send();
}

fetchData(API, function(error1, data1) {
    if (!error1) {
        const charId = data1.results[0].id;
        fetchData(`${API}${charId}`, function(error2, data2) {
            if (!error2) {
                fetchData(data2.origin.url, function(error3, data3) {
                    if (!error3) {
                        console.log(data1.info.count)
                        console.log(data2.name)
                        console.log(data3.dimension)
                    }
                    else
                        console.error(error3);
                })
            }
            else
                console.error(error2);
        })
    }
    else
        console.error(error1);
});