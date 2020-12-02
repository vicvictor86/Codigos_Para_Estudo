nome = str(input('Qual o seu nome completo?')).strip()
maiusculo = nome.upper()
minusculo = nome.lower()
letras = len(nome) - nome.count(' ')
dividido = nome.split()
nome1 = dividido[0]
letras1 = len(nome1)
print("""Sendo o seu nome {};
O seu nome apenas com letras maiúsculas é {};
O seu nome apenas com letras minúsculas é {};
O seu nome possui {} letras;
O seu primeiro nome possui {} letras.""".format(nome,maiusculo, minusculo, letras, letras1))