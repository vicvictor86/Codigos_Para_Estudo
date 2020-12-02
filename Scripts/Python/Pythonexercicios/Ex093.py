dados = dict()
dados['nome'] = str(input('Nome do jogador: '))
dados['gols'] = []

total = 0
valor = 0
valu = 0

partidas = int(input(f'Quantas partidas {dados["nome"]} jogou: '))

for c in range(0, partidas):
    dados['gols'].append(int(input(f'Quantos gols na partida {c}: ')))

    total += dados['gols'][valor]
    dados['total'] = total
    
    valor += 1

print('-='*30)
print(dados)
print('-='*30)

for k, v in dados.items():
    print(f'O campo {k} tem o valor {v}')

print('-='*30)
print(f'O jogador {dados["nome"]} jogou {partidas} partidas.')

for e in range(0, partidas):
    print(f'=> Na partida {e} fez {dados["gols"][valu]}')
    valu += 1

print(f'Foi um total de {total} gols')
