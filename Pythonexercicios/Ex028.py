from playsound import playsound
from random import randint
from time import sleep
nome = str(input('Qual o seu nome  ? '))
tentativa = int(input('Tente adivinhar qual número o computador pensou'))
escolha = randint(0, 5)
print('\033[35m PROCESSANDO...\033[m')
sleep(2)
if escolha == tentativa:
    print('Parabéns {} vc acertou!'.format(nome))
else:
    print('OOH vc errou, o número que eu pensei foi {}'.format(escolha))
    playsound('musica.mp3')
