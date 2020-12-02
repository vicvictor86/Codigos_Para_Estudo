soma = 0
quant = 0
for c in range(1, 501):
    if c % 2 != 0 and c % 3 == 0:
        soma += c
        quant = quant + 1
print('A soma de todos os {} números é {}'.format(quant, soma))
