peso = float(input('Digite o seu peso(quilo) '))
altura = float(input('Digite sua altura(metros) '))
imc = peso / (altura * altura)
if imc < 18.5:
    print('O seu imc é {:.1f}, logo vc está abaixo do peso'.format(imc))
elif 18.5 <= imc <= 25:
    print('O seu imc é {:.1f},logo vc está no peso ideal'.format(imc))
elif 25 < imc <= 30:
    print('O seu imc é {:.1f},logo vc está em sobrepeso'.format(imc))
elif 30 < imc <= 40:
    print('O seu imc é {:.1f},logo vc está com obesiado'.format(imc))
else:
    print('O seu imc é {:.1f},logo vc está com obesidade mórbida'.format(imc))