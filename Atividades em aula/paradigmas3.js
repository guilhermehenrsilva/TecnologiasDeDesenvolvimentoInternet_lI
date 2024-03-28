const bill =  {
    nome: 'Bill Gates',
    cpf: '123',
    nascimento: '1/1/1965',
    saudar: function(){
        console.log(`Nome: ${this.nome}, CPF: ${this.cpf}, Nascimento ${this.nascimento }`);

    }
};

console.log(bill.saudar());