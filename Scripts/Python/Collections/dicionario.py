dicionario = {
	"Guilherme": 1,
	"cachorro": 2,
	"nome": 2,
	"vindo": 1
}

#Faz print das keys
for elemento in dicionario:
	print(elemento)
for elemento in dicionario.keys():
	print(elemento)

#Faz print dos valores
for elemento in dicionario.values():
	print(elemento)

#faz print das tuplas dos items do dicionário
for elemento in dicionario.items():
	print(elemento)

#Faz print das chaves e valores separadamente
for chave, valor in dicionario.items():
	print(chave, "=", valor)
