import random
lista = []
c = 0
print('=======ESCOLHEDOR DE QUESTÕES======')
quant = int(input('Digite a quantidade de questões que vc quer fazer: '))
quantq = int(input('Digiet quantas questões tem o módulo: '))
while c != quant:
    lista.append(random.randint(1, quantq))
    c += 1
lista.sort()
print(f'Você deve fazer as questões: {lista}')
