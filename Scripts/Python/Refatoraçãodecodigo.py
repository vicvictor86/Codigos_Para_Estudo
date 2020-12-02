from random import randint

print("******************************")
print("*    Jogo da adivinhação     *")
print("******************************")
print("\n\nTente acertar qual é o número secreto aleatório! O número está entre 0 e 50!\n\n")

numero_aleatorio = randint(0, 51)
nivel_de_dificuldade = 0
acertou = False

while (True):
    try:
        nivel_de_dificuldade = int(input("""Nível 1 --> 7 tentativas
        Nível 2 --> 5 tentativas
        Nível 3 --> 2 tentativa
        Informe o nível de dificuldade: """))

        if (nivel_de_dificuldade == 1):
            total_de_tentativas = 7
            break

        elif (nivel_de_dificuldade == 2):
            total_de_tentativas = 5
            break

        elif (nivel_de_dificuldade == 3):
            total_de_tentativas = 2
            break

        else:
            print("\n\nSelecione uma opção válida!\n\n")
    except ValueError:
        print("\nDigite apenas números\n")
   

for rodada in range(1, total_de_tentativas + 1):
    print("Tentativa {} de {}\n".format(rodada, total_de_tentativas))

    chute_usuario = int(input("Digite um número: "))
    if(numero_aleatorio - 8 < 0):
        dica1_numero_secreto = 0
    else:
        dica1_numero_secreto = numero_aleatorio - 8
    dica2_numero_secreto = numero_aleatorio + 8
    acertou = chute_usuario == numero_aleatorio
    maior = chute_usuario > numero_aleatorio 

    if (acertou):
        print("\nParabéns, você acertou!")
        break

    elif (maior):
        print("\nO número {} é maior que o número secreto!\n".format(chute_usuario))

    else:
        print("\nO número {} é menor que o número secreto!\n".format(chute_usuario))

    if (nivel_de_dificuldade == 1):
        if (rodada == 3):
            print("O número secreto está entre {} e {}!".format(dica1_numero_secreto, dica2_numero_secreto))
    
    elif (nivel_de_dificuldade == 2):
        if (rodada == 2):
            print("O número secreto está entre {} e {}!".format(dica1_numero_secreto, dica2_numero_secreto))

    elif (nivel_de_dificuldade == 3):
        if (rodada == 1):
            print("O número secreto está entre {} e {}!".format(dica1_numero_secreto, dica2_numero_secreto))

if (acertou == False):
    print("Você perdeu")

print(f"O número secreto é {numero_aleatorio}")
print("\n\n***Fim de jogo!***")
print(" ")