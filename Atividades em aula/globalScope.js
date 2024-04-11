//Global Scope
const nome = "Guilherme";
let idade = 26;
var filhos = 42;


function printData(){
    console.log(`Nome ${nome}, Idade ${idade}, Numero de Filhos ${filhos}`);
    idade = 23;

    for (let i = 1; i < 11; i++) {
        console.log(i);    
    }


}

printData();
console.log(`Nome ${nome}, Idade ${idade}, Numero de filhos ${filhos}`);

console.log("-------------------------------------------------------------------------------------------------");


let nome2; 

function globalAuto(){
    nome2 = "Guigui";
    idade2 =  42;

}
globalAuto();

console.log(`Nome ${nome2} Idade ${idade2}`)


console.log("-------------------------------------------------------------------------------------------------");

function scopeTest(){
    const brand = "Volvo";
    let model = "CX40";
    //Atribuição SEM declaração
    var year = "'2024'"

    console.log(`${brand} ${model} ${year}`);

}
scopeTest();
console.log(`${brand} ${model} ${year}`);
