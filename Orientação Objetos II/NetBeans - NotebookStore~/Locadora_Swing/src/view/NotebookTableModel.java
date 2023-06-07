/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Notebook;


public class NotebookTableModel extends AbstractTableModel{
    public static final int COL_CODIGO = 0;
    public static final int COL_MODELO = 1;
    public static final int COL_MARCA = 2;
    public static final int COL_PRECO = 3;
    public static final int COL_COR = 4;
    public static final int COL_GPU = 5;
    
    public ArrayList<Notebook> listaNotebooks;
    
    public NotebookTableModel(ArrayList<Notebook> allNotebooks){
        this.listaNotebooks = allNotebooks;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Notebook notebook = listaNotebooks.get(linha);
        Object conteudo = "";
        if(coluna == COL_CODIGO){conteudo = notebook.getCodigo();}
        if(coluna == COL_MODELO){conteudo = notebook.getModelo();}
        if(coluna == COL_MARCA){conteudo = notebook.getMarca();}
        if(coluna == COL_PRECO){conteudo = notebook.getPreco();}
        if(coluna == COL_COR){conteudo = notebook.getCor();}
        if(coluna == COL_GPU){conteudo = notebook.getGpu();}
        return conteudo;
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public int getRowCount(){
        return listaNotebooks.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_CODIGO){nome = "Código";}
        if(coluna == COL_MODELO){nome = "Modelo";}
        if(coluna == COL_MARCA){nome = "Marca";}
        if(coluna == COL_PRECO){nome = "Preco";}
        if(coluna == COL_COR){nome = "Cor";}
        if(coluna == COL_GPU){nome = "GPU";}
        return nome;
    }    
}
