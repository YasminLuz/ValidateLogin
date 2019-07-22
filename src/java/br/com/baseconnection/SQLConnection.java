package br.com.baseconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yasmin
 */

public class SQLConnection {
 
    public static String status = "Não conectou...";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String serverName = "localhost";    //caminho do servidor do BD
    private static String mydatabase = "SystemUser";        
    private static final String url = "jdbc:derby://" + serverName + "/" + mydatabase;
    private static String username = "root";            
    private static String password = "root";   
 
    //Método de Conexão//
    public static Connection getConexaoSQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {
            // Carregando o JDBC Driver padrão
            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
                if (connection != null) 
                    status = ("STATUS--->Conectado com sucesso!");
                else 
                    status = ("STATUS--->Não foi possivel realizar conexão");

                return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");

            return null;
            
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;
        }

    }

    //Método que retorna o status da sua conexão
    public static String statusConnection() {
        return status;
    }
 
   //Método que fecha sua conexão
    public static boolean CloseConnection() {
 
        try { 
            SQLConnection.getConexaoSQL().close();
 
            return true;
 
        } catch (SQLException e) {
            return false;
 
        }

    }

   //Método que reinicia sua conexão//
 
    public static java.sql.Connection RestartConnection(){
        CloseConnection();
        return SQLConnection.getConexaoSQL();
 
    }
 
}
    

