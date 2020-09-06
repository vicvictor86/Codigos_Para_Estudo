num = [[], []]
valor = 0
posição = 0
for n in range(0, 7):
    valor = int(input(f'Digite o {posição + 1 } número: '))
    posição += 1
    if valor % 2 == 0:
        num[0].append(valor)
    else:
        num[1].append(valor)
num[0].sort()
num[1].sort()
print(f'Os valores pares são: {num[0]} enquanto os ímpares são: {num[1]}.')
