frase = str(input('Escreva uma frase e irei verificar se ela é um palíndromo ')).lower().strip()
frase2 = frase
frase = frase.replace(' ', '')
if frase == frase[::-1]:
    print('A frase {} é um palíndromo'.format(frase2))
else:
    print('A frase {} não é um palíndromo'.format(frase2))
