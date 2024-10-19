var vet = new Array();
var lin=10;
var col=10;
var largura = 80;
var altura = 80;

function criaTabela() {
    pai=document.getElementsByTagName("div")[0];
    tb=document.createElement("table");
    tb.setAttribute("border",1);
    let lin=10;
    let col=10;
    for(let i=0;i<lin;i++){
        tr=document.createElement("tr");
        for(let j=0;j<col;j++){
            td=document.createElement("td");
            td.setAttribute("width",80);
            td.setAttribute("height",80);
            td.setAttribute("id",(i+","+j));
            tr.appendChild(td);
        }
        if(i==0){
            td=document.createElement("td");
            td.setAttribute("width",80);
            td.setAttribute("valign","top");
            td.setAttribute("id", "comandos");
            td.setAttribute("rowspan",lin);
            tr.appendChild(td);
        }
        tb.appendChild(tr);
    }
    pai.appendChild(tb);
    posicionarElementos();
}

function run(){
    i=0;
    setInterval(move, 1000);
}



function posicionarElementos(){
    robo=document.createElement("img");
    robo.setAttribute("src", "img/coco.png");
    robo.setAttribute("width", largura);
    robo.setAttribute("id", "robo");
    robo.setAttribute("heigth", altura);
    roboCol=Math.floor(Math.random() * ((col-1) - 0 + 1)) + 0;
    roboLin=Math.floor(Math.random() * ((lin-1)/2 - 0 + 1)) + 0;

    casa=document.createElement("img");
    casa.setAttribute("src", "img/vaso.png");
    casa.setAttribute("width", largura);
    casa.setAttribute("heigth", altura);
    casaCol=Math.floor(Math.random() * ((col-1) - 0 + 1)) + 0;
    casaLin=Math.floor(Math.random() * ((lin-1) - (lin -1)/2 + 1) + (lin-1)/2);
    
    posRobo=roboLin+","+roboCol;
    posCasa=casaLin+","+casaCol;

    cel=document.getElementById(posRobo);
    cel.appendChild(robo);
    cel=document.getElementById(posCasa);
    cel.appendChild(casa);
}

function move(){

    var perdeu = false;
    if(i<vet.length){

        
        robo = document.getElementById("robo");

        try {
            cel = robo.parentElement;                     
        } catch (error) {
            perdeu = true;
        } 

        if(perdeu){
            if(confirm("Perdeu amigo!")){
                location.reload();
                clearInterval();
            }
        }

        

        pos = cel.id;
        pos = pos.split(",");
        switch(vet[i]){
            case 0:     
                console.log("botão esquerda")          
                pos[1]--;
                break;
            case 1:
                console.log("botão direita")
                pos[1]++
                break;
            case 2:
                pos[0]--
                break;
            case 3:
                pos[0]++
                break;
        }
        // }        
        
        nova = document.getElementById(pos[0] + "," + pos[1]);        
        cel.removeChild(robo);
        nova.appendChild(robo);
        cel = nova;
        i++;        
    }
}


function comandos(e) {
    id=parseInt(e.id);
    cel = document.getElementById("comandos");
   switch (id){
       case 0:        
           vet.push(0);
           cel.innerHTML+="Esquerda<br>";
           break;
       case 1:
           vet.push(1);
           cel.innerHTML+="Direita<br>";
           break;
       case 2:
           vet.push(2);
           cel.innerHTML+="Acima<br>";
           break;
       case 3:
           vet.push(3);
           cel.innerHTML+="Abaixo<br>";
           break;
   }
}