/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import javax.swing.JOptionPane;
import model.DaoNotebook;
import model.Notebook;


public class NoteBookView1 extends javax.swing.JFrame {
    Notebook notebook;
    DaoNotebook daoNotebook;
    /**
     * Creates new form NoteBookView1
     */
    public NoteBookView1() {
        initComponents();
        daoNotebook = new DaoNotebook();
        this.atualizarTabela();
    }

    public void atualizarTabela(){
        jtNotebooks.setModel(new NotebookTableModel(daoNotebook.buscarTodos()));
    }
    
    public void limparCampos(){
        tfCodigo.setText("");
        tfModelo.setText("");
        tfMarca.setText("");        
        tfPreco.setText("");
        tfCor.setText("");
        bgGpu.clearSelection();        
        btExcluir.setEnabled(false);        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltro = new javax.swing.ButtonGroup();
        bgGpu = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNotebooks = new javax.swing.JTable();
        tfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfModelo = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        tfCor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rbMarca = new javax.swing.JRadioButton();
        rbModelo = new javax.swing.JRadioButton();
        tfFiltro = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rbSim = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Marca:");
        jLabel1.setName(""); // NOI18N

        tfMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMarcaActionPerformed(evt);
            }
        });

        jtNotebooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtNotebooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtNotebooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtNotebooks);

        tfCodigo.setEditable(false);
        tfCodigo.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setText("Código:");

        jLabel3.setText("Modelo:");

        tfPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPrecoFocusLost(evt);
            }
        });
        tfPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoActionPerformed(evt);
            }
        });

        jLabel4.setText("Preco:");

        jLabel5.setText("Cor:");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtrar por:");

        bgFiltro.add(rbMarca);
        rbMarca.setText("Marca");
        rbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMarcaActionPerformed(evt);
            }
        });

        bgFiltro.add(rbModelo);
        rbModelo.setText("Modelo");
        rbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbModeloActionPerformed(evt);
            }
        });

        tfFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFiltroActionPerformed(evt);
            }
        });

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        btListar.setText("Listar todos");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        jLabel7.setText("GPU:");

        bgGpu.add(rbSim);
        rbSim.setText("Sim");
        rbSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSimActionPerformed(evt);
            }
        });

        bgGpu.add(rbNao);
        rbNao.setText("Não");
        rbNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNaoActionPerformed(evt);
            }
        });
        rbNao.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rbNaoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(tfMarca, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfCor, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(tfModelo)))
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbModelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFiltro)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btFiltrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btListar)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbSim)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbNao)
                                        .addGap(105, 105, 105)
                                        .addComponent(btNovo)
                                        .addGap(14, 14, 14)
                                        .addComponent(btSalvar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btExcluir))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar)
                        .addComponent(btNovo)
                        .addComponent(btExcluir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(rbSim)
                        .addComponent(rbNao)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbMarca)
                    .addComponent(rbModelo)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFiltrar)
                    .addComponent(btListar))
                .addGap(111, 111, 111))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMarcaActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if(tfMarca.getText().trim().equals("") || tfModelo.getText().trim().equals("")
                || tfPreco.getText().trim().equals("") || tfCor.getText().trim().equals("") || (!rbSim.isSelected() && !rbNao.isSelected())){
            
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e selecione Sim ou Não para a GPU",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }else{
        
            notebook = new Notebook();
            notebook.setMarca(tfMarca.getText());
            notebook.setModelo(tfModelo.getText());
            notebook.setPreco(Double.parseDouble(tfPreco.getText()));
            notebook.setCor(tfCor.getText());
            Boolean gpu = false;
            if(rbSim.isSelected()){
                gpu = true;
            }
            notebook.setGpu(gpu);
            if(rbSim.isSelected()){
                System.out.println("imprimiu o SIM selecionado");
            }
            if(tfCodigo.getText().equals("")){
                daoNotebook.inserir(notebook);
            }else{
                
                notebook.setCodigo(Integer.parseInt(tfCodigo.getText()));
                
                System.out.println(notebook.getGpu());
                
                daoNotebook.alterar(notebook);
            }
            this.atualizarTabela();
            this.limparCampos();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jtNotebooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNotebooksMouseClicked
        tfCodigo.setText(
                jtNotebooks.getValueAt(jtNotebooks.getSelectedRow(), 
                        NotebookTableModel.COL_CODIGO).toString()
        );
        tfMarca.setText(
                jtNotebooks.getValueAt(jtNotebooks.getSelectedRow(), 
                        NotebookTableModel.COL_MARCA).toString()
        );
        tfModelo.setText(
                jtNotebooks.getValueAt(jtNotebooks.getSelectedRow(), 
                        NotebookTableModel.COL_MODELO).toString()
        );
        tfPreco.setText(
                jtNotebooks.getValueAt(jtNotebooks.getSelectedRow(), 
                        NotebookTableModel.COL_PRECO).toString()
        );
        tfCor.setText(
                jtNotebooks.getValueAt(jtNotebooks.getSelectedRow(), 
                        NotebookTableModel.COL_COR).toString()
        );
        
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_jtNotebooksMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confrma a exclusão?",
            "Exclusão de Notebook", JOptionPane.YES_NO_OPTION);
        
        
        if(confirma == 0){
            daoNotebook.excluir(Integer.parseInt(tfCodigo.getText()));
            this.limparCampos();
            this.atualizarTabela();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void rbModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbModeloActionPerformed

    private void tfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        String campo = "";
        if(rbMarca.isSelected()){
            campo = "marca";
        }else{
            campo = "modelo";
        }
        
        jtNotebooks.setModel(new NotebookTableModel(
                daoNotebook.buscarTodosFiltro(campo, tfFiltro.getText())));
        this.limparCampos();
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        this.limparCampos();
        this.atualizarTabela();
    }//GEN-LAST:event_btListarActionPerformed

    private void tfPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecoFocusLost
        try{
            Double i = Double.parseDouble(tfPreco.getText());
        }catch(NumberFormatException e){
            tfPreco.setText("");
            JOptionPane.showMessageDialog(null, "O valor deve ser um número.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tfPrecoFocusLost

    private void tfPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecoActionPerformed

    private void rbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMarcaActionPerformed

    private void rbSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSimActionPerformed

    private void rbNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNaoActionPerformed

    private void rbNaoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rbNaoPropertyChange
        
    }//GEN-LAST:event_rbNaoPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NoteBookView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NoteBookView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NoteBookView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NoteBookView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NoteBookView1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFiltro;
    private javax.swing.ButtonGroup bgGpu;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable jtNotebooks;
    private javax.swing.JRadioButton rbMarca;
    private javax.swing.JRadioButton rbModelo;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCor;
    private javax.swing.JTextField tfFiltro;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
