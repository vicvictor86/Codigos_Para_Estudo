maior = 0
homem = 0
mulher = 0
while True:
    idade = int(input('Digite sua idade: '))
    sexo = ' '
    while sexo not in 'mf':
        sexo = str(input('Digite seu sexo[M/F]: ')).strip().lower()[0]
    cont = ' '
    while cont not in 'sn':
        cont = str(input('Você quer continuar[S/N] ? ')).strip().lower()[0]
    if idade > 18:
        maior += 1
    if sexo == 'm':
        homem += 1
    if sexo == 'f' and idade < 20:
        mulher += 1
    if cont == 'n':
        break
print(f'{maior} pessoas registradas são maiores de idade')
print(f'{homem} pessoas registradas são homens')
print(f'{mulher} pessoas registradas são mulheres e tem menos de 20 anos')

