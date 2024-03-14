//Dinamica

let x ;

console.log(x);
console.log(typeof(x));
console.log("----------");

let din = 3.33333;

console.log(din);
console.log(din.toFixed());
console.log(typeof din);
console.log("----------");

din = "emerson";

console.log(din);
console.log(typeof din);
console.log(din.toUpperCase());


let myVar;

let soma = myVar +1 ;
console.log(soma);;


//teste


//Higher orden function 

function maiorQue(){
    let num = (Math.random() * 100).toFixed;
    console.log(`Random ${num}`);

    return function(valor){
        return valor > num;
    }
}

console.log(maiorQue()(50));


// usandi uma variavel intermediaria 

const funRef = maiorQue()
console.log(funcRef(10));

console.log(maiorQue);