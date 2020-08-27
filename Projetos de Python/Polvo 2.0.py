from time import sleep
from random import choice
n1 = str(input('Escolha o primeiro participante'))
n2 = str(input('Escolha o segundo participante'))
lista = [n1, n2]
escolhido = choice(lista)
print('\033[35mPensando...\033[m')
sleep(4)
print('O participante escolhido foi {} '.format(escolhido))
