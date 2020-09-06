pesos = []
for c in range(1, 6):
    peso = float(input('Digite o seu peso: '))
    pesos.append(peso)
print('O maior peso foi {}Kg'.format(max(pesos)))
print('O menor peso foi {}Kg'.format(min(pesos)))