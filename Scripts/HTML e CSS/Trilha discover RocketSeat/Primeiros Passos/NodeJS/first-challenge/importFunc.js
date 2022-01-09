const getFlag = require('./flags')

const name = getFlag("--name")
const greeting = getFlag("--greeting")

console.log(`Bem vindo ${name}, ${greeting}`)