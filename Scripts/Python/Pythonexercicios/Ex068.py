from random import randint
print('Olá, eu sou o computador, convido-lhe vossa senhoria para uma disputa de par ou ímpar')
ganhar = True
cont = 0
while ganhar == True:
    parimpar = str(input('Digite qual vc quer[par ou ímpar(coloque o acento)] ')).strip().lower()
    escolhau = int(input('Digite qual número vc vai escolher[De 0 a 10]: '))
    escolhapc = randint(0, 10)
    resultado = escolhau + escolhapc
    if parimpar == 'ímpar' and resultado % 2 == 0:
        print(f'Você escolheu o número {escolhau} e pediu ímpar, eu escolhi {escolhapc}, a soma deu {resultado}')
        print('Você perdeu :v')
        ganhar = False
    elif parimpar == 'par' and resultado % 2 != 0:
        print(f'Você escolheu o número {escolhau} e pediu par, eu escolhi {escolhapc}, a soma deu {resultado}')
        print('Você perdeu :v')
        ganhar = False
    elif parimpar == 'ímpar' and resultado % 2 != 0:
        print(f'Você escolheu o número {escolhau} e pediu ímpar, eu escolhi {escolhapc}, a soma deu {resultado}')
        print('Você ganhou, vamos mais uma ;-;')
        ganhar = True
        cont += 1
    elif parimpar == 'par' and resultado % 2 == 0:
        print(f'Você escolheu o número {escolhau} e pediu par, eu escolhi {escolhapc}, a soma deu {resultado}')
        print('Você ganhou, vamos mais uma ;-;')
        ganhar = True
        cont += 1
print(f'Você ganhou {cont} vezes de mim, parabéns você é um gênio')
print('\033[33mFIM DO JOGO')