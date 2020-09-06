prim = int(input('Digite o primeiro termo da PA '))
razao = int(input('Digite a razão da PA '))
quant = 1
term = prim
while quant < 11:
    print('O {}° termo da PA é:'.format(quant), end='')
    term = term + razao
    print('{}'.format(term))
    quant += 1
