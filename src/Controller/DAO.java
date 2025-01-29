
package Controller;

import Model.Alunos;
import Model.Emprestimos;
import Model.Livros;
import View.TelaPrincipal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;


public class DAO {
    
//-----------QUERRYs DO BANCO DE DADOS-------------//    
    
    private static final String CADASTRAR_LIVRO = "INSERT  INTO Livros (ISBN, titulo, genero, autor, disponivel) VALUES(?,?,?,?,?)";
    private static final String CADASTRAR_ALUNO = "INSERT INTO Alunos  (nome, turma) VALUES (?,?)";
    private static final String CADASTRAR_EMPRESTIMO = "INSERT INTO Emprestimos (alunoId, livroISBN, dataEmprestimo, dataDevolucao, devolvido) VALUES (?,?,?,?,?)";
    private static final String BUSCAR_LIVROS = "SELECT *FROM Livros";
    private static final String VERIFICAR_LIVRO = "SELECT 1 FROM Livros WHERE ISBN = ?";
    private static final String VERIFICAR_EMPRESTIMO = "SELECT 1 FROM Emprestimos WHERE LivroISBN = ?";
    private static final String VERIFICAR_EMPRESTIMO_ALUNO = "SELECT 1 FROM Emprestimos WHERE alunoId = ? AND devolvido = false";
 //-----------------------------------------------//  

    
    
    public void CadastrarLivros(Livros livro){
    Connection conection = ConexaoSQLite.getInstance().abrirConexao();
    
        try {
            PreparedStatement preparedStatement = conection.prepareStatement(CADASTRAR_LIVRO);
            preparedStatement.setString(1, livro.getISBN());
            preparedStatement.setString(2, livro.getTitulo());
            preparedStatement.setString(3, livro.getGenero());
            preparedStatement.setString(4, livro.getAutor());
            preparedStatement.setBoolean(5, livro.isDisponivel());
            
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro Cadastrado com Sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
            e.printStackTrace();
        }finally{
            ConexaoSQLite.getInstance().fecharConexao();
        }
    }
    
    public List<Livros> BuscarLivros(){
        List<Livros> livros = new ArrayList<>();
        Connection connection = ConexaoSQLite.getInstance().abrirConexao();
    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_LIVROS);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
               
                String ISBN = resultSet.getString("ISBN");
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                String autor = resultSet.getString("autor");
                boolean disponivel = resultSet.getBoolean("disponivel");
                
                Livros livro = new Livros(ISBN, titulo, genero, autor, disponivel);
                livros.add(livro);
              
                
            }
            
        } catch (Exception e) {
        }finally {
            ConexaoSQLite.getInstance().fecharConexao();
        }
        return livros;
    }
    
    public List<Livros> PesquisarLivrosPorTitulo(String titulo){
        List<Livros> livros = new ArrayList<>();
        Connection connection = ConexaoSQLite.getInstance().abrirConexao();
        
        try {
            
            String SQL = "SELECT *FROM Livros WHERE titulo LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, "%" + titulo + "%"); // Busca parcial pelo título
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
            String ISBN = resultSet.getString("ISBN");
            String tituloLivro = resultSet.getString("titulo");
            String genero = resultSet.getString("genero");
            String autor = resultSet.getString("autor");
            boolean disponivel = resultSet.getBoolean("disponivel");

            Livros livro = new Livros(ISBN, tituloLivro, genero, autor, disponivel);
            livros.add(livro);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConexaoSQLite.getInstance().fecharConexao();
        }
        return livros;
    }
    
    public boolean VerificarLivros(String ISBN){
        
     Connection connection = ConexaoSQLite.getInstance().abrirConexao();
     boolean livroExiste = false;
     
        try {
         PreparedStatement preparedStatement = connection.prepareStatement(VERIFICAR_LIVRO);

        preparedStatement.setString(1, ISBN);


        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) { 
                livroExiste = true;   
            }
        }
    } catch (SQLException e) {
        
        JOptionPane.showMessageDialog(null, "Erro ao verificar livro: " + e.getMessage());
        e.printStackTrace();
    }finally{
        ConexaoSQLite.getInstance().fecharConexao();
        }

    return livroExiste;
}
    public int CadastrarAluno(Alunos aluno) {
    Connection connection = ConexaoSQLite.getInstance().abrirConexao();
    int idGerado = -1;
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(
            CADASTRAR_ALUNO,
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, aluno.getNome());
        preparedStatement.setString(2, aluno.getTurma());
        preparedStatement.executeUpdate();

        // Recuperar o ID gerado
        ResultSet keys = preparedStatement.getGeneratedKeys();
        if (keys.next()) {
            idGerado = keys.getInt(1);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno: " + e.getMessage());
        e.printStackTrace();
    } finally {
        ConexaoSQLite.getInstance().fecharConexao();
    }
    return idGerado;
}

    
   
    public void CadastrarEmprestimo(Emprestimos emprestimo) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement updateStatement = null;

    try {
        connection = ConexaoSQLite.getInstance().abrirConexao();
        connection.setAutoCommit(false); // Início da transação

        // Verificar disponibilidade do livro

        // Inserir empréstimo
        preparedStatement = connection.prepareStatement(CADASTRAR_EMPRESTIMO);
        preparedStatement.setInt(1, emprestimo.getAlunoId());
        preparedStatement.setString(2, emprestimo.getLivroISBN());
        preparedStatement.setString(3, emprestimo.getDataEmprestimo());
        preparedStatement.setString(4, emprestimo.getDataDevolucao());
        preparedStatement.setBoolean(5, emprestimo.isDevolvido());
        preparedStatement.executeUpdate();

        // Atualizar disponibilidade do livro
        String atualizarDisponibilidade = "UPDATE Livros SET disponivel = false WHERE ISBN = ?";
        updateStatement = connection.prepareStatement(atualizarDisponibilidade);
        updateStatement.setString(1, emprestimo.getLivroISBN());
        updateStatement.executeUpdate();
       

        connection.commit(); // Finaliza a transação
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.InserirLivrosTabela();
        JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
    } catch (SQLException e) {
        try {
            if (connection != null) connection.rollback(); // Reverte em caso de erro
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar empréstimo: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (updateStatement != null) updateStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


  public int BuscarIdAluno(String nome, String Turma){
      Connection connection = ConexaoSQLite.getInstance().abrirConexao();
      int idAluno = -1;
      
      String buscarId = "SELECT aluno_id FROM Alunos WHERE nome = ? AND turma = ? ";
      
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(buscarId);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, Turma);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                idAluno = resultSet.getInt("aluno_id");       
            }
          
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar Aluno " + e.getMessage());

      }finally{
          ConexaoSQLite.getInstance().fecharConexao();
      }
        return idAluno;
  }
  
    public boolean VerificarEmprestimo(String ISBN){
      
        Connection connection = ConexaoSQLite.getInstance().abrirConexao();
        boolean emprestimoAtivo = false;
      try {
          PreparedStatement preparedStatement = connection.prepareStatement(VERIFICAR_EMPRESTIMO);
          preparedStatement.setString(1, ISBN);
          
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()){
              emprestimoAtivo = true;
              
          }
          
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao verificar emprestimo " + e.getMessage());

      }finally{
          ConexaoSQLite.getInstance().abrirConexao();
      }
      return  emprestimoAtivo;
  }
 
  public boolean VerificarEmprestimoAluno(int alunoId) {
    Connection connection = ConexaoSQLite.getInstance().abrirConexao();
    boolean possuiEmprestimos = false;
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(VERIFICAR_EMPRESTIMO_ALUNO);
        preparedStatement.setInt(1, alunoId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            possuiEmprestimos = true;
            System.out.println("Aluno com ID " + alunoId + " já possui empréstimos pendentes.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao verificar aluno: " + e.getMessage());
    } finally {
        ConexaoSQLite.getInstance().fecharConexao();
    }
    return possuiEmprestimos;
}

}
