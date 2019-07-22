package Negocio;

import br.com.baseconnection.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yasmin
 */
public class UsersDAO {
    //    instrucoes
    private final String create = "INSERT INTO ROOT.Autenticate(login, pass) VALUES (?,?)";
    private final String query = "SELECT login, pass FROM ROOT.Autenticate WHERE login = ? AND pass = ?" ;
    
    
    //abre conexao
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public UsersDAO(){
        conn = SQLConnection.getConexaoSQL();
        stmt = null;
    }
    
    public void create(UserDTO vl){
        
        try {
            stmt = conn.prepareStatement(create);
            stmt.setString(1, vl.getLogin());
            stmt.setString(2, vl.getPass());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel criar usuario"+ ex);
            ex.printStackTrace();
            
        } finally{
            SQLConnection.CloseConnection();
            
        }   
    }
    
    public ArrayList<UserDTO> AllList(){
        ArrayList<UserDTO> usersList = new ArrayList<>();
        
        try {
            conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UserDTO us = new UserDTO();
                us.setLogin(rs.getString("login"));
                us.setPass(rs.getString("pass"));
                
                usersList.add(us);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return usersList;
    }
    
    public String compare(UserDTO user) throws SQLException{
            
        try {           
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPass());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                if(user.getLogin().equalsIgnoreCase(rs.getString("login")) && user.getPass().equalsIgnoreCase(rs.getString("pass")))
                 return "Seja bem-vindo(a)!";
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            conn.close();
        }
        
        return "Usuário ou senha estão incorretos";
    }
    
    
    
}
