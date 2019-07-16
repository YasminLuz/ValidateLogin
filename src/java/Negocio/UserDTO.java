package Negocio;

/**
 *
 * @author Yasmin
 */
public class UserDTO {
    private String username; 
    private String pass;

    public UserDTO() {
    
    }
    
    public UserDTO(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    private String getValidateLogon(){
        return new UsersDAO().compare(this.getUsername(), this.getPass());
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
    
    
    
    
}
