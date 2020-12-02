n1 = int(input('Me der o valor do primero lado '))
n2 = int(input('me der o valor do segundo lado '))
n3 = int(input('Me der o valor do terceiro lado '))
if abs(n2 - n3) < n1 < n2 + n3 and abs(n1 - n3) < n2 < n1 + n3 and abs(n1 - n2) < n3 < n1 + n2:
    print('Com os valores informados é possível fazer um triângulo')
else:
    print('Com os valores informados é impossível fazer um triângulo')
