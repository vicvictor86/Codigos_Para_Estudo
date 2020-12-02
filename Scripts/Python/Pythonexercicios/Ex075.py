numeros = (int(input('Digite um número: ')),
           int(input('Digite um número: ')),
           int(input('Digite um número: ')),
           int(input('Digite um número: ')))
print('Você digitou os valores : {}'.format(numeros))
print(f'O número de vezes que apareceu o número 9 foi {numeros.count(9)}')
if 3 in numeros:
    print(f'O número 3 apareceu pela primeira vez na posição {numeros.index(3) + 1}')
else:
    print('O valor 3 não foi digitado.')
print('Os números pares são:', end=' ')
for n in numeros:
    if n % 2 == 0:
        print(n, end=' ')
