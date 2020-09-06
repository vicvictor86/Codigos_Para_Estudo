from time import sleep
print('-='*10, end='')
print('Bem vindo', end='')
print('-='*10)
n1 = int(input('Digite o primeiro número '))
n2 = int(input('Digite o segundo número '))
escolha = 0
while escolha != 5:
    lista = [n1, n2]
    print('[ 1 ] somar\n[ 2 ] multiplicar\n[ 3 ] maior\n[ 4 ] novos números\n[ 5 ] sair do programa')
    escolha = int(input('Qual sua opção ? '))
    if escolha == 1:
        soma = n1 + n2
        print('A soma de {} + {} = {}'.format(n1, n2, soma))
        print('-='*15)
    elif escolha == 2:
        produto = n1 * n2
        print('A multiplicação entre {} x {} = {}'.format(n1, n2, produto))
        print('-=' * 15)
    elif escolha == 3:
        maior = max(lista)
        print('O maior número entre os dois escolhidos é {}'.format(maior))
        print('-=' * 15)
    elif escolha == 4:
        n1 = int(input('Digite o novo número: '))
        n2 = int(input('Digite o outro novo número: '))
        print('-=' * 15)
    elif escolha == 5:
        print('Saindo do programa...')
        sleep(0.7)
        break
    else:
        print('Opção inválida. Tente novamente.')




