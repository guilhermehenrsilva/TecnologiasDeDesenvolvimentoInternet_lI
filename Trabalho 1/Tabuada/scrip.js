function tabuadaMult() {
    let num = document.getElementById('txtn')
    let tab = document.getElementById('seltab')

    if (num.value.length == 0 ){
        window.alert('Por favor, digite um numero')
    } else {
        let n = Number(num.value)
        let c = 1 
        tab.innerHTML = ''
        while (c <= 10){
            let item = document.createElement('option')
            item.text = `${n} x ${c} = ${n*c}`
            item.value = `tab${c}`
            tab.appendChild(item)
            c++
        }
    }
}

function tabuadaSoma() {
    let num = document.getElementById('txtn')
    let tab = document.getElementById('seltab2')

    if (num.value.length == 0 ){
        window.alert('Por favor, digite um numero')
    } else {
        let n = Number(num.value)
        let c = 1 
        tab.innerHTML = ''
        while (c <= 10){
            let item = document.createElement('option')
            item.text = `${n} + ${c} = ${n+c}`
            item.value = `tab${c}`
            tab.appendChild(item)
            c++
        }
    }
}
function tabuadaSub() {
    let num = document.getElementById('txtn')
    let tab = document.getElementById('seltab3')

    if (num.value.length == 0 ){
        window.alert('Por favor, digite um numero')
    } else {
        let n = Number(num.value)
        let c = 1 
        tab.innerHTML = ''
        while (c <= 10){
            let item = document.createElement('option')
            item.text = `${n} - ${c} = ${n-c}`
            item.value = `tab${c}`
            tab.appendChild(item)
            c++
        }
    }
}
function tabuadaDiv() {
    let num = document.getElementById('txtn')
    let tab = document.getElementById('seltab4')

    if (num.value.length == 0 ){
        window.alert('Por favor, digite um numero')
    } else {
        let n = Number(num.value)
        let c = 1 
        tab.innerHTML = ''
        while (c <= 10){
            let item = document.createElement('option')
            item.text = `${n} / ${c} = ${n/c}`
            item.value = `tab${c}`
            tab.appendChild(item)
            c++
        }
    }
}