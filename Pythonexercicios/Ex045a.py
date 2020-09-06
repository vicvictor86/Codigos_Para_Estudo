from time import sleep
from random import choice
print('OI AMIGOS DO GITHUB')
escolha = int(input('Suas opções:\n[ 0 ] pedra\n[ 1 ] papel\n[ 2 ] tesoura\nQual a sua jogada ? '))
if escolha == 0:
    jogadap = 'pedra'
elif escolha == 1:
    jogadap = 'papel'
elif escolha == 2:
    jogadap = 'tesoura'
lista = ['pedra', 'papel', 'tesoura']
jogadac = choice(lista)
print('JO')
sleep(0.7)
print('KEN')
sleep(0.7)
print('PÔ')
sleep(0.7)
print('\033[33m-=-'*8)
print('Computador jogou {}'.format(jogadac))
print('Você jogou {}'.format(jogadap))
print('-=-'*8)
print('\033[m')
if escolha == 0: #O jogador escolheu pedra
    if jogadac == 'pedra':
        print('EMPATE')
    elif jogadac == 'papel':
        print('O COMPUTADOR GANHOU')
    elif jogadac == 'tesoura':
        print('PARABÉNS, VOCÊ GANHOU')
if escolha == 1: #O jogador escolheu papel
    if jogadac == 'pedra':
        print('PARABÉNS, VOCÊ GANHOU')
    elif jogadac == 'tesoura':
        print('O COMPUTADOR GANHOU')
    elif jogadac == 'papel':
        print('EMPATE')
if escolha == 2: #O jogador escolheu tesoura
    if jogadac == 'pedra':
        print('O COMPUTADOR GANHOU')
    elif jogadac == 'papel':
        print('PARABÉNS, VOCÊ GANHOU')
    elif jogadac == 'tesoura':
        print('EMPATE')


print("Xau amigos do GitHub")
