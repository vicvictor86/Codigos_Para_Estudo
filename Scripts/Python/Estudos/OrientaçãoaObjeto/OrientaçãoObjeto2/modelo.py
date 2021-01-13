from typing import Iterable


class Programa:

    def __init__(self, nome, ano):

        self._nome = nome.title()
        self.ano = ano
        self._like = 0
    
    @property
    def like(self):
        return self._like

    def dar_like(self):
        self._like += 1

    @property
    def nome(self):
        return self._nome
    
    @nome.setter
    def nome(self, novo_nome):
        self._nome = novo_nome.title()

    def __str__(self):
        return f"Nome: {self.nome} - Ano: {self.ano} - Likes: {self.like}"
    

class Filme(Programa):

    def __init__(self, nome, ano, duracao):
        super().__init__(nome, ano)
        self.duracao = duracao

    def __str__(self):
        return f"Nome: {self.nome} - Ano: {self.ano} - Duração: {self.duracao} - Likes: {self.like}"
    
class Serie(Programa):

    def __init__(self, nome, ano, temporadas):

        super().__init__(nome, ano)
        self.temporadas = temporadas

    def __str__(self):
        return f"Nome: {self.nome} - Ano: {self.ano} - Temporadas: {self.temporadas} - Likes: {self.like}"

class PlayList:
    def __init__(self, nome, programas):
        self.nome = nome
        self._programas = programas
    
    def __getitem__(self, item):
        return self._programas[item]

    @property
    def listagem(self):
        return self._programas
    
    def __len__(self):
        return len(self._programas)

vingadores = Filme("vingadores guerra infinita", 2018, 160)
atlanta = Serie("atlanta", 2018, 2)
tmep = Filme("Todo mundo em pânico", 1999, 100)
demolidor = Serie("Demolidor", 2016, 2)

vingadores.dar_like()
tmep.dar_like()
tmep.dar_like()
tmep.dar_like()
demolidor.dar_like()
atlanta.dar_like()
atlanta.dar_like()

filmes_e_series = [vingadores, atlanta, tmep, demolidor]
playlist_fim_de_semana = PlayList("Fim de semana", filmes_e_series)

print(playlist_fim_de_semana.nome)
print(f"Tamanho da playlist: {len(playlist_fim_de_semana)}")
for programas in playlist_fim_de_semana:
    print(programas)
