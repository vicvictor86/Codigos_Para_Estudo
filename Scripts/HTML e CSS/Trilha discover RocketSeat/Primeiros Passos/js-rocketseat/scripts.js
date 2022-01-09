// const sayMyName = function(){
//     console.log('teste')
// }
//Em vez de escrever uma função na forma acima podemos ter o mesmo resultado escrevedo assim:
// const sayMyName = () => {
//     console.log('teste')
// }
// console.log(sayMyName)

// function sayMyName(name){
//     name()
// }

// sayMyName(
//     () => {
//         console.log('estou em uma callback')
//     }
// )

// function Person(name){
//     this.name = name
//     this.walk = function(){
//         return this.name + " está andando"
//     }
// }

// const mayk = new Person("Mayk")
// const joao = new Person("João")
// let lista = [mayk, joao]
// // console.log(mayk.walk())
// // console.log(joao.walk())

// // const person = {
// //     name: 'maik',
// //     age: 25
// // }

// for(let property of lista){
//     console.log(property.name)
//     console.log(property.walk())
// }