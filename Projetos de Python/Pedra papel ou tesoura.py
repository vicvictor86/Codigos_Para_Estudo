###############
import random
jogo = ['papel', 'pedra', 'tesoura', 'agulha']
x = random.choice(jogo)
pc = 0
eu = 0
print('**Papel, Pedra, Tesoura ou Agulha**')
jogada = input("Qual sua jogada? ")
if 'papel' in jogada and 'papel' in x or 'pedra' in jogada and 'pedra' in x or\
        'tesoura' in jogada and 'tesoura' in x or 'agulha' in jogada and 'agulha' in x:
    print('{}!'.format(x))
    y = 0
elif 'papel' in jogada and 'pedra' in x:
    print('{}!'.format(x))
    y = 1
elif 'papel' in jogada and 'tesoura' in x:
    print('{}!'.format(x))
    y = 2
elif 'papel' in jogada and 'agulha' in x:
    print('{}!'.format(x))
    y = 2
elif 'pedra' in jogada and 'papel' in x:
    print('{}!'.format(x))
    y = 2
elif 'pedra' in jogada and 'tesoura' in x:
    print('{}!'.format(x))
    y = 1
elif 'pedra' in jogada and 'agulha' in x:
    print('{}!'.format(x))
    y = 1
elif 'tesoura' in jogada and 'papel' in x:
    print('{}!'.format(x))
    y = 1
elif 'tesoura' in jogada and 'pedra' in x:
    print('{}!'.format(x))
    y = 2
elif 'tesoura' in jogada and 'agulha' in x:
    print('{}!'.format(x))
    y = 0
elif 'agulha' in jogada and 'papel' in x:
    print('{}!'.format(x))
    y = 1
elif 'agulha' in jogada and 'tesoura' in x:
    print('{}!'.format(x))
    y = 0
elif 'agulha' in jogada and 'pedra' in x:
    print('{}!'.format(x))
    y = 2
if y == 1:
    eu = eu + 1
    print('\033[1;30mEU {}\033[m'.format(eu))
    print('\033[1;30mPC {}\033[m'.format(pc))
if y == 0:
    print('\033[1;30mEU {}\033[m'.format(eu))
    print('\033[1;30mPC {}\033[m'.format(pc))
if y == 2:
    pc = pc + 1
    print('\033[1;30mEU {}\033[m'.format(eu))
    print('\033[1;30mPC {}\033[m'.format(pc))
jogada2 = input('Próxima jogada: ')
x2 = random.choice(jogo)
if 'papel' in jogada2 and 'papel' in x2 or 'pedra' in jogada2 and 'pedra' in x2 or\
            'tesoura' in jogada2 and 'tesoura' in x2 or 'agulha' in jogada2 and 'agulha' in x2:
        print('{}!'.format(x2))
        z = 0
elif 'papel' in jogada2 and 'pedra' in x2:
        print('{}!'.format(x2))
        z = 1
elif 'papel' in jogada2 and 'tesoura' in x2:
        print('{}!'.format(x2))
        z = 2
elif 'papel' in jogada2 and 'agulha' in x2:
        print('{}!'.format(x2))
        z = 2
elif 'pedra' in jogada2 and 'papel' in x2:
        print('{}!'.format(x2))
        z = 2
elif 'pedra' in jogada2 and 'tesoura' in x2:
        print('{}!'.format(x2))
        z = 1
elif 'pedra' in jogada2 and 'agulha' in x2:
        print('{}!'.format(x2))
        z = 1
elif 'tesoura' in jogada2 and 'papel' in x2:
        print('{}!'.format(x2))
        z = 1
elif 'tesoura' in jogada2 and 'pedra' in x2:
        print('{}!'.format(x2))
        z = 2
elif 'tesoura' in jogada2 and 'agulha' in x2:
        print('{}!'.format(x2))
        z = 0
elif 'agulha' in jogada2 and 'papel' in x2:
        print('{}!'.format(x2))
        z = 1
elif 'agulha' in jogada2 and 'tesoura' in x2:
        print('{}!'.format(x2))
        z = 0
elif 'agulha' in jogada2 and 'pedra' in x2:
        print('{}!'.format(x2))
        z = 2
if z == 1:
        eu = eu + 1
        print('\033[1;30mEU {}\033[m'.format(eu))
        print('\033[1;30mPC {}\033[m'.format(pc))
if z == 0:
        print('\033[1;30mEU {}\033[m'.format(eu))
        print('\033[1;30mPC {}\033[m'.format(pc))
if z == 2:
        pc = pc + 1
        print('\033[1;30mEU {}\033[m'.format(eu))
        print('\033[1;30mPC {}\033[m'.format(pc))

jogada3 = input('A última: ')
x3 = random.choice(jogo)
if 'papel' in jogada3 and 'papel' in x3 or 'pedra' in jogada3 and 'pedra' in x3 or\
            'tesoura' in jogada3 and 'tesoura' in x3 or 'agulha' in jogada3 and 'agulha' in x3:
            print('{}!'.format(x3))
            y = 0
elif 'papel' in jogada3 and 'pedra' in x3:
            print('{}!'.format(x3))
            y = 1
elif 'papel' in jogada3 and 'tesoura' in x3:
            print('{}!'.format(x3))
            y = 2
elif 'papel' in jogada3 and 'agulha' in x3:
            print('{}!'.format(x3))
            y = 2
elif 'pedra' in jogada3 and 'papel' in x3:
            print('{}!'.format(x3))
            y = 2
elif 'pedra' in jogada3 and 'tesoura' in x3:
            print('{}!'.format(x3))
            y = 1
elif 'pedra' in jogada3 and 'agulha' in x3:
            print('{}!'.format(x3))
            y = 1
elif 'tesoura' in jogada3 and 'papel' in x3:
            print('{}!'.format(x2))
            y = 1
elif 'tesoura' in jogada3 and 'pedra' in x3:
            print('{}!'.format(x3))
            y = 2
elif 'tesoura' in jogada3 and 'agulha' in x3:
            print('{}!'.format(x3))
            y = 0
elif 'agulha' in jogada3 and 'papel' in x3:
            print('{}!'.format(x3))
            y = 1
elif 'agulha' in jogada3 and 'tesoura' in x3:
            print('{}!'.format(x3))
            y = 0
elif 'agulha' in jogada3 and 'pedra' in x3:
            print('{}!'.format(x3))
            y = 2
if y == 1:
            eu = eu + 1
            print('\033[1;30mEU {}\033[m'.format(eu))
            print('\033[1;30mPC {}\033[m'.format(pc))
if y == 0:
            print('\033[1;30mEU {}\033[m'.format(eu))
            print('\033[1;30mPC {}\033[m'.format(pc))
if y == 2:
            pc = pc + 1
            print('\033[1;30mEU {}\033[m'.format(eu))
            print('\033[1;30mPC {}\033[m'.format(pc))
if eu > pc:
                print('\033[1;31;40m***GANHOU! MESTRE***\033[')
elif eu == pc:
                print('\033[1;31;40m***EMPATOU! :)***\033[')
else:
                print('vc perdeu')