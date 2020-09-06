palavras = ('aprender', 'programar', 'linguagem', 'python')
for posição in palavras:
    print(f'\n Na palavra {posição.upper()} temos ', end='')
    for letra in posição:
        if letra.lower() in 'aeiou':
            print(letra, end=' ')