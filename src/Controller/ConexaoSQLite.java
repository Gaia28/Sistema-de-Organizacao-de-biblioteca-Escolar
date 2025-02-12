package Controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {
    
   // String path = new File("SIGIB.db").getAbsolutePath();
   private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "/SIGIB.db";
    //  private static final String URL = "jdbc:sqlite:";

    private static Connection connection;
    private static ConexaoSQLite instancia;
    
    
    public static ConexaoSQLite getInstance(){
        if(instancia == null){
            instancia = new ConexaoSQLite();
            
        }
            return instancia;
    }   
    
    public Connection abrirConexao(){
        
        try {
            
            String Driver = "org.sqlite.JDBC";
            Class.forName(Driver); // Carrega o driver
            connection = DriverManager.getConnection(URL); // Cria uma nova conexão
            System.out.println("Conectado");
        
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar com o Banco de Dados: " + e.getMessage());
        }
            return connection;
    }
    
    public void fecharConexao(){
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("Conexão fechada");
            
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        } finally {
            connection = null;
        }
    }
    
    
}
