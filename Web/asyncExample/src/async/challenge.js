const fetchData = require("../utils/fetch");
const API = 'https://rickandmortyapi.com/api/character/';

async function getDataFromAPI(apiUrl) {
    try {
        const result1 = await fetchData(apiUrl);
        console.log(result1.info.count);

        const result2 = await fetchData(apiUrl + result1.results[0].id);
        console.log(result2.name);

        const result3 = await fetchData(result1.results[0].origin.url);
        console.log(result3.dimension);
    } catch (error) {
        console.error(error);
    }
}

getDataFromAPI(API);