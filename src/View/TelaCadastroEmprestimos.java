
package View;

import Controller.DAO;
import Model.Alunos;
import Model.Emprestimos;
import Model.Livros;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TelaCadastroEmprestimos extends javax.swing.JFrame {

    public TelaCadastroEmprestimos() {
        initComponents();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textFieldAluno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textFieldTurma = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldIsbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        calendarioInicial = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        calendarioFinal = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        botaoConcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuVoltar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento Bibliotecário");

        jPanel1.setBackground(new java.awt.Color(63, 117, 189));

        jPanel2.setBackground(new java.awt.Color(224, 238, 248));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        textFieldAluno.setBackground(new java.awt.Color(255, 255, 255));
        textFieldAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldAluno.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Aluno");

        textFieldTurma.setBackground(new java.awt.Color(255, 255, 255));
        textFieldTurma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldTurma.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Turma");

        textFieldIsbn.setBackground(new java.awt.Color(255, 255, 255));
        textFieldIsbn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldIsbn.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ISBN");

        calendarioInicial.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Data de empréstimo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Data de entrega");

        botaoConcluir.setBackground(new java.awt.Color(63, 117, 189));
        botaoConcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoConcluir.setForeground(new java.awt.Color(255, 255, 255));
        botaoConcluir.setText("Concluir");
        botaoConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(botaoConcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(311, 311, 311))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldAluno)
                            .addComponent(textFieldTurma)
                            .addComponent(textFieldIsbn))
                        .addGap(31, 31, 31))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(calendarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(calendarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(botaoConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel3.setBackground(new java.awt.Color(224, 238, 248));

        jLabel3.setFont(new java.awt.Font("Bauhaus 93", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 93, 164));
        jLabel3.setText("BIBLIOTECA ANÍSIO TEIXEIRA");

        jLabel7.setBackground(new java.awt.Color(224, 238, 248));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(387, 387, 387)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        jMenuBar1.setBackground(new java.awt.Color(191, 38, 66));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

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

    private void menuVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVoltarMouseClicked
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        dispose();
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_menuVoltarMouseClicked

    public void LimparCamposTexto(){
        textFieldAluno.setText("");
        textFieldIsbn.setText("");
        textFieldTurma.setText("");
        calendarioInicial.setDate(null);
        calendarioFinal.setDate(null);
    }
    
    /*
    VERIFICAR SE OS CAMPOS ESTÃO VAZIOS -> OK
    VERIFICAR SE O LIVRO SOLICITADO FOI INSERIDO NO ACERVO -> OK
    VERIFICAR SE O LIVRO ESTÁ EMPRESTADO -> OK
    CADASTRAR ALUNO -> OK
    CADASTRAR EMPRESTIMO -> OK
    
    */
    private void botaoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConcluirActionPerformed
        
        String nomeAluno = textFieldAluno.getText();
        String turmaAluno = textFieldTurma.getText();
        String ISBN = textFieldIsbn.getText();
        java.util.Date dataEmprestimoUtil = calendarioInicial.getDate();
        java.util.Date dataEntregaUtil = calendarioFinal.getDate();
        
        DAO dao = new DAO();
        Alunos aluno = new Alunos(0, nomeAluno, turmaAluno );
        int alunoID = dao.BuscarIdAluno(nomeAluno, turmaAluno);
        
        if( nomeAluno.isEmpty() || turmaAluno.isEmpty() || ISBN.isEmpty() || dataEmprestimoUtil == null || dataEntregaUtil == null){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataEmprestimo = dateFormat.format(dataEmprestimoUtil);
        String dataEntrega = dateFormat.format(dataEntregaUtil);
       //se aluno estiver cadastrado:
        if (alunoID == -1) {
            
           JOptionPane.showMessageDialog(null, "Aluno não cadastrado. Confirme para cadastrar");
           dao.CadastrarAluno(aluno);
           alunoID = dao.BuscarIdAluno(nomeAluno, turmaAluno);
        }
           boolean emprestimoAtivo = dao.VerificarEmprestimoAluno(alunoID);
           boolean livroCadastrado = dao.VerificarLivros(ISBN);
           boolean livroEmprestado = dao.VerificarEmprestimo(ISBN);
           //se o aluno não tiver emprestimos
           if(emprestimoAtivo == false){
               JOptionPane.showMessageDialog(null, "aluno não possui emprestimos");
               
               //livro cadastrado no acervo
               if(livroCadastrado == true){
                JOptionPane.showMessageDialog(null, "livro cadastrado");
                
                Emprestimos emprestimo = new Emprestimos(alunoID, ISBN, dataEmprestimo, dataEntrega, false);

                //livro sem emprestimos registrado
                if(livroEmprestado == false){
                    JOptionPane.showMessageDialog(null, "livro não está emprestado");
                    dao.CadastrarEmprestimo(emprestimo);
                    LimparCamposTexto();
                    
                //livro já emprestado
                }else{
                    JOptionPane.showMessageDialog(null, "Esse livro já possui um empréstimo registrado");
                     LimparCamposTexto();
                    }   
               //livro não está cadastrado no acervo
               }else{
                    JOptionPane.showMessageDialog(null, "Esse livro não está cadastrado no acervo. Cadastre-o");
                     LimparCamposTexto();
               }
           //se o aluno tiver emprestimo
           }else{
                JOptionPane.showMessageDialog(null, "aluno já possui um emprestimo");
                 LimparCamposTexto();
           } 
           return;
           //aluno não cadastrado
        
 
    }//GEN-LAST:event_botaoConcluirActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEmprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConcluir;
    private org.jdesktop.swingx.JXDatePicker calendarioFinal;
    private org.jdesktop.swingx.JXDatePicker calendarioInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu menuVoltar;
    private javax.swing.JTextField textFieldAluno;
    private javax.swing.JTextField textFieldIsbn;
    private javax.swing.JTextField textFieldTurma;
    // End of variables declaration//GEN-END:variables
}
