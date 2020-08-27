numero = int(input("Escreva um número: "))
eprimo = True
for c in range(2, numero):
    if(numero % c == 0):
        print("Esse número não é primo")
        eprimo = False
        break
if eprimo == True:
    print("Esse número é primo")

