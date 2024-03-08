//fist_class_func

// function somaA(op1, op2){
//     return op1 + op2;
// }

// const soma = function(op1, op2){
//     return op1+ op2;
// }

// const soma = function (op1, op2){
//     return op1+op2;
// };

// console.log(somaA(1, 2));
// console.log(soma(5,5));
// console.log(soma("5",5));
// console.log("Soma de dois valores:");
// console.log(soma(1, 1));

let soma = function (op1, op2){
    return op1 + op2;
};

const sub = function (op1, op2){
    return op1 - op2;
};

function hof(operation , writer, op1 ,op2){
    writer(operation (op1, op2));
}

hof(soma, console.log, 1, 1);

