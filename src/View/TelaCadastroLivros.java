
package View;

import Controller.DAO;
import Model.Livros;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TelaCadastroLivros extends javax.swing.JFrame {

 //1040x588 pixels -> painel principal
     //835x480 pixels -> painel de components
 //655x42 pixels -> textfield
 //210x45 pixels -> butao   
    
    public TelaCadastroLivros() {
        
        initComponents();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textFieldISBN = new javax.swing.JTextField();
        textFieldGenero = new javax.swing.JTextField();
        textFieldNome = new javax.swing.JTextField();
        textFieldAutor = new javax.swing.JTextField();
        buttonCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuVoltar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento Bibliotecário");

        jPanel1.setBackground(new java.awt.Color(63, 117, 189));

        jPanel2.setBackground(new java.awt.Color(224, 238, 248));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        textFieldISBN.setBackground(new java.awt.Color(255, 255, 255));
        textFieldISBN.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textFieldISBN.setForeground(new java.awt.Color(51, 51, 51));
        textFieldISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldISBNActionPerformed(evt);
            }
        });

        textFieldGenero.setBackground(new java.awt.Color(255, 255, 255));
        textFieldGenero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textFieldGenero.setForeground(new java.awt.Color(51, 51, 51));
        textFieldGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldGeneroActionPerformed(evt);
            }
        });

        textFieldNome.setBackground(new java.awt.Color(255, 255, 255));
        textFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textFieldNome.setForeground(new java.awt.Color(51, 51, 51));

        textFieldAutor.setBackground(new java.awt.Color(255, 255, 255));
        textFieldAutor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textFieldAutor.setForeground(new java.awt.Color(51, 51, 51));
        textFieldAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAutorActionPerformed(evt);
            }
        });

        buttonCadastrar.setBackground(new java.awt.Color(63, 117, 189));
        buttonCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Título");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Autor");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Gênero");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ISBN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(buttonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(288, 288, 288))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldISBN)
                            .addComponent(textFieldGenero)
                            .addComponent(textFieldNome))))
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(textFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(224, 238, 248));

        jLabel5.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 93, 164));
        jLabel5.setText("BIBLIOTECA ANÍSIO TEIXEIRA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addGap(563, 563, 563))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        jMenuBar1.setBackground(new java.awt.Color(191, 38, 66));
        jMenuBar1.setBorder(null);

        menuVoltar.setForeground(new java.awt.Color(255, 255, 255));
        menuVoltar.setText("Voltar");
        menuVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuVoltarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuVoltar);

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

    private void textFieldISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldISBNActionPerformed

    private void textFieldAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAutorActionPerformed

    
    /*ADICIONAR VERIFICAÇÕES NOS CAMPOS DE TEXTO:
    SE O TEXTO ESTÁ VAZIO -> FEITO
    SE O LIVRO JÁ EXISTE NO BANCO DE DADOS -> FEITO
    SE O ISBN ESTÁ NO PADRÃO CORRETO
    DEIXAR OS CAMPOS DE TEXTOS EM BRANCO APÓS CONCLUIR -> FEITO
    */
    public void LimparCamposTexto(){
    
        textFieldNome.setText("");
        textFieldAutor.setText("");
        textFieldGenero.setText("");
        textFieldISBN.setText("");
    }
    
    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        
        String titulo = textFieldNome.getText().trim();
        String autor = textFieldAutor.getText().trim();
        String genero = textFieldGenero.getText().trim();
        String ISBN = textFieldISBN.getText().trim();
        DAO dao = new DAO();
        
        
        
        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || ISBN.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            
        }else if(dao.VerificarLivros(ISBN) == true){
            
            JOptionPane.showMessageDialog(null, "Livro já cadastrado");
            LimparCamposTexto();
            
        }else{
            
        Livros livro = new Livros(ISBN, titulo, genero, autor, true);
        dao.CadastrarLivros(livro);
        LimparCamposTexto();
        
        
        }
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void menuVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVoltarMouseClicked
       
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        dispose();
        telaPrincipal.setVisible(true);
        
    }//GEN-LAST:event_menuVoltarMouseClicked

    private void textFieldGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldGeneroActionPerformed

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu menuVoltar;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldGenero;
    private javax.swing.JTextField textFieldISBN;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}
