import json

# Função para ler o arquivo JSON e imprimir as questões
def ler_quiz(nome_arquivo_json):
    with open(nome_arquivo_json, 'r') as arquivo_json:
        quiz = json.load(arquivo_json)  # Carrega o conteúdo do JSON

    for pergunta in quiz:
        print(f"Categoria: {pergunta.get('categoria', 'Sem título')}")
        print(f"Pergunta: {pergunta['pergunta']}")
        print(f"1. {pergunta['1']}")
        print(f"2. {pergunta['2']}")
        print(f"3. {pergunta['3']}")
        print(f"4. {pergunta['4']}")
        print(f"Resposta Correta: {pergunta['correta']}")
        print(f"Dificuldade: {pergunta['dificuldade']}")
        print()  # Linha em branco para separar as perguntas


# Classe para representar as questões
class Question:
    def __init__(self, categoria, pergunta, opcoes, correta, dificuldade):
        self.categoria = categoria
        self.pergunta = pergunta
        self.opcoes = opcoes  # Uma lista de opções
        self.correta = correta  # O índice da opção correta
        self.dificuldade = dificuldade

#Padrões a serem aplicados 
"""
Singleton
Factory
Strategy
"""



if __name__ == "__main__":    
    ler_quiz('questions.json')

