

use('geo');

let municipios = db.getCollection('municipios');

console.log(municipios.countDocuments());


let res = municipios.findOne();
console.log(res.Nome);


//Imprime o Objeto (todos os atributos)
console.log(JSON.stringify(res, null, 2));

//Criterios de seleção - SELECT
let res2 = municipios.find(
    {'Uf': "RO"}
)

res2.forEach(m => {
    console.log(m.Nome, m.Uf);
});