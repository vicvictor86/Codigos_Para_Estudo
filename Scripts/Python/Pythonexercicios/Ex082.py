
num = list()
pares = list()
impares = list()
pos = 0
while True:
    num.append(int(input('Digite um número: ')))
    continuar = str(input('Você quer continuar[s/n] ?')).lower().strip()
    if 'n' in continuar:
        break
for pos, valor in enumerate(num):
    if valor % 2 == 0:
        pares.append(valor)
for pos, valor in enumerate(num):
    if valor % 2 != 0:
        impares.append(valor)
print(f'Os números que vc digitou foram {num}')
print(f'Os números pares digitados foram {pares}')
print(f'Os números ímpares digitados foram {impares}')

