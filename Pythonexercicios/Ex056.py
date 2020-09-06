idademedia = 0
maioridadehomem = 0
nomevelho = ''
quantmulher = 0
for p in range(1, 5):
    print('-----{}°pessoa----'.format(p))
    nome = str(input('Nome:')).strip().lower().title()
    idade = int(input('Idade:'))
    sexo = str(input('Sexo [M/F]:')).strip().lower()
    idademedia = idademedia + idade
    if p == 1 and sexo == 'm':
        maioridadehomem = idade
        nomevelho = nome
    if sexo == 'm' and idade > maioridadehomem:
        maioridadehomem = idade
        nomevelho = nome
    if sexo == 'f' and idade < 20:
        quantmulher += 1
media = idademedia / 4
print('A idade media do grupo é de {} anos'.format(media))
print('O homem mais velho tem {} anos e seu nome é {}'.format(maioridadehomem, nomevelho))
print('No grupo registrado há {} mulhere(s) com menos de 20 anos.'.format(quantmulher))
