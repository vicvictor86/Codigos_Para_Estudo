from random import randint
print('Olá, eu sou o computador, convido-lhe vossa senhoria para uma disputa de par ou ímpar')
countpc = 0
countu = 0
while countpc != 2 or countu != 2:
    parimpar = str(input('Digite qual vc quer[par ou ímpar(coloque o acento)] ')).strip().lower()
    escolhau = int(input('Digite qual número vc vai escolher[De 0 a 10]: '))
    escolhapc = randint(0, 10)
    resultado = escolhau + escolhapc
    if parimpar == 'ímpar' and resultado % 2 == 0:
        print(f'Você escolheu o número {escolhau} e pediu ímpar, eu escolhi {escolhapc}, a soma deu {resultado}')
        countpc += 1
        print(f'Você perdeu, eu estou com {countpc} pontos e vc com {countu} pontos.:v')
    elif parimpar == 'par' and resultado % 2 != 0:
        print(f'Você escolheu o número {escolhau} e pediu par, eu escolhi {escolhapc}, a soma deu {resultado}')
        countpc += 1
        print(f'Você perdeu :v, eu estou com {countpc} pontos e vc com {countu} pontos.')
    elif parimpar == 'ímpar' and resultado % 2 != 0:
        print(f'Você escolheu o número {escolhau} e pediu ímpar, eu escolhi {escolhapc}, a soma deu {resultado}')
        countu += 1
        print(f'Você ganhou, eu estou com {countpc} pontos e vc com {countu} pontos.')
    elif parimpar == 'par' and resultado % 2 == 0:
        print(f'Você escolheu o número {escolhau} e pediu par, eu escolhi {escolhapc}, a soma deu {resultado}')
        countu += 1
        print(f'Você ganhou, eu estou com {countpc} pontos e vc com {countu} pontos.')
if countu == 2:
    print('Parabéns usuário vc ganhou.')
elif countpc == 2:
    print('Eu ganhei haha, mais proxima da sorte vez.')
print('\033[33mFIM DO JOGO')