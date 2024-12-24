
package View;

import Controller.DAO;
import Model.Livros;


public class TelaCadastroLivros extends javax.swing.JFrame {

 //1040x588 pixels -> painel principal
 //835x480 pixels -> painel de components
 //655x42 pixels -> textfield
 //210x45 pixels -> butao   
    
    public TelaCadastroLivros() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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

        buttonCadastrar.setBackground(new java.awt.Color(204, 204, 204));
        buttonCadastrar.setForeground(new java.awt.Color(51, 51, 51));
        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldAutor)
                            .addComponent(textFieldNome)
                            .addComponent(textFieldGenero)
                            .addComponent(textFieldISBN)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(buttonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addGap(215, 215, 215)))
                .addGap(126, 126, 126))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(textFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(textFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(textFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );

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
    SE O TEXTO ESTÁ VAZIO
    SE O LIVRO JÁ EXISTE NO BANCO DE DADOS
    SE O ISBN ESTÁ NO PADRÃO CORRETO
    
    DEIXAR OS CAMPOS DE TEXTOS EM BRANCO APÓS CONCLUIR
    */
    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        
        String titulo = textFieldNome.getText().trim();
        String autor = textFieldAutor.getText().trim();
        String genero = textFieldGenero.getText().trim();
        String ISBN = textFieldISBN.getText().trim();
        
        
        Livros livro = new Livros(ISBN, titulo, genero, autor, true);
        DAO dao = new DAO();
        dao.CadastrarLivros(livro);
    }//GEN-LAST:event_buttonCadastrarActionPerformed

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textFieldAutor;
    private javax.swing.JTextField textFieldGenero;
    private javax.swing.JTextField textFieldISBN;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}
