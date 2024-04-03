function verificar(){
    var data = new Date()
    var ano = data.getFullYear()
    var fano = document.getElementById('txtcarro')
    var res = document.querySelector('div#res')
    if (fano.value.length == 0 || Number(fano.value) > ano){
        window.alert('[ERRO] Verique os dados e tente novamente!')
    } else {
    var fsex = document.getElementsByName('radcor')
    // var idade = ano - Number(fano.value)
    var Cor = ''
    var img = document.createElement('img')
    img.setAttribute('Id', 'foto')
    if (fsex[0].checked){
        Cor = 'branco'
            img.setAttribute('src', 'foto-bebe-m.JPG')
            
        } else if (idade < 21){
            // jovem
            img.setAttribute('src', 'foto-jovem-m.JPG')
        } else if (idade < 50){
            // adulto
            img.setAttribute('src', 'foto-adulto-m.JPG')
        } else {
            // idoso
            img.setAttribute('src', 'foto-idoso-m.JPG')
        }   
        
            
    } else if (fsex[1].checked) {
            gênero = 'Mulher'
            if (idade>= 0 && idade <10){
                // criança
                img.setAttribute('src', 'foto-bebe-f.JPG')
                
            } else if (idade < 21){
                // jovem
                img.setAttribute('src', 'foto-jovem-f.JPG')
            } else if (idade < 50){
                // adulto
                img.setAttribute('src', 'foto-adulto-f.JPG')
            } else {
                // idoso
                img.setAttribute('src', 'foto-idoso-f.JPG')
            } 
        }
        res.style.textAlign = 'center'
        res.innerHTML = `Detectamos ${gênero} com ${idade} anos`
        res.appendChild(img)
    }
}