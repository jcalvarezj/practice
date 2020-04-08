function imprimirFecha(fecha) {
    console.log(`Hoy es ${fecha}`)
}

function imprimirFechaConEspera(fecha, callback) {
    setTimeout(function() {
        callback(fecha)
    }, 2500)
}

imprimirFecha(new Date())

imprimirFechaConEspera(new Date(), imprimirFecha)