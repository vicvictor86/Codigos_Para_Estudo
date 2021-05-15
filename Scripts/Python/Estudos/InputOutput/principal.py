try:
    
    with open('Estudos\InputOutput\dados\contatos.csv', encoding='utf-8') as arquivo_contatos:
        for linha in arquivo_contatos:
            print(linha, end='')
except FileNotFoundError:
    print('Arquivo não encontrado')
except PermissionError:
    print('Sem perissão de escrita')