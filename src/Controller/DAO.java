
package Controller;

import Model.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {
    
//-----------QUERRYs DO BANCO DE DADOS-------------//    
    
    private static final String CADASTRAR_LIVRO = "INSERT  INTO Livros (ISBN, titulo, genero, autor, disponivel) VALUES(?,?,?,?,?)";
    
    
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
}
