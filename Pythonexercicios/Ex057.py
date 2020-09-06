sexo = str(input('Diga seu sexo:[M/F] ')).strip().upper()
while sexo != 'M' and sexo != 'F':
    sexo = str(input('Dados invalidos por favor informe seu sexo: ')).strip().upper()
print('Sexo {} registrado com sucesso'.format(sexo))
