from random import choice
print('\033[33m-=-'*20)
print('                  BEM VINDO AO JOKENPÔ')
print('\033[33m-=-'*20)
lista = ['pedra', 'papel', 'tesoura']
comput = choice(lista)
escolha = str(input('Escolha entre pedra, papel e tesoura ')).strip().upper()
if comput == 'pedra' and escolha == 'PEDRA':
    print('\033[mVocê escolheu \033[34mpedra\033[m e o computador escolheu \033[31mpedra\033[m')
    print('Houve um empate')
elif comput == 'pedra' and escolha == 'TESOURA':
    print('\033[mVocê escolheu \033[34mtesoura\033[m e o computador escolheu \033[31mpedra\033[m')
    print('Eu ganhei hehe')
elif comput == 'pedra' and escolha =='PAPEL':
    print('\033[mVocê escolheu \033[34mpapel\033[m e o computador escolheu \033[31mpedra\033[m')
    print('Você ganhou ;-;')
elif comput == 'tesoura' and escolha == 'TESOURA':
    print('\033[mVocê escolheu \033[m34tesoura\033[m e o computador escolheu \033[31mtesoura\033[m')
    print('Houve um empate')
elif comput == 'tesoura' and escolha == 'PEDRA':
    print('\033[mVocê escolheu \033[34mpedra\033[m e o computador escolheu \033[31mtesoura\033[m')
    print('Você ganhou ;-;')
elif comput == 'tesoura' and escolha == 'PAPEL':
    print('\033[mVocê escolheu \033[34mpapel\033[m  e o computador escolheu \033[31mtesoura\033[m')
    print('Você perdeu hehe')
elif comput == 'papel' and escolha == 'PAPEL':
    print('\033[mVocê escolheu \033[34mpapel\033[m e o computador escolheu \033[31mpapel\033[m')
    print('Houve um empate')
elif comput == 'papel' and escolha == 'TESOURA':
    print('\033[mVocê escolheu \033[34mtesoura\033[m e o computador escolheu \033[31mpapel\033[m')
    print('Você ganhou ;-;')
elif comput == 'papel' and escolha == 'PEDRA':
    print('\033[mVocê escolheu \033[34mpedra\033[m e o computador escolheu \033[31mpapel\033[m')
    print('Eu ganhei hehe')


