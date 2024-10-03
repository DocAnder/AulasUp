from abc import ABC, abstractmethod

class Pessoa(ABC):
    def __init__(self, nome, renda):
        self.nome = nome
        self.renda = renda

    @abstractmethod
    def calcular(self):
        pass

class PessoaFisica(Pessoa):
    def __init__(self, nome, renda, cpf):
        super().__init__(nome, renda)
        self.cpf = cpf
        self.porcentagem = 0.25
    

class PessoaJuridica(Pessoa):
    def __init__(self, nome, renda, cnpj):
        super().__init__(nome, renda)
        self.cnpj = cnpj
        self.porcentagem = 0.18


if __name__ == "__main__":
    pessoaFisica = PessoaFisica("Gimenes da Mata", 2000, "111.222.333-44")
    print(pessoaFisica.calcular(pessoaFisica.porcentagem))
