n = int(input('Digite um número e mostrarei seu fatorial: '))
mult = n - 1
print('Calculando fatorial de {}!:'.format(n), end='')
print('{} x '.format(n), end='')
while mult != 1:
    print('{} x '.format(mult), end='')
    n = n * mult
    mult = mult - 1
print('1', end='')
print(' = {}'.format(n))