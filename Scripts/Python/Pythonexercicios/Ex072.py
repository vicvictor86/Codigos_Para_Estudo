numeros = ('zero', 'um', 'dois', 'três', 'quatro',
           'cinco', 'seis', 'sete', 'oito', 'nove', 'dez',
           'onze', 'doze', 'treze', 'quatorze', 'quinze',
           'dezesseis', 'dezessete', 'dezoito', 'dezenove', 'vinte')
escolha = int(input('Digite um número entre 0 e 20 que vc quer por extenso: '))
while escolha not in range(0, len(numeros)):
    escolha = int(input('Tente novamente. Digite um número entre 0 e 20 que vc quer por extenso: '))
for c in range(0, len(numeros)):
    print(numeros[escolha])
    break
