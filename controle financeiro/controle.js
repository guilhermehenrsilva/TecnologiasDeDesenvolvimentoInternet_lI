const form = document.getElementById('form');
const descImput = document.getElementById('descricao');
const valorImput = document.querySelector('#montante');
const balancoH1 = document.getElementById("balanco");
// terá outras coisas

form.addEventListener("submit", (event) =>{
    event.preventDefault();


    const descTrasacao = descImput.value.trim();
    const valorTransacao = valorImput.value.trim();
    
    if (descTrasacao == ""){
        alert("Informe a descrição da transação")
        descImput.focus();
        return;
    }
    if (valorTransacao ==""){
        alert("Informe o  valor da transação")
        valorImput.focus();
        return;
    }

    const transacao = {
        id: parseInt ,
        desc: descTrasacao ,
        valor: valorTransacao,
    };

    somaAoSaldo();


    descImput.value = '';
    valorImput.value = '';
});


function somaAoSaldo(transacao){
    // recuperar o elemento 
    // pegar o valor e remover o R$

    let valorBalanco = balancoH1.innerHTML.trim();
    valorBalanco = valorBalanco.replace("R$","");
    valorBalanco = parseFloat(valorBalanco);

    alert ((typeof valorBalanco) + valorBalanco)
}
