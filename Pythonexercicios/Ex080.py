num = list()
maior = 0
menor = 0
for c in range(0, 5):
    n = int(input('Digite um número'))
    if c == 0:
        maior = menor = n
    else:
        if n > maior:
            maior = n
        if n < menor:
            menor = n
    if n == maior:
        num.append(n)
        print('Número adicionado no final da lista.')
    if n == menor and c != 0:
        num.insert(0, n)
        print('Número adicionado na posição 0 da lista.')
    if menor < n < maior and c == 2:
        num.insert(1, n)
        print('Número adicionado na posição 1 da lista.')
    if menor < n < maior and n > num[1] and c != 4:
        num.insert(2, n)
        print('Número adicionado na posição 2 da lista.')
    if menor < n < maior and n < num[1]:
        num.insert(1, n)
        print('Número adicionado na posição 1 da lista')
    if menor < n < maior and num[1] < n < num[3]:
        num.insert(2, n)
        print('Número adicionado na posição 2 da lista')
    if menor < n < maior and n > num[3]:
        num.insert(3, n)
        print('Número adicionado na posição 3 da lista')
print(num)