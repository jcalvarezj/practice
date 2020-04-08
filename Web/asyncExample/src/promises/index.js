function retornarPromesa() {
    return new Promise((resolve, reject) => {
        if (true)
            resolve(':)');
        else
            reject(':(');
    });
}


retornarPromesa().then(respuesta => {
    console.log(respuesta);
}).catch(error => {
    console.error(error);
})