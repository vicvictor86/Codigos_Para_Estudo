c1 = float(input('Escolha o primeiro cateto'))
c2 = float(input('Escolha o segundo cateto'))
hipotenusa = (c1 ** 2 + c2 ** 2) ** (1/2)
print('Sendo o primeiro cateto {} e o segundo cateto {} o valor da hipotenusa será {:.2f}'.format(c1,c2,hipotenusa))