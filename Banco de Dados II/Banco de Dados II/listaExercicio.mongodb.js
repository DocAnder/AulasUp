
//1) Livros com mais de 1092 (paginas) = 2;
use("db_books");
db.books.find(
    //filtros - condições (gt) - greater than)
    {"pageCount": { $gt:1092 } }, 
    //{"longDescription": 0}, 
    {"title": 1, "pageCount": 1, "_id":0}
)

//2) Listar todas as categorias existentes = 38;
use("db_books");
db.books.distinct( "categories");

//3) Listar os tipos de status = 2;
use("db_books");
db.books.distinct( "status");

//4) Listar os 5 livros com o maior número de páginas;
use("db_books");
db.books.find().sort({ "pageCount": -1 }).limit(5);

//5) Encontrar livros sobre COBOL;
use("db_books");
db.books.find(
    { "longDescription": { $regex: /COBOL/i } }
);

//6) Livros que contém no título a palavra "Development" com data de publicação a partir de 2000:
use("db_books");
db.books.find({
    "title": { $regex: /Development/i },  
    "publishedDate.$date": { "$lte": "2000-01-01T00:00:00Z" }     
});

//7) Livros publicados anteriores a 1995;
use("db_books");
db.books.find({ "publishedDate.$date": { "$lte": "1995-01-01T00:00:00Z" } })

//8) Total de livros publicados no ano 2000
use("db_books");
db.books.find({ 
    "publishedDate.$date": { "$lte": "2001-12-31T00:00:00Z" },
    "publishedDate.$date": { "$gte": "2001-01-01T00:00:00Z" }
}).count();

//9) Qual o livro publicado mais recentemente?
use("db_books");
db.books.find().sort({"publishedDate": -1}).limit(1);

//10) Contém a palavra "Debugger" na descrição
use("db_books");
db.books.find({
    "longDescription": { $regex: /Debugger/i }    
});

//11) Qual o livro com o menor número de páginas?
use("db_books");
db.books.find({ "pageCount": { $gt:0 } }).sort({ "pageCount": 1 }).limit(1);

//12) Qual o livro publicado mais antigo?
//Não funciona pois tem livros sem o campo "data de publicação"
use("db_books");
db.books.find({
    "publishedDate": {$exists: "publishedDate"}
}).sort({"publishedDate": 1}).limit(1);


//13) Livros com 3 ou mais autores
use("db_books");
db.books.find({ $expr: { $gte: [ { $size: "$authors" }, 3 ] } });
db.books.find({ $expr: { $gte: [ { $size: "$authors" }, 3 ] } }).size();

//14) Contem o termo "Java" e foi publicado a partir de 2013.
use("db_books");
db.books.find({
    "longDescription": { $regex: /Java/i },  
    "publishedDate.$date": { "$gte": "2013-01-01T00:00:00Z" }     
});

//15) Livros que contém a categoria "Networking"
use("db_books");
db.books.find({
    "categories": { $regex: /Networking/i }
});

//16) Livros que contém a categoria "Networking" publicados depois do ano 2000:
use("db_books");
db.books.find({
    "categories": { $regex: /Networking/i }, 
    "publishedDate.$date": { "$gt": "2000-01-01T00:00:00Z"}
});

//17) Total de livros na categoria networking?
use("db_books");
db.books.find({
    "categories": { $regex: /Networking/i }
}).count();


//18) Sumarizar o total de livros por categoria
use("db_books");
db.books.find().sort(
    {"categories": -1} 
);

//Codigo internet...
db.livros.aggregate([
    { $unwind: "$categories" },
    {
      $group: {
        _id: "$categories",
        count: { $sum: 1 }
      }
    },
    {
      $project: {
        _id: 0,
        categoria: "$_id",
        total_livros: "$count"
      }
    }
  ]);