lista = list()
pares = list()
pos1 = 0
pos2 = 0
cord = 0
maior = 0
for n in range(0, 9):
    lista.append(int(input(f'Digite o número [{pos1}],[{pos2}]: ')))
    if pos1 < 2 and pos2 == 2:
        pos1 += 1
    if pos2 <= 2:
        pos2 += 1
    if pos2 == 3:
        pos2 = 0
print('-=' * 30)
for c in range(0, 9):
    if c == 3:
        print()
    elif c == 6:
        print()
    print(f'[  {lista[cord]:^5}  ]', end='')
    cord += 1
for pos, valor in enumerate(lista):
    if valor % 2 == 0:
        pares.append(valor)
for pos, valor in enumerate(pares):
    if pos == 0:
        somapares = valor
    if pos != 0:
        somapares += valor
print('\n')
print(f'A soma dos números pares é {somapares}')
for pos, valor in enumerate(lista):
    if pos == 2:
        soma3col = valor
    if pos == 5 or pos == 8:
        soma3col += valor
print(f'A soma dos números da 3 coluna é {soma3col}')
for pos, valor in enumerate(lista):
    if pos == 3:
        maior = valor
    elif pos == 4 or pos == 5 and valor > maior:
        maior = valor
print(f'O maior valor da segunda linha é {maior}')

