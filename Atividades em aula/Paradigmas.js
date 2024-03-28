// procedura1
const sum = function (v1, v2){
    return v1 + v2 ;

}
//POO
 
class Person {
    //atributos
    constructor(nome, cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
   



//metodos 
saudar () {
    console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);

    const guilherme = new Person ("Guilherme", "123");

}
}