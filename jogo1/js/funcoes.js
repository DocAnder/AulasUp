var vetor = [];


function criarTabela(){
    let pai = document.getElementsByTagName("div")[0];
    let tabela = document.createElement("table");
    tabela.setAttribute("border", 1);

    let linha = 10;
    let coluna = 10;

    for(let i = 0; i < linha; i++){
        linhaTabela = document.createElement("tr");
        for(let j = 0; j < coluna; j++){
            colunaTabela = document.createElement("td");
            colunaTabela.setAttribute("width", 30);
            colunaTabela.setAttribute("height", 30);
            colunaTabela.setAttribute("id", `${i}-${j}`);
            linhaTabela.appendChild(colunaTabela);
        }
        tabela.appendChild(linhaTabela);
    }
    pai.appendChild(tabela);
}

function comandos(botao){
    switch (botao.id){
        case 0:
            vetor.push("esquerda");
            break;
        case 1:
            vetor.push("direita");
            break;
        case 2:
            vetor.push("acima");
            break;
        case 3:
            vetor.push("abaixo");
            break;
    }
}