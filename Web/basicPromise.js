const URL_BASE = 'https://swapi.co/api'
const PERSON_URI = '/people/:id'
const OPTS = {
    crossDomain: true
}

function imprimirPersonaje(personajeData) {
    document.write(`Hola! Soy ${personajeData.name}<br/>`)
}

function imprimirError(id) {
    document.write(`No se pudo obtener el personaje de id ${id}`)
}

function obtenerPromesaPersonaPorId(id) {
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

obtenerPromesaPersonaPorId(1).then(imprimirPersonaje).catch(imprimirError)

async function obtenerPersonas() {
    var ids = [2, 3, 4, 5, 6]

    var promesas = ids.map( id => obtenerPromesaPersonaPorId(id) )

    try {
        var personas = await Promise.all(promesas)
        personas.forEach( persona => imprimirPersonaje(persona) )
    } catch (id) {
        imprimirError(id)
    }
}

obtenerPersonas()