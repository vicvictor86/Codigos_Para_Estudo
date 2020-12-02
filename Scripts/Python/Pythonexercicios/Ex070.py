preçof = 0
maior = 0
n = 0
menor = 0
while True:
    nome = str(input('Digite o nome do produto: ')).strip().lower()
    preço = float(input('Digite o preço do produto: R$ '))
    continuar = ' '
    while continuar not in 'sn':
        continuar = str(input('Quer continuar ?[S/N] ')).strip().lower()
    preçof += + preço
    if preço > 1000:
        maior += 1
    if n == 0:
        menor = preço
        nomemenor = nome
    elif n != 0 and preço < menor:
        menor = preço
        nomemenor = nome
    n += 1
    if continuar == 'n':
        break
print(f'O total gasto foi de {preçof:.2f}.')
print(f'{maior} produtos custam mais de mil reais.')
print(f'O produto mais barato é {nomemenor}.')
