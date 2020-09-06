distancia = int(input('Me informe a distância da sua viagem '))
if distancia <= 200:
    preço = 0.50 * distancia
    print('O preço a pagar pela viagem será de {}'.format(preço))
else:
    preço = 0.45 * distancia
    print('O preço a pagar pela viagem será de {}'.format(preço))
