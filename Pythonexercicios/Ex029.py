velocidade = int(input('Qual a velocidade do carro ?'))
if velocidade > 80:
    print('Vc foi multado por ultrapassar a velocidade máxima')
    print('Sua multa será de R$ {}'.format(7 * ((velocidade - 80))))
else:
    print('Vc está abaixo da velocidade máxima.')
