use("db_books");
let books = db.getCollection("books");

const Queries = {

    fields: {"title": 1, "publishedDate": 1, "pageCount": 1, _id:0},

    q1: () => {
        let res = books.find(
            {"pageCount": {$gt:1092}},
            Queries.fields
        )
        console.log(JSON.stringify(res.toArray(),null,2));
        console.log("Resultados encontrados: " + res.count());
    },
    q1Agg: () => {
        let res = books.aggregate([
            {
            $match: {
                "pageCount": {$gt:1092}
            }
            },
            {
                $project: {
                  "title": 1, "publishedDate": 1, "pageCount": 1, "_id": 0
                }
            }
        ])
        Queries.printResult(res);    
    },
    q7: () => {
        let res = books.find({
            "publishedDate.$date" : {
                $lt: "1995-01-01"
            }
        }, Queries.fields)
        console.log(JSON.stringify(res.toArray(),null,2));
        console.log("Resultados encontrados: " + res.count());
    },
    q13: () => {        
        let res = books.find(
            { $expr: { $gte: [ { $size: "$authors" }, 3 ] } },
            Queries.fields
        );
        Queries.printResult(res);
    },

    printResult: (res) =>{
        let data = res.toArray();
        console.log(JSON.stringify(data,null,2));
        console.log("Resultados encontrados: " + data.length);        
    },

    run: () => {
        //Queries.q1();
        //Queries.q7();
        //Queries.q13();
        Queries.q1Agg();
    }
}

Queries.run();