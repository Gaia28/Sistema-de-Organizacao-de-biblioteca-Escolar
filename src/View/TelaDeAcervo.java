
package View;

import Controller.DAO;
import Model.Livros;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class TelaDeAcervo extends javax.swing.JFrame {

    public TelaDeAcervo() {
        
       
        initComponents();
        InserirLivrosTabela();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        campoDeBusca.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        buscarLivros();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buscarLivros();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buscarLivros();
    }

    private void buscarLivros() {
        String tituloBusca = campoDeBusca.getText(); // Pegando o texto atualizado
        DAO dao = new DAO();
        List<Livros> livros;

        if (tituloBusca.isEmpty()) {
            livros = dao.BuscarLivros();
        } else {
            livros = dao.PesquisarLivrosPorTitulo(tituloBusca);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabelaAcervo.getModel();
        modelo.setRowCount(0);

        for (Livros livro : livros) {
            modelo.addRow(new Object[] {
                livro.getISBN(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getGenero(),
                livro.isDisponivel() ? "Sim" : "Não"
            });
        }

    }
});

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAcervo = new javax.swing.JTable();
        campoDeBusca = new org.jdesktop.swingx.JXSearchField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuVoltar = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento Bibliotecário");

        jDesktopPane1.setBackground(new java.awt.Color(63, 117, 189));

        jPanel1.setBackground(new java.awt.Color(224, 238, 248));

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 93, 164));
        jLabel1.setText("BIBLIOTECA ANÍSIO TEIXEIRA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(515, 515, 515))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(224, 238, 248));

        tabelaAcervo.setBackground(new java.awt.Color(255, 255, 255));
        tabelaAcervo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabelaAcervo.setForeground(new java.awt.Color(51, 51, 51));
        tabelaAcervo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Titulo", "Autor", "Gênero", "Disponível"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAcervo.setEditingColumn(0);
        tabelaAcervo.setEditingRow(0);
        tabelaAcervo.setEnabled(false);
        tabelaAcervo.setFocusTraversalPolicyProvider(true);
        tabelaAcervo.setFocusable(false);
        tabelaAcervo.setGridColor(new java.awt.Color(51, 51, 51));
        tabelaAcervo.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabelaAcervo.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tabelaAcervo.setShowGrid(true);
        tabelaAcervo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaAcervo);

        campoDeBusca.setBackground(new java.awt.Color(255, 255, 255));
        campoDeBusca.setForeground(new java.awt.Color(51, 51, 51));
        campoDeBusca.setCaretColor(new java.awt.Color(51, 51, 51));
        campoDeBusca.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        campoDeBusca.setLayoutStyle(org.jdesktop.swingx.JXSearchField.LayoutStyle.MAC);
        campoDeBusca.setPromptForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(campoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jMenuBar1.setBackground(new java.awt.Color(191, 38, 66));

        menuVoltar.setForeground(new java.awt.Color(255, 255, 255));
        menuVoltar.setText("File");
        menuVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuVoltarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuVoltar);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVoltarMouseClicked
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        dispose();
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_menuVoltarMouseClicked

    
    public void InserirLivrosTabela(){
        DAO dao = new DAO();
        List<Livros> livros = dao.BuscarLivros();
        
         DefaultTableModel modelo = (DefaultTableModel) tabelaAcervo.getModel();
         modelo.setRowCount(0);
         for(Livros livro: livros){
         modelo.addRow(new Object[]{
                livro.getISBN(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getGenero(),
                livro.isDisponivel() ? "Sim" : "Não"
            });
         
         }
    
    
    }
    
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
            java.util.logging.Logger.getLogger(TelaDeAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeAcervo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXSearchField campoDeBusca;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuVoltar;
    private javax.swing.JTable tabelaAcervo;
    // End of variables declaration//GEN-END:variables
}
