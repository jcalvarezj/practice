const URL_BASE = 'https://swapi.co/api'
const PERSON_URI = '/people/:id'
const OPTS = {
    crossDomain: true
}

function imprimirPersonaje(personajeData) {
    document.write(`Hola! Soy ${personajeData.name}`)
}

function imprimirError(id) {
    document.write(`No se pudo obtener el personaje de id ${id}`)
}

function obtenerPersonaPorId(id) {
    return new Promise(
        (resolve, reject) => {
            const URL = `${URL_BASE}${PERSON_URI.replace(':id', id)}`

            $.get(URL, OPTS, function(personajeData) {
                resolve(personajeData)
            }).fail( function() {
                reject(id)
            })
        }
    )
}

obtenerPersonaPorId(1).then(imprimirPersonaje).catch(imprimirError)