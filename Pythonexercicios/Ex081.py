num = list()
pos = 0
estar = False
while True:
    n = num.append(int(input('Digite um número')))
    continuar = str(input('Você quer continuar[s/n] ?')).strip().lower()
    if num[pos] == 5:
        estar = True
        pos += 1
    else:
        pos += 1
    if continuar in 'n':
        break
num.sort(reverse=True)
print(f'A quantidade de números digitados foram {len(num)}')
print(f'A lista ordenada de forma decrescente é :{num}')
if estar == True:
    print('O número 5 foi digitado e está na lista')
elif estar == False:
    print('O número 5 n foi digitado e não está na lista')
print('O 5 aparece nas posições')
for i, v in enumerate(num):
    if v == 5:
        print(f'{i}...', end='')
