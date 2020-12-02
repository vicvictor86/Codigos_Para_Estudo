soma = 0
quant = 0
for c in range(1, 7):
    n = int(input('Digite o {} número '.format(c)))
    if n % 2 == 0:
        soma = soma + n
        quant = quant + 1
print('A soma entre os {} valores foi {}.'.format(quant, soma))