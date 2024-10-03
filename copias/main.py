from abc import ABC

class Pagamento(ABC):
    def __init__(self, valor):
        self.valor = valor if valor > 0 else 0

    def status(self):
        print(f"valor pagamento : {self.valor:.2f}")

class PagamentoPix(Pagamento):
    
    def __init__(self, valor):
        super().__init__(valor)

class PagamentoCredito(Pagamento):    

    def __init__(self, valor):
        super().__init__(valor)
        self.valor = self.valor * 1.1


if __name__ == "__main__":
    pag = PagamentoPix(200)
    pag.status()
    pagCredito = PagamentoCredito(100)
    pagCredito.status()