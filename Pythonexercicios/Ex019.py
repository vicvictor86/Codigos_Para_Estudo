import random
aluno1 = str(input('Escolha o primeiro aluno'))
aluno2 = str(input('Escolha o segundo aluno'))
aluno3 = str(input('Escolha o terceiro aluno'))
aluno4 = str(input('Escolha o quarto aluno'))
lista = [aluno1, aluno2, aluno3, aluno4]
escolhido = random.choice(lista)
print('O aluno escolhido para apagar o quadro é {} '.format(escolhido))