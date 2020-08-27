num = int(input('Digite um numero '))
redutor = 0
quant = num
posi = 0

for c in range(0, num*2 - 1):
    if posi < num:
        print(f'{num - redutor}\n' * quant, end='')
        redutor += 1
        posi += 1
        quant -= 1
    if posi == num:
        redutor = 1
        quant = 2

'''print(redutor, posi, quant)'''


