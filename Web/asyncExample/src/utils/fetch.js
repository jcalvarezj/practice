const XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;

function fetchData(apiUrl) {
    return new Promise((resolve, reject) => {
        const xhttp = new XMLHttpRequest();
        xhttp.open('GET', apiUrl, true);
        xhttp.onreadystatechange = function(event) {
            if (xhttp.readyState === 4) {
                if (xhttp.status === 200)
                    resolve(JSON.parse(xhttp.responseText));
                else
                    reject(new Error('Problem with ', apiUrl));
            }
        };

        xhttp.send();
    });
}

module.exports = fetchData;