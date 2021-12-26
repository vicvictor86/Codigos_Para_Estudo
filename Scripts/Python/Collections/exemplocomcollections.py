from collections import Counter

textostr = """There is something to be said about a truly disastrous meal, a meal forever indelible in your memory because it’s so uniquely bad, it can only be deemed an achievement. The sort of meal where everyone involved was definitely trying to do something; it’s just not entirely clear what.
I’m not talking about a meal that’s poorly cooked, or a server who might be planning your murder — that sort of thing happens in the fat lump of the bell curve of bad. Instead, I’m talking about the long tail stuff — the sort of meals that make you feel as though the fabric of reality is unraveling. The ones that cause you to reassess the fundamentals of capitalism, and whether or not you’re living in a simulation in which someone failed to properly program this particular restaurant. The ones where you just know somebody’s going to lift a metal dome off a tray and reveal a single blue or red pill.
I’m talking about those meals.
At some point, the only way to regard that sort of experience — without going mad — is as some sort of community improv theater. You sit in the audience, shouting suggestions like, “A restaurant!” and “Eating something that resembles food” and “The exchange of money for goods, and in this instance the goods are a goddamn meal!” All of these suggestion go completely ignored.
That is how I’ve come to regard our dinner at Bros, Lecce’s only Michelin-starred restaurant, as a means of preserving what’s left of my sanity. It wasn’t dinner. It was just dinner theater.
No, scratch that. Because dinner was not involved. I mean — dinner played a role, the same way Godot played a role in Beckett’s eponymous play. The entire evening was about it, and guess what? IT NEVER SHOWED."""


def analisa_frequencia_de_letras(texto):
	aparicoes = Counter(texto.lower())
	total_de_caracteres = sum(aparicoes.values())
	proporcoes = [(letra, frequencia / total_de_caracteres) for letra, frequencia in aparicoes.items()]
	proporcoes = Counter(dict(proporcoes))
	mais_comuns = proporcoes.most_common(10)
	for caractere, proporcao in mais_comuns:
		print("{} => {:.2f}%".format(caractere, proporcao * 100))


analisa_frequencia_de_letras(textostr)