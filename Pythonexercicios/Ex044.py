preco = int(input('Digite o valor do produto '))
print('pagamentos:\033[34m \nEm dinheiro\nNo cartão\nDuas vezes no cartão\n3x ou mais no cartão\033[m')
pagamento = str(input('Digite qual será sua forma de pagamento')).strip().upper()
if pagamento == 'EM DINHEIRO':
    preco = preco - (preco * 0.1)
    print('Pagando a vista com dinheiro você ganha 10% de desconto, agora o preço do produto será {}'.format(preco))
elif pagamento == 'NO CARTÃO':
    preco = preco - (preco * 0.05)
    print('Pagando a vista com cartão você ganha 5% de desconto, agora o preço do produto será {}'.format(preco))
elif pagamento == 'DUAS VEZES NO CARTÃO':
    parcela = preco / 2
    print('Você parcelou em 2x no cartão e sem juros.Suas parcelas serão de R${}'.format(parcela))
elif pagamento == '3 VEZES OU MAIS NO CARTÃO':
    quantparce = int(input('Você irá divir em quantas parecelas ? '))
    total = preco + (preco * 0.2)
    parcela = total / quantparce
    print('Você parcelou em {} no cartão com 20% de juros. Suas parcelas serão de R${:.2f}'.format(quantparce, parcela))
    print('Sua compra de R${} irá passar a custar R${}'.format(preco, total))
else:
    print('\033[31mOPÇÃO INVALIDA DE DE PAGAMENTO\033[M')
