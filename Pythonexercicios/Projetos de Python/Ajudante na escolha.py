import random
lista = []
c = 1
while True:
    lista.append(str(input(f'Digite a {c} dúvida: ')))
    continuar = str(input('Há outra dúvida ?[S/N]: ')).strip().lower()
    c += 1
    if continuar == 'n':
        break
escolha = random.choice(lista)
print(f'A escolha feita pelo computador foi : {escolha}')
