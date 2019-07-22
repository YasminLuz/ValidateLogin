package Negocio;

import java.sql.SQLException;

/**
 *
 * @author Yasmin
 */
public class UserDTO {
    private String login; 
    private String pass;

    public UserDTO() {
       
    }
       
    public UserDTO(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getValidate() throws SQLException{
        return new UsersDAO().compare(this);
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

}
