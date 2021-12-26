#Forma mais verbosa
idades = [20, 39, 18, 27, 19]
idades_no_ano_que_vem = []
for idade in idades:
	idades_no_ano_que_vem.append(idade+1)
print(idades_no_ano_que_vem)

#Forma simplificada
idades_no_ano_que_vem = [(idade+1) for idade in idades]
print(idades_no_ano_que_vem)

#outra forma, list comprehesions


def proximo_ano(idadearg):
	return idadearg+1


print([proximo_ano(idade) for idade in idades if idade > 21])
