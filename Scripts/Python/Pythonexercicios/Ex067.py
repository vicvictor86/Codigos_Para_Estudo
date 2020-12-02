n = 0
cont = 0
resultado = 0
while n >= 0:
    cont = 0
    n = int(input('Quer ver uma tabuada de que valor ? '))
    while cont <= 10:
        if n < 0:
            print('\033[33mPROGRAMA TABUADA ENCERRADO COM SUCESSO.\033[m')
            break
        else:
            resultado = n * cont
            print(f'{n} * {cont} = {resultado}')
            cont += 1
