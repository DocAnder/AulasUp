
//Seleciona o banco de dados que será usado: brasil
use('brasil');


//db = brasil
// db.getCollection('estados').insertMany([
//     { 'nome': 'Paraná', 'sigla': 'PR' },
//   ]);


//A variavel Estados recebe a tabela ESTADOS do banco
let estados = db.getCollection('estados');

// estados.insert(
//   { 'nome': 'Roraima', 'sigla': 'RR' }
// )

// estados.insertMany([
//   { 'nome': 'Ponta Grossa', 'sigla': 'PG', idh: 80},
//   { 'nome': 'Amazonas', 'sigla': 'AM', idh: 81},
//   { 'nome': 'Mato Grosso do Sul', 'sigla': 'MS', idh: 71}
// ]);

//Seleciona o primeiro estado com a sigla RR
let res = estados.findOne(
  {'sigla': 'RR'}
);

//console.log(res.nome);

//Filtra os estados com idh superior a 80
let idhRes = estados.find(
  {"idh": {"$gt": 79} }
)

//Filtra os estados dentro do intervalo: Entre 60 e 79
let idhRes2 = estados.find(
  {"idh": {"$gt": 60, "$lt": 79} }
)

//Imprime o vetor do retorno do idhRes
//idhRes.forEach(element => { console.log(element.nome, element.idh)});

