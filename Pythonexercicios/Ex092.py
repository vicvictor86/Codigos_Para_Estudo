import datetime
dados = dict()
dados['nome'] = str(input('Nome: '))
dados['nascimento'] = int(input('Ano de nascimento: '))
dados['ctps'] = int(input('Carteira de trabalho(0 não tem): '))
atual = datetime.date.today().year
idade = atual - dados['nascimento']
dados['idade'] = idade
# Testar se ctps é igual a zero e dps já executar as ações finais e finalizar o programa
if dados['ctps'] != 0:
    dados['contratação'] = int(input('Ano de contratação: '))
    dados['salário'] = float(input('Salário: R$ '))
    dados['aposentadoria'] = (dados['contratação'] - dados['nascimento']) + 35
print('-='*30)
print(dados)
for k, v in dados.items():
    print(f'{k} tem o valor {v}')
