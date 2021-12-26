#forma lógica
idades = [15, 87, 32, 65, 56, 32, 49, 37]
print("Forma lógica")
for i in range(len(idades)):
	print(i, idades[i])

#com build in
print("Com buld in")
for idade in enumerate(idades):
	print(idade)

#Desempacotando a tupla:
print("Desempacotando a tupla")
for pos, idade in enumerate(idades):
	print(pos, "x", idade)
