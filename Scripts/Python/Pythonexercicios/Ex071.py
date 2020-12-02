print('Bem vindo ao Banco Do Adobisvaldo :)')
saque = int(input('Digite quanto vc quer sacar:R$ '))
total = saque
céd = 50
cedtotal = 0
while True:
    if total >= céd:
        total = total - céd
        cedtotal += 1
    else:
        if cedtotal > 0:
            print(f'Você vai precisar de {cedtotal} de R${céd}')
        if céd == 50:
            céd = 20
        elif céd == 20:
            céd = 10
        elif céd == 10:
            céd = 1
        cedtotal = 0
        if total == 0:
            break

