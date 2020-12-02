primtermo = int(input('Digite o primeiro termo da PA '))
razao = int(input('Digite qual será a razão dessa PA? '))
print('Os dez primeiros termos de uma PA cujo o primeiro termo é \033[31m{}\033[m são:\n '.format(primtermo))
resultado = primtermo
for c in range(1, 11):
    resultado = resultado + razao
    print('{}'.format(resultado))
