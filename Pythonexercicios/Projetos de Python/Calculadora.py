print('\033[33m-=-'*20)
print('                  Bem Vindo a calculadora')
print('\033[33m-=-\033[m'*20)
print('\033[34mDigite dois números e após isso escolha qual operação deseja realizar com eles \033[m')
numero = int(input('Digite o primeiro número: '))
numero2 = int(input('Digite o segundo número: '))
print('Digite 1 para executar uma ação de soma \nDigite 2 para executar uma ação de subtração')
print('Digite 3 para executar uma ação de divisão\nDigite 4 para executar uma ação de multiplicação')
escolha = int(input('Escolha a operação'))
if escolha == 1:
    resultado = numero + numero2
    print('Vc esclheu a operação soma o resultado entre {} + {} é {} '.format(numero, numero2, resultado))
elif escolha == 2:
    resultado = numero - numero2
    print('Vc escolheu a operação subtração o resultando entre {} - {} é {}'.format(numero, numero2, resultado))
elif escolha == 3:
    resultado = numero / numero2
    print('Vc escolheu a operação divisão o resultado entre {} / {} é {}'.format(numero, numero2, resultado))
elif escolha == 4:
    resultado = numero * numero2
    print('Vc escolheu a operação multiplicação o resultado entre {} * {} é {}'.format(numero, numero2, resultado))
else:
    print('O número que vc escolheu não corresponde a nenhuma operação')