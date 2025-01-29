
package View;

import Controller.DAO;
import Model.Livros;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class TelaPrincipal extends javax.swing.JFrame {

       public TelaPrincipal() {
        initComponents();
        InserirLivrosTabela();
        
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        botaoCadastrarEmprestimo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAcervo = new javax.swing.JTable();
        campoDeBusca = new org.jdesktop.swingx.JXSearchField();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/185072_read_book_icon.png"))); // NOI18N
        jButton1.setText("<html><center>Cadastrar<br>Livro</center></html>");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botaoCadastrarEmprestimo.setBackground(new java.awt.Color(255, 255, 255));
        botaoCadastrarEmprestimo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCadastrarEmprestimo.setForeground(new java.awt.Color(51, 51, 51));
        botaoCadastrarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/emprestimo.png"))); // NOI18N
        botaoCadastrarEmprestimo.setText("<html><center>Registrar<br>Empréstimo</center></html>");
        botaoCadastrarEmprestimo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        botaoCadastrarEmprestimo.setFocusPainted(false);
        botaoCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarEmprestimoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

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
        jScrollPane1.setViewportView(tabelaAcervo);

        campoDeBusca.setBackground(new java.awt.Color(255, 255, 255));
        campoDeBusca.setForeground(new java.awt.Color(51, 51, 51));
        campoDeBusca.setToolTipText("Pesquisar");
        campoDeBusca.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        campoDeBusca.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        campoDeBusca.setLayoutStyle(org.jdesktop.swingx.JXSearchField.LayoutStyle.MAC);
        campoDeBusca.setMargin(new java.awt.Insets(2, 8, 2, 6));
        campoDeBusca.setOuterMargin(new java.awt.Insets(0, 0, 0, 2));
        campoDeBusca.setPrompt("Buscar livro");
        campoDeBusca.setPromptForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(campoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(campoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/9042816_page_search_icon.png"))); // NOI18N
        jButton2.setText("<html><center>Visualizar<br>Empréstimos</center></html>");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton2.setFocusPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(12, 12, 12)
                        .addComponent(botaoCadastrarEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(343, 343, 343))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCadastrarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaCadastroLivros telaCadastroLivros = new TelaCadastroLivros();
        dispose();
        telaCadastroLivros.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoCadastrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarEmprestimoActionPerformed
        TelaCadastroEmprestimos telaCadastroEmprestimos = new TelaCadastroEmprestimos();
        dispose();
        telaCadastroEmprestimos.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarEmprestimoActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        TelaEmprestimos telaEmprestimos = new TelaEmprestimos();
        dispose();
        telaEmprestimos.setVisible(true);
                
    }//GEN-LAST:event_jButton2MouseClicked

    
    
  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
   
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarEmprestimo;
    private org.jdesktop.swingx.JXSearchField campoDeBusca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAcervo;
    // End of variables declaration//GEN-END:variables
}
