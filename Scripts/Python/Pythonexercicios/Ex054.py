n = 0
from datetime import date
atual = date.today().year
for c in range(1, 8):
    anonascimento = int(input('Em que ano a {} pessoa nasceu ? '.format(c)))
    idade = atual - anonascimento
    if idade >= 21:
        n += 1
print('Das 7 pessoas registradas apenas {} são de maior'.format(n))
print('Das 7 pessoas registradas apenas {} são de menores'.format(7 - n))