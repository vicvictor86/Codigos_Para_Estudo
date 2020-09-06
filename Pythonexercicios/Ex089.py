alunos = []
medias = list()
cont = 0
pos = 0
cont1 = 1
cont2 = 2
med = 0
while True:
    alunos.append(str(input('Nome: ')))
    alunos.append(float(input('Nota1: ')))
    alunos.append(float(input('Nota2: ')))
    cont += 1
    continuar = str(input('Você quer continuar ? [S/N]')).lower().strip()
    if continuar == 'n':
        break
print('-='*30)
print('No. NOME     MÉDIA')
print('-----------------------')
for n in range(0, cont):
    média = (alunos[cont1] + alunos[cont2]) / 2
    medias.append(média)
    cont1 += 3
    cont2 += 3
for c in range(0, cont):
    print(f'{c}   {alunos[pos]}       {medias[med]}')
    pos += 3
    med += 1
print('-----------------------')
while True:
    notas = int(input('Mostrar notas de qual aluno ?(999 interrompe): '))
    if notas == 999:
        break
    else:
        posição = notas * 3
        posição1 = posição + 1
        posição2 = posição + 2
        print(f'As notas de {alunos[posição]} são {alunos[posição1]} e {alunos[posição2]}')
print('>>>>>>FINALIZANDO<<<<<<')
print('Volte sempre')

