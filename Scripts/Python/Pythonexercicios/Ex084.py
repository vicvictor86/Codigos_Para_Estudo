galera = list()
dados = list()
continuar = ''
posição = -1
pesomenor = 0
pesomaior = 0
while True:
    dados.append(str(input('Digite seu nome: ')))
    dados.append(int(input('Digite seu peso: ')))
    galera.append(dados[:])
    posição += 1
    peso = galera[posição][1]
    nome = galera[posição][0]
    dados.clear()
    if posição == 0:
        pesomaior = pesomenor = peso
        nomemaior = nomemenor = nome
    if posição != 0 and peso < pesomenor:
        pesomenor = peso
        nomemenor = nome
    if posição != 0 and peso > pesomaior:
        pesomaior = peso
        nomemaior = nome
    continuar = str(input('Você quer continuar ?[S,N] ')).strip().lower()
    if continuar == 'n':
        break
print(f'Foram cadastradas o total de {len(galera)} pessoas')
print(f'O maior peso foi {pesomaior} de: ', end='')
for p in galera:
    if p[1] == pesomaior:
        print(f'{p[0]}', end='')
print(f'O menor peso foi pesomenor de : ', end='')
for c in galera:
    if p[1] == pesomenor:
        print(f'{p[0]}', end='')

