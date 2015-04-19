/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package register;

import static database.Database.getConnection;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author c0647754
 */
@Path("/register")
public class Register {
    @POST
    public void post(String str) {
        try {
            JsonObject json = Json.createReader(new StringReader(str)).readObject();
            String username = json.getString("username");
            String password = json.getString("password");
            String email = json.getString("email");
            String address = json.getString("address");
            String phone = json.getString("phone");
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO register (username,password,email,address,phone) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3,email);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
           Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }


}
  

    

