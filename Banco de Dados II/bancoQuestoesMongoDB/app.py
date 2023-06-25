from flask import (
    Flask, render_template, request, redirect, url_for, flash
)
from pymongo import MongoClient
from dotenv import load_dotenv
import os
from bson import ObjectId
load_dotenv()

app = Flask(__name__)
app.config['SECRET_KEY'] = 'asdf0001'

cluster_url = os.getenv("CLUSTER_URL")
cluster = MongoClient(cluster_url)


def get_collection():
    #Nome do Banco
    #db = cluster["db_books"]
    db = cluster["provas"]
    #Nome da colecao
    #col = db["books"]
    col = db["questoes"]
    return col

# ==================================
# ROTAS
# ==================================


@app.route("/")
def index():
    return render_template('index.html')


@app.route("/questoes/index", methods=["GET"])
def questoes_index():
    col = get_collection()
    # res = col.find({"title": "iPhone in Action"})
    res = col.find()
    questoes = list(res)
    return render_template("questoes_list.html", questoes=questoes)


@app.route("/cadastro/questao", methods=["GET"])
def cadastro_questao():    
    return render_template("cadastro_questao.html")

@app.route("/salvar/questao", methods=["POST"])
def salvar_questao():

    inputEnunciado = request.form.get('inputEnunciado')
    inputOpcao1 = request.form.get('inputOpcao1')
    inputOpcao2 = request.form.get('inputOpcao2')
    inputOpcao3 = request.form.get('inputOpcao3')
    inputOpcao4 = request.form.get('inputOpcao4')
    categoria = request.form.get('categoria')
    categoria2 = request.form.get('categoria2')
    grauDificuldade = request.form.get('grauDificuldade')
    
    print(inputEnunciado)
    print(inputOpcao1)
    print(inputOpcao2)
    print(inputOpcao3)
    print(inputOpcao4) 
    print(categoria)

    op1Correta = request.form.get('op1Correta') == 'True'
    op2Correta = request.form.get('op2Correta') == 'True'
    op3Correta = request.form.get('op3Correta') == 'True'
    op4Correta = request.form.get('op4Correta') == 'True' 

    print(op1Correta)
    print(op2Correta)
    print(op3Correta)
    print(op4Correta)


    novaQuestao = {
        "cabecalho": inputEnunciado,
        "alternativas": [ 
            {inputOpcao1: op1Correta},
            {inputOpcao2: op2Correta},
            {inputOpcao3: op3Correta},
            {inputOpcao4: op4Correta},
         ],
         "topico": [
            categoria,
            categoria2
         ],
         "dificuldade": grauDificuldade
    }
    
    col = get_collection()
    col.insert_one(novaQuestao)

    return questoes_index()

@app.route("/editar/questao/<idQuestao>", methods=["GET", "POST"])
def editar_questao(idQuestao): 

    if request.method == "GET":       
    
        print(idQuestao)
        col = get_collection()    
        questao = col.find_one({"_id": ObjectId(idQuestao)})
        
        return render_template("editar_questao.html", questao=questao)
    
    elif request.method == "POST":

        inputEnunciado = request.form.get('inputEnunciado')
        inputOpcao1 = request.form.get('opcao1')
        inputOpcao2 = request.form.get('opcao2')
        inputOpcao3 = request.form.get('opcao3')
        inputOpcao4 = request.form.get('opcao4')
        categoria = request.form.get('categoria1')
        categoria2 = request.form.get('categoria2')
        grauDificuldade = request.form.get('grauDificuldade')

        op1Correta = request.form.get('resposta1') == 'True'
        op2Correta = request.form.get('resposta2') == 'True'
        op3Correta = request.form.get('resposta3') == 'True'
        op4Correta = request.form.get('resposta4') == 'True'

        questaoAtualizada = {
        "cabecalho": inputEnunciado,
        "alternativas": [ 
            {inputOpcao1: op1Correta},
            {inputOpcao2: op2Correta},
            {inputOpcao3: op3Correta},
            {inputOpcao4: op4Correta},
         ],
         "topico": [
            categoria,
            categoria2
         ],
         "dificuldade": grauDificuldade
        }

        col = get_collection()
        col.update_one({"_id": ObjectId(idQuestao)}, {"$set": questaoAtualizada})        


        return questoes_index()

@app.route("/deletar/questao/<idQuestao>", methods=["GET"])
def deletar_questao(idQuestao):
    col = get_collection()
    col.delete_one({"_id": ObjectId(idQuestao)})
    return questoes_index()



if __name__ == "__main__":
    app.run(debug=True)
