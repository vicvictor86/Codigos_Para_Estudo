import forca
import adivinhacao

def escolhe_jogo():
    print("********************************")
    print("**Bem Vindo a escolha de jogos**")
    print("********************************")

    jogo = int(input("Escolha seu jogo (1) Forca (2) Adivinhação: "))

    if(jogo == 1):
        print("Jogando forca")
        forca.jogar()
    elif(jogo == 2):
        print("Jogando adivinhação")
        adivinhacao.jogar()

if(__name__ == "__main__"):
    escolhe_jogo()
