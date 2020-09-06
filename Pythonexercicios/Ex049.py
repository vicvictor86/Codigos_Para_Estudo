n = 0
numero = int(input('Escolha um número para ver sua tabuada'))
for c in range(0, 11):
    resultado = numero * n
    print('{} * {} = {}'.format(numero, n, resultado))
    n += 1
