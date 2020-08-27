risada = str(input("De que forma vc rir ?"))

for c in risada:
    if(c != "a" and c != "e" and c != "i" and c != "o" and c != "u"):
        risada = risada.replace(c, "/")
print(risada)

