n1 = float(input('Digite sua primeira nota '))
n2 = float(input('Digite sua segunda nota '))
media = (n1+n2) / 2
if media < 5.0:
    print('Devido sua média ser {}, você foi reprovado'.format(media))
elif 5.0 <= media < 7:
    print('Devido sua média ser {}, você está de recuperação'.format(media))
elif media >= 7.0:
    print('Devido sua média ser {}, você está aprovado'.format(media))
else:
    print('Não foi possível calcular sua média')
