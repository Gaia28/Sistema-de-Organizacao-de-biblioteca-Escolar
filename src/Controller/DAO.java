
package Controller;

import Model.Alunos;
import Model.Emprestimos;
import Model.Livros;
import View.TelaDeAcervo;
import View.TelaPrincipal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;


public class DAO {
    
//-----------QUERRYs DO BANCO DE DADOS-------------//    
    
    private static final String CADASTRAR_LIVRO = "INSERT  INTO Livros (ISBN, titulo, genero, autor, disponivel) VALUES(?,?,?,?,?)";
    private static final String CADASTRAR_ALUNO = "INSERT INTO Alunos  (nome, turma) VALUES (?,?)";
    private static final String CADASTRAR_EMPRESTIMO = "INSERT INTO Emprestimos (alunoId, livroISBN, dataEmprestimo, dataDevolucao, devolvido) VALUES (?,?,?,?,?)";
    private static final String BUSCAR_LIVROS = "SELECT *FROM Livros";
    private static final String VERIFICAR_LIVRO = "SELECT 1 FROM Livros WHERE ISBN = ?";
    private static final String VERIFICAR_EMPRESTIMO = "SELECT 1 FROM Emprestimos WHERE LivroISBN = ?";
    private static final String VERIFICAR_EMPRESTIMO_ALUNO = "SELECT 1 FROM Emprestimos WHERE alunoId = ? AND devolvido = false";
    
    private static final String BUSCAR_EMPRESTIMOS = 
     "SELECT e.id AS emprestimo_id, a.nome AS aluno_nome, a.turma AS aluno_turma, " +
        "l.ISBN AS livroISBN, l.titulo AS livro_titulo, e.dataEmprestimo, e.dataDevolucao, e.devolvido " +
        "FROM Emprestimos e " +
        "JOIN Alunos a ON e.alunoId = a.aluno_id " +
        "JOIN Livros l ON e.livroISBN = l.ISBN";
    
    private static final String EXCLUIR_LIVRO = "DELETE FROM Livros WHERE ISBN = ?";
    
    private static final String EXCLUIR_EMPRESTIMO = "DELETE FROM Emprestimos "
                             + "WHERE alunoId = (SELECT aluno_id FROM Alunos WHERE nome = ? AND turma = ?) "
                             + "AND livroISBN = ?";
    
    private static final String INSERIR_NO_HISTORICO = "INSERT INTO HistoricoEmprestimos (alunoId, livroISBN, dataEmprestimo, dataDevolucao) "
                              + "SELECT e.alunoId, e.livroISBN, e.dataEmprestimo, DATE('now') "
                              + "FROM Emprestimos e "
                              + "JOIN Alunos a ON e.alunoId = a.aluno_id "
                              + "WHERE a.nome = ? AND a.turma = ? AND e.livroISBN = ?";

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
            
            String SQL = "SELECT *FROM Livros WHERE titulo LIKE ? ";
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
        TelaDeAcervo telaDeAcervo = new TelaDeAcervo();
        telaDeAcervo.InserirLivrosTabela();
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
  
  public List<EmprestimoDTO> buscarEmprestimos(){
      List<EmprestimoDTO> emprestimos = new ArrayList<>();
      Connection connection = ConexaoSQLite.getInstance().abrirConexao();
      
      try {
          PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_EMPRESTIMOS);
          ResultSet resultSet = preparedStatement.executeQuery();
          
          while(resultSet.next()){
          
            int id = resultSet.getInt("emprestimo_id");
            String alunoNome = resultSet.getString("aluno_nome");
            String alunoTurma = resultSet.getString("aluno_turma");
            String livroTitulo = resultSet.getString("livro_titulo");
            String ISBNLivro = resultSet.getString("livroISBN");
            String dataEmprestimo = resultSet.getString("dataEmprestimo");
            String dataDevolucao = resultSet.getString("dataDevolucao");
            boolean devolvido = resultSet.getBoolean("devolvido");
            
            EmprestimoDTO emprestimo = new EmprestimoDTO(id, alunoNome, alunoTurma, livroTitulo,ISBNLivro , dataEmprestimo, dataDevolucao, devolvido);
            emprestimos.add(emprestimo);
          }
          
      } catch (Exception e) {
          e.printStackTrace();
      }finally{
          ConexaoSQLite.getInstance().fecharConexao();
      }
        return emprestimos;
  }
  
  public boolean ExcluirLivro(String ISBN){
  
      Connection connection = ConexaoSQLite.getInstance().abrirConexao();
      
      try {
          DAO dao = new DAO();
          
          if(dao.VerificarEmprestimo(ISBN) == true){
            JOptionPane.showMessageDialog(null, "O livro não pode ser excluído pois está emprestado.");
            return  false;

          }
          
           int confirmacao = JOptionPane.showConfirmDialog(
            null, 
            "Você deseja realmente excluir este livro?", 
            "Confirmação", 
            JOptionPane.YES_NO_OPTION
            );

            // Se o usuário clicar em "Não", cancela a exclusão
            if (confirmacao != JOptionPane.YES_OPTION) {
            return false;
            }
              PreparedStatement preparedStatement = connection.prepareStatement(EXCLUIR_LIVRO);
                preparedStatement.setString(1, ISBN);
                
                int linhasAfetadas = preparedStatement.executeUpdate();
                
            if (linhasAfetadas > 0) {
            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return false;
        }
          
          
      } catch (Exception e) {
          e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Erro ao excluir o livro.");
            return false;
      }finally{
          ConexaoSQLite.getInstance().fecharConexao();
      }
       
  }
  
  public boolean RegistrarDevolucao(String nomeAluno, String turma, String isbn){
      Connection connection = ConexaoSQLite.getInstance().abrirConexao();
      
       String atualizarDisponibilidade = "UPDATE Livros SET disponivel = 1 WHERE ISBN = ?";
      
      try {
          
          PreparedStatement preparedStatementInserir = connection.prepareStatement(INSERIR_NO_HISTORICO);
          
          preparedStatementInserir.setString(1, nomeAluno);
          preparedStatementInserir.setString(2, turma);
          preparedStatementInserir.setString(3, isbn);
          
          int HistoricoInserido = preparedStatementInserir.executeUpdate();
          
          if(HistoricoInserido > 0){
              
              PreparedStatement preparedStatementExcluir = connection.prepareStatement(EXCLUIR_EMPRESTIMO);
                preparedStatementExcluir.setString(1, nomeAluno);
                preparedStatementExcluir.setString(2, turma);
                preparedStatementExcluir.setString(3, isbn);
                preparedStatementExcluir.executeUpdate();
                
                PreparedStatement preparedStatementAtualizarLivro = connection.prepareStatement(atualizarDisponibilidade);
                preparedStatementAtualizarLivro.setString(1, isbn);
                preparedStatementAtualizarLivro.executeUpdate();
                
                
                JOptionPane.showMessageDialog(null, "Devolução registrada com sucesso!");
                return true;
                
                
          }else {
            JOptionPane.showMessageDialog(null, "Nenhum empréstimo correspondente encontrado.");
            return false;
        }
          
      } catch (Exception e) {
          
          e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Erro ao registrar devolução");
          return false;
          
      }finally{
          ConexaoSQLite.getInstance().fecharConexao();
      }
  
  }
  
  public boolean editarLivro(String isbn, String novoTitulo, String novoAutor) {
    Connection connection = ConexaoSQLite.getInstance().abrirConexao();

    String sqlSelect = "SELECT titulo, autor FROM Livros WHERE ISBN = ?";
    String sqlUpdate = "UPDATE Livros SET titulo = ?, autor = ? WHERE ISBN = ?";

    try {
        PreparedStatement selectStmt = connection.prepareStatement(sqlSelect);
        selectStmt.setString(1, isbn);
        ResultSet rs = selectStmt.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return false;
        }

        // Pegando valores atuais
        String tituloAtual = rs.getString("titulo");
        String autorAtual = rs.getString("autor");

        // Se o usuário não informar um novo valor, mantemos o atual
        String tituloFinal = (novoTitulo == null || novoTitulo.isEmpty()) ? tituloAtual : novoTitulo;
        String autorFinal = (novoAutor == null || novoAutor.isEmpty()) ? autorAtual : novoAutor;

        // Atualizando no banco
        PreparedStatement updateStmt = connection.prepareStatement(sqlUpdate);
        updateStmt.setString(1, tituloFinal);
        updateStmt.setString(2, autorFinal);
        updateStmt.setString(3, isbn);

        int linhasAfetadas = updateStmt.executeUpdate();
        return linhasAfetadas > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao atualizar o livro: " + e.getMessage());
        return false;
    } finally {
        ConexaoSQLite.getInstance().fecharConexao();
    }
}
public List<EmprestimoDTO> pesquisarEmprestimosTabela(String pesquisa) {
    List<EmprestimoDTO> listaEmprestimos = new ArrayList<>();
    Connection connection = ConexaoSQLite.getInstance().abrirConexao();
    
    String sql = "SELECT e.id AS emprestimo_id, a.nome AS aluno_nome, a.turma AS aluno_turma, " +
                 "l.titulo AS livro_titulo, e.livroISBN, e.dataEmprestimo, e.dataDevolucao, e.devolvido " +
                 "FROM Emprestimos e " +
                 "JOIN Alunos a ON e.alunoId = a.aluno_id " +
                 "JOIN Livros l ON e.livroISBN = l.ISBN " +
                 "WHERE a.nome LIKE ? OR l.titulo LIKE ? OR e.livroISBN LIKE ? " +
                 "OR e.dataEmprestimo LIKE ? OR e.dataDevolucao LIKE ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        String parametro = "%" + pesquisa + "%"; // Permite buscar qualquer parte dos valores
        stmt.setString(1, parametro);
        stmt.setString(2, parametro);
        stmt.setString(3, parametro);
        stmt.setString(4, parametro);
        stmt.setString(5, parametro);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            EmprestimoDTO emprestimo = new EmprestimoDTO(
                rs.getInt("emprestimo_id"),
                rs.getString("aluno_nome"),
                rs.getString("aluno_turma"),
                rs.getString("livro_titulo"),
                rs.getString("livroISBN"),
                rs.getString("dataEmprestimo"),
                rs.getString("dataDevolucao"),
                rs.getBoolean("devolvido")
            );

            listaEmprestimos.add(emprestimo);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao buscar empréstimos: " + e.getMessage());
    } finally {
        ConexaoSQLite.getInstance().fecharConexao();
    }
    
    return listaEmprestimos;
}
public List<Map<String, String>> buscarEmprestimosAntigos() {
    List<Map<String, String>> listaEmprestimos = new ArrayList<>();
    String sql = "SELECT h.id, a.nome AS nomeAluno, a.turma, " +
                 "l.titulo AS tituloLivro, l.autor AS autorLivro, " +
                 "h.dataEmprestimo, h.dataDevolucao " +
                 "FROM HistoricoEmprestimos h " +
                 "JOIN Alunos a ON h.alunoId = a.aluno_id " +
                 "JOIN Livros l ON h.livroISBN = l.ISBN";

    try (Connection conn = ConexaoSQLite.getInstance().abrirConexao();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Map<String, String> emprestimo = new HashMap<>();
            emprestimo.put("id", String.valueOf(rs.getInt("id")));
            emprestimo.put("nomeAluno", rs.getString("nomeAluno"));
            emprestimo.put("turma", rs.getString("turma"));
            emprestimo.put("tituloLivro", rs.getString("tituloLivro"));
            emprestimo.put("autorLivro", rs.getString("autorLivro"));
            emprestimo.put("dataEmprestimo", rs.getString("dataEmprestimo"));
            emprestimo.put("dataDevolucao", rs.getString("dataDevolucao"));

            listaEmprestimos.add(emprestimo);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar empréstimos antigos: " + e.getMessage());
    }

    return listaEmprestimos;
}




}
