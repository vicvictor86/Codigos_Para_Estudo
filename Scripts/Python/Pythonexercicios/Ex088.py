import random
import time
lista = list()
cont = 0
print('-'*30)
print('      Jogue na Mega Sena')
print('-'*30)
quant = int(input('Quantos jogos você quer que eu sorteie ? '))
print(f'-=-=- SORTEANDO {quant} números -=-=-')
for c in range(1, quant + 1):
    lista.append(random.sample(range(1, 61), k=6))
    lista[cont].sort()
    print(f'JOGO {c}: {lista[cont]}')
    cont += 1
    time.sleep(0.8)
print('-=-=-=-=-=-=BOA SORTE-=-=-=-=-=-')
