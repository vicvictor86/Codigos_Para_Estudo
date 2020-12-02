from datetime import date
atual = date.today().year
nascimento = int(input('Digite o ano de seu nascimento '))
idadeatual = atual - nascimento
print('O participante tem {} anos'.format(idadeatual))
if idadeatual <= 9:
    print('O participante pertence a categoria mirim')
elif 9 < idadeatual <= 14:
    print('O parcitipante pertence a categoria infantil')
elif 14 < idadeatual <= 19:
    print('O participante pertence a categoria junior')
elif 19 < idadeatual <=25:
    print('O participante pertence a categoria sênior')
else:
    print('O participante pertence a categoria master')

