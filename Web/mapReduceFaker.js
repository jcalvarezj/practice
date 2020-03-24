// Example of Map-Reduce on a generated DataSet with faker
// Use  npm init  on new project folder
// Then  npm i faker --save  to install faker
// Copy this file on project folder as  index.js

const faker = require('faker')

const orders = []

for (let i = 0; i < 1000; i++) {
    orders.push({
        name: faker.name.findName(),
        city: faker.address.city(),
        zipCode: faker.address.zipCode(),
        product: faker.commerce.productName(),
        price: parseInt(faker.commerce.price(), 10)
    })    
}

const directionCityOrders = orders.filter(order => order.city.match(/^(North|South|West|East).*/))

const cityDirectionsOnlyOrders = directionCityOrders.map(order => {
    let direction = order.city.split(" ")[0]
    return {
        city: direction,
        price: order.price
    }
})

const groupCount = cityDirectionsOnlyOrders.reduce((count, order) => {
    let city = order.city
    if (count[city])
        count[city]++
    else
        count[city] = 1
    return count
}, [])

console.log(groupCount)