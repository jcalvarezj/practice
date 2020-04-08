function examplePromise() {
    return new Promise((resolve, reject) => {
        if (true)
            resolve(':)')
        else
            reject(new Error(':('));
    });
}

async function getDataFromPromise() {
    try {
        const result = await examplePromise();
        console.log(result);
    } catch (error) {
        console.error(error);
    }    
}

getDataFromPromise();