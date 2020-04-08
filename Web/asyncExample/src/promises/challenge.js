const fetchData = require('../utils/fetch')
const API_URL = 'https://rickandmortyapi.com/api/character/'

fetchData(API_URL)
    .then(response => {
        console.log(response.info.count);
        return fetchData(`${API_URL}${response.results[0].id}`);
    })
    .then(response => {
        console.log(response.name);
        return fetchData(`${response.origin.url}`);
    })
    .then(response => console.log(response.dimension))
    .catch(error => console.error(error));