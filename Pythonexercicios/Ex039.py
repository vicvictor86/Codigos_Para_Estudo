from datetime import date
atual = date.today().year
nascimento = int(input('Informe em que ano vc nasceu '))
idadeatual = atual - nascimento
if idadeatual < 18:
    print('Você ainda não possui a idade necessária para se alistar no exército')
    print('Ainda faltam {} anos para atingir a maior idade'.format(18 - idadeatual))
elif idadeatual > 18:
    print('Você já ultrapassou a idade necessária para se alistar no exército')
    print('Já se passou {} anos desde que você atingiu a maior idade'.format(idadeatual - 18))
else:
    print('Você possuiu a idade necessária para se alistar no exército')
