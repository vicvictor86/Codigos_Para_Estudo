salario = float(input('Digite o valor do seu salário '))
if salario > 1250:
    aumento = salario + (salario * 0.10)
    print('O seu salário agora será de {}'.format(aumento))
else:
    aumento = salario + (salario * 0.15)
    print('O seu salário agora será de {}'.format(aumento))
