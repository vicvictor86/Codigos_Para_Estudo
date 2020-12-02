num = int(input('Digite um número inteiro'))
print('''Escolha uma das bases para conversão:
[ 1 ] converter para Binário
[ 2 ] converter para Octal
[ 3 ] converter para Hexadecimal''')
opção = int(input('Sua opção: '))
if opção == 1:
    print('{} convertido para binário é {}'.format(num, bin(num)[2:]))
elif opção == 2:
    print('{} convertdo para binário é {}'.format(num, oct(num)[2:]))
elif opção == 3:
    print('{} convertido para Hexadecimal é {}'.format(num, hex(num)[2:]))
else:
    print('A sua opção escolhida não equivale a nenhuma conversão.')