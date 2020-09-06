n = 0
cont = 0
soma = 0
while n != 999:
        n = int(input('Digite um número[Digite 999 para parar]: '))
        if n != 999:
            soma = soma + n
            cont = cont + 1
print(f'Você digitou {cont} números e a soma entre eles é {soma}')