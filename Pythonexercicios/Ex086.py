lista = list()
pos1 = 0
pos2 = 0
cord = 0
for n in range(0, 9):
    lista.append(int(input(f'Digite o número [{pos1}],[{pos2}]: ')))
    if pos1 < 2 and pos2 == 2:
        pos1 += 1
    if pos2 <= 2:
        pos2 += 1
    if pos2 == 3:
        pos2 = 0
for c in range(0, 9):
    if c == 3:
        print()
    elif c == 6:
        print()
    print(f'[  {lista[cord]:^5}  ]', end='')
    cord += 1
