numero = int(input('Digite o número : '))
quant = 0
for c in range(2, numero):
    if numero % c == 0:
        print('Esse número não é primo')
        quant += 1
        break
if quant == 0:
    print('Esse número é primo')

