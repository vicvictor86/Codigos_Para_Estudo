from random import randint
from time import sleep
print('Sou seu computador...')
sleep(0.7)
print('Acabei de pensar em um número entre 0 e 100')
sleep(0.7)
print('Será que vc consegue adivinhar qual foi ? Você tem 10 chances para acertar.')
sleep(0.7)
escolhapc = randint(0, 100)
sleep(0.7)
escolha = int(input('Qual o seu palpite ? '))
quant = 0
chances = 0
while escolha != escolhapc and chances < 11:
    if escolha < escolhapc:
        print('O número que pensei é maior.', end='')
        escolha = int(input('Tente novamente: '))
        quant += 1
        chances += 1
    if escolha > escolhapc:
        print('O número que pensei é menor.', end='')
        escolha = int(input('Tente novamente: '))
        quant += 1
        chances += 1
    if escolha == escolhapc:
        print('Parabéns o número que eu pensei foi {} você acertou após {} tentativas.'.format(escolhapc, quant + 1))
    if chances == 10:
        print('Que pena você gastou todas as suas chances. ;-; O número que eu pensei foi  {}'.format(escolhapc))
        break
