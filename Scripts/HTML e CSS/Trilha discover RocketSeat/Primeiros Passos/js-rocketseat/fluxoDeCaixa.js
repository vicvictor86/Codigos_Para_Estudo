let familyFund = {
    receitas: [2200, 3200, 250.43, 360.45],
    despesas: [320.34, 128.45, 176.87, 1450.00, 2000],
}

function sum(receitas){
    let total = 0
    for(let receita of receitas){
        total += receita
    }
    return total
}

function calculaSaldo(receitas, despesas){
    const total = sum(receitas) - sum(despesas)
    const positivo = total >= 0

    let textoSaldo = "negativo"
    if(positivo){
        textoSaldo = "positivo"
    }

    console.log(`Seu saldo é ${textoSaldo}:R$${total.toFixed(2)}`)
}

calculaSaldo(familyFund.receitas, familyFund.despesas)