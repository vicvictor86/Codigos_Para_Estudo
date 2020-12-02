num = list()
while True:
    n = int(input('Digite um número'))
    if n not in num:
        num.append(n)
        print('Valor adicionado com sucesso!')
    else:
        print('Valor duplicado, não irei adicionar.')
    continuar = str(input('Você quer continuar ?:[s/n] ')).lower().strip()
    if 'n' in continuar:
        break
num.sort()
print(f'Os números únicos digitados foram : {num}.')