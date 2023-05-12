use("geo");

let colMuni = db.getCollection("municipios");

//WHERE BASICO
/*
let municipiosRO = colMuni.aggregate([
    {
        $match:{
        "Uf": "SP"
    }    
 }
])
console.log(municipiosRO.toArray().length);
*/

//WHERE COM 2 FILTROS + SELEÇÃO DAS COLUNAS QUE QUERO (PROJECT = SELECT)
let municipiosRO2 = colMuni.aggregate([
    {
        $match:{
        "Uf": "SP",
        "Id": {$gt: 3500}
    }    
 },
 {  //PROJETC = SELECT
    $project: {"Nome": 1, "Uf": 1}
 }
])
//console.log(municipiosRO2.toArray().length);

municipiosRO2.forEach(d => {
    console.log(`${d.Nome} - ${d.Uf}`);    
});