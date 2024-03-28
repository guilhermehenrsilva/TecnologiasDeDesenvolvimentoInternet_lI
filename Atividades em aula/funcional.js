//Procedural

const numeros = [1, 2, 3, 4 ,5 ];

const quadrados = [];
for (let n of numeros){
    let quadrado = n * n;
    quadrados.push(quadrado)
}

//Funcional
// function quadrado(valor){
//     return quadrados2 = numeros.map(quadrado)
// }
const quadrados2 = numeros.map(n => n * n);


console.log(numeros);
console.log(quadrados);
console.log(quadrados2);