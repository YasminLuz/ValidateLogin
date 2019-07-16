package Negocio;

import br.com.baseconnection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Yasmin
 */
public class UsersDAO {
    //    instrucoes
    private final String create = "INSERT INTO Autenticate(username, pass) VALUES (?,?)";
    private final String query = "SELECT * FROM Autenticate";
    
    //abre conexao
    Connection conn = MySQLConnection.getConexaoMySQL();
    PreparedStatement stmt = null;
    
    public void create(UserDTO vl){
        
        try {
            stmt = conn.prepareStatement(create);
            stmt.setString(1, vl.getUsername());
            stmt.setString(2, vl.getPass());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel criar usuario"+ ex);
            
        } finally{
            MySQLConnection.CloseConnection();
            
        }   
    }
    
    public ArrayList<UserDTO> AllList(){
        ArrayList<UserDTO> usersList = new ArrayList<>();
        
        try {
            conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UserDTO us = new UserDTO();
                us.setUsername(rs.getString("username"));
                us.setPass(rs.getString("pass"));
                
                usersList.add(us);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return usersList;
    }
    
    public String compare(String u, String p){
            
        try {
            conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                if(u.equalsIgnoreCase(rs.getString("username")) && p.equals(rs.getString("pass")))
                 return "Seja bem-vindo(a)!";
            }
           
            conn.close();
    
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return "Usuário ou senha estão incorretos";
    }
    
    
    
}
