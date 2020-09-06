valordacasa = float(input('Qual é o valor da casa R$'))
salário = float(input('Quanto é o seu salário R$'))
anos = int(input('Em quantos anos pretende pagar ? '))
mensalidade = valordacasa / (anos * 12)
print('Para pagar uma casa de R${:.2f} em {} anos a prestação será de {:.2f}'.format(valordacasa, anos, mensalidade))
if mensalidade <= salário * 0.3:
    print('O seu empréstimo foi aprovado, efetuaremos breve')
else:
    print('Desculpe a prestação mensal é 30% maior que seu salário logo seu empréstimo foi negado')

