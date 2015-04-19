/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package register;

import static database.Database.getConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author c0647754
 */
@WebServlet("/dologin")
public class Login extends HttpServlet{
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultSet resultset=null;
         try {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("Uname:"+username);
            System.out.println("Pass:"+password);
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM register WHERE username=? AND password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultset=pstmt.executeQuery();
            if(resultset.next())
            {
                response.sendRedirect("survey.html");
            }
            else
            {
                response.sendRedirect("index.html");
            }
         } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
