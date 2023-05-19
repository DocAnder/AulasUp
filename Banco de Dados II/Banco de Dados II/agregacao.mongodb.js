use("db_books");
let books = db.getCollection("books");

let res = books.aggregate([    
    {
        $project: {
          "title": 1, "pageCount": 1, "_id": 0
        }
    },
    { $limit: 5},
    { $sort: {"pageCount": 1}}
])
//res.toArray();

res = books.aggregate([
    {
        $match: {
            "pageCount": 504
        }        
    },
    {
        $project : {
            "title": 1, "_id": 0
        }

    }               
])
//res.toArray();

res = books.aggregate([
    {
        $group: {
          _id: "_id",
          media: {
            $avg: "$pageCount"
          }
        }
    }               
])
//res.toArray();

res = books.aggregate([
    {
        $match: {
          categories: "Java"
        }
    },
    {
        $group: {
          _id: "_id",
          books: {
            $sum: 1
          }
        }
    }               
])
//res.toArray();


// 1) Qual livro com:
//  a) Maior quantidade de paginas;
res = books.aggregate([    
    {
        $group: {
            _id: "_id",
            "maxPagina": {$max: "$pageCount"}
        }
    }
])
//res.toArray();

//  b) Menor quantidade de paginas;
res = books.aggregate([
    {
        $match:{
        "pageCount": {$gt: 0}
    }    
 },    
    {
        $group: {
            _id: "_id",
            "minPagina": {$min: "$pageCount"}
        }
    }
])
//res.toArray();

// 2) Total de livros com a categoria Networking e Java;
res = books.aggregate([
    {
        $match:{
        $or:[
            {"categories": "Java"},
            {"categories": "Networking"}
        ]
    }    
 },    
    {
        $group: {
            _id: "_id",
            "Total": {$sum: 1}
        }
    }
])
//res.toArray();

//2.1)Total de Livros com as categorias Internet e XML;
res = books.aggregate([
    {
        $match:{
        $and:[
            {"categories": "Internet"},
            {"categories": "XML"}
        ]
    }    
 },    
    {
        $group: {
            _id: "_id",
            "Total": {$sum: 1}
        }
    }
])
//res.toArray();


// 3) Quantidade media de autores por livro;
res = books.aggregate([
    {
        
      $group: {
        _id: "_id",
        Media: {
            $avg: { $size: "$authors"}
            }
      }      

    }
])
//res.toArray();


// 4) Total de livros publicados por Isidor;
res = books.aggregate([
    {
       $match:{          
           "authors": { $regex: /Isidor/i }
       }          
    },{
        $group: {
            _id: "_id",
            Media: {
                $avg: { $size: "$authors"}
                }
          }
    }
    
])
res.toArray();