/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package locadora_swing;

import java.util.ArrayList;
import model.DaoNotebook;
import model.Notebook;
import view.NoteBookView1;

/**
 *
 * @author humberto
 */
public class Locadora_Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoNotebook daoNotebook = new DaoNotebook();
        ArrayList<Notebook> notebooks = daoNotebook.buscarTodos();
        for(Notebook v : notebooks){
            System.out.println(v.getModelo()
            + " - " + v.getMarca());
        }
        
        new NoteBookView1().setVisible(true);
    }
    
}
