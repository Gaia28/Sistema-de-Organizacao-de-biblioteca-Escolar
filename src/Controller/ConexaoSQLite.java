package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {
    
//String home = System.getProperty("user.home");  
//String URL = "jdbc:sqlite:" + home + "/SIGIB/SIGIB.db";
   private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "/SIGIB.db";

    private static Connection connection;
    private static ConexaoSQLite instancia;
    
    public static ConexaoSQLite getInstance() {
        if (instancia == null) {
            instancia = new ConexaoSQLite();
        }
        return instancia;
    }   
    
    public Connection abrirConexao() {
        try {
            String driver = "org.sqlite.JDBC";
            Class.forName(driver); // Carrega o driver
            connection = DriverManager.getConnection(URL); // Cria a conexão
            System.out.println("Conectado ao banco de dados.");
            
            // Configurar o PRAGMA busy_timeout para evitar bloqueios
            Statement stmt = connection.createStatement();
            stmt.execute("PRAGMA busy_timeout = 5000;");
            stmt.close();
        
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar com o Banco de Dados: " + e.getMessage());
        }
        return connection;
    }
    
    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        } finally {
            connection = null;
        }
    }
    public void limparBanco() {
    String sql = "DELETE FROM Livros"; // Substitua pelo nome das suas tabelas

    try (Connection conn = abrirConexao();
         Statement stmt = conn.createStatement()) {
        
        // Desativa restrições de chave estrangeira para evitar erros de exclusão
        stmt.execute("PRAGMA foreign_keys = OFF;");
        
        // Lista todas as tabelas e exclui os dados
        String[] tabelas = {"Livros", "Alunos", "Emprestimos", "HistoricoEmprestimos"}; // Substitua pelos nomes reais
        for (String tabela : tabelas) {
            stmt.executeUpdate("DELETE FROM " + tabela + ";");
            stmt.executeUpdate("DELETE FROM sqlite_sequence WHERE name='" + tabela + "';"); // Reseta IDs autoincrementáveis
        }
        
        // Reativa as chaves estrangeiras
        stmt.execute("PRAGMA foreign_keys = ON;");
        
        System.out.println("Banco de dados limpo com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao limpar o banco de dados: " + e.getMessage());
    }
}

}
