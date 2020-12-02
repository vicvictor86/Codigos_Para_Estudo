num = []
mai = 0
men = 0
for cont in range(0, 5):
    num.append(int(input('Digite um número: ')))
    if cont == 0:
        mai = men = num[cont]
    else:
        if num[cont] > mai:
            mai = num[cont]
        if num[cont] < men:
            men = num[cont]
print(f'Você digitou os valores {num}')
print(f'O maior número foi {mai} e o menor, {men}')
print(f'O maior número está nas posições: ', end='')
for i, v in enumerate(num):
    if v == mai:
        print(f'{i}..', end='')
print()
print(f'O menor número está nas posições: ', end='')
for i, v in enumerate(num):
    if v == men:
        print(f'{i}..', end='')
