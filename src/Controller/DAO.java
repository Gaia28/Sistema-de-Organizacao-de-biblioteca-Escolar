
package Controller;

import Model.Livros;
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
    private static final String BUSCAR_LIVROS = "SELECT *FROM Livros";
    private static final String VERIFICAR_LIVRO = "SELECT *FROM Livros WHERE ISBN = ?";
    
    
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
        }
        return livros;
    }
    
    public Livros VerificarLivros(String ISBN, String Titulo){
        
     Connection connection = ConexaoSQLite.getInstance().abrirConexao();
     Livros livro = null;
     
        try {
         PreparedStatement preparedStatement = connection.prepareStatement(VERIFICAR_LIVRO);

        preparedStatement.setString(1, ISBN);


        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) { 
                livro = new Livros(
                        resultSet.getString("ISBN"),
                        resultSet.getString("titulo"),
                        resultSet.getString("genero"),
                        resultSet.getString("autor"),
                        resultSet.getBoolean("disponivel")
                );
            }
        }
    } catch (SQLException e) {
        
        JOptionPane.showMessageDialog(null, "Erro ao verificar livro: " + e.getMessage());
        e.printStackTrace();
    }

    return livro;
}
}
