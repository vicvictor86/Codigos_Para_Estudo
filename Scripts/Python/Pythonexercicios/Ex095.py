jogador = dict()
jogador["dados"] = dict()
jogador["dados"]['gols'] = []
jogador["dados"]['gols']['posicao'] = 0

total_gols = 0
posicao = 0
valu = 0
continuar = ''

while(continuar != 'n'):

    jogador["dados"]['nome'] = str(input('Nome do jogador: '))
    partidas = int(input(f'Quantas partidas {jogador["dados"]["nome"]} jogou: '))

    for c in range(0, partidas):
        jogador["dados"]['gols'].append(int(input(f'    Quantos gols na partida {c + 1}: ')))

        total_gols += jogador["dados"]['gols']['posicao']
        jogador["dados"]['total_gols'] = total_gols
        jogador["dados"]['gols']['posicao'] += 1
        
        

    continuar = str(input('Quer continuar ?[S/N] '))

print("-=" * 20)

print("cod   nome   gols   total")
for k,v in jogador.items():
    print(f"{k} e {v}")

""" for k, v in dados.items():
    print(f'O campo {k} tem o valor {v}')  """

""" print('-='*30)
print(f'O jogador {dados["nome"]} jogou {partidas} partidas.')

for e in range(0, partidas):
    print(f'=> Na partida {e} fez {dados["gols"][valu]}')
    valu += 1

print(f'Foi um total de {total_gols} gols') """
