prim = int(input('Digite o primeiro termo da PA '))
razao = int(input('Digite a razão da PA '))
quant = 1
term = prim
total = 0
termoadd = 10
while termoadd != 0:
    total = total + termoadd
    while quant <= total:
        print('O {}° termo da PA é:'.format(quant), end='')
        term = term + razao
        print('{}'.format(term))
        quant += 1
    termoadd = int(input('Quantos você quer a mais ? '))
print('Progressão aritimetica terminada com {} termos mostrados.'.format(total))
