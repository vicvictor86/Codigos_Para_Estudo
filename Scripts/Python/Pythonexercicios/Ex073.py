times = ('palmeiras', 'flamengo', 'internacional', 'grêmio', 'são paulo', 'atlético', 'atlético-pr', 'cruzeiro', 'botafogo', 'santos', 'bahia', 'fluminense', 'corithians', 'chapecoense', 'ceará', 'vasco', 'sport', 'america', 'ec vitoria', 'parana')
print(f'Os 5 primeiros colados são: {times[0:5]}')
print(f'Os 4 ultimos colados são: {times[16:]}')
print(f'A lista em ordem alfabética é {sorted(times)}')
print('O time da chapecoense está na posição {}'.format(times.index('chapecoense')+1))
