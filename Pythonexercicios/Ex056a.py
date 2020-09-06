maior = 0
somaidade = 0
nomevelho = ''
quantmulher = 0
for c in range(1, 5):
    print('-----{}° pessoa-----'.format(c))
    nome = str(input('Nome: ')).strip().lower().title()
    idade = int(input('Idade: '))
    sexo = str(input('Sexo [M/F]')).strip().lower()
    somaidade += idade
    if c == 1 and sexo == 'm':
        maior = idade
        nomevelho = nome
    if sexo == 'm' and idade > maior:
        maior = idade
        nomevelho = nome
    if sexo =='f' and idade < 20:
        quantmulher == quantmulher + 1
media = somaidade / 4
print('A idade média entre as 4 pessoas é {}'.format(media))
print('O homem mais velho do grupo se chama {} e ele tem {} anos'.format(nomevelho, maior))
print('Ao todo são {} mulheres com idade menor que 20 anos'.format(quantmulher))
