dias = int(input('Quantos dias vc esta com o carro ?'))
km = float(input('Quantos km rodados ? '))
alugdias = dias * 60
alugkm = km * 0.15
alugtot = alugdias + alugkm
print('O total a pagar é de {:.2f}'.format(alugtot))
