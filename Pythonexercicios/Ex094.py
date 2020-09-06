dados = dict()
lista = list()
contagem = 0
while True:
    dados['nome'] = str(input('Digite seu nome '))
    dados['sexo'] = str(input('Digite seu sexo '))
    dados['idade'] = int(input('Digite sua idade '))
    lista.append(dados)
    contagem += 1
    continuar = str(input('Você quer continuar ? '))
    if continuar == 'n':
        break
#media = lista[0][2] +
print(f'O número de pessoas cadastradas foram : {contagem}')
print(lista[0][2])
print(lista[1][2])
print(lista[2][2])
