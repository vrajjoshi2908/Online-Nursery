
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editreturn extends HttpServlet {
 Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uid = request.getParameter("uid");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             Class.forName("org.apache.derby.jdbc.ClientDriver"); 
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/varsha","root","varsha");
            pst = con.prepareStatement("select * from register where uid = ?");
            pst.setString(1, uid);
            rs = pst.executeQuery();
           
           while(rs.next())
           {
               out.print("<form action='EditServlet' method='get'");
                out.print("<pre><center><h1>Edit Your information , Then Press On Submit Button</h1></center></pre>");
               out.print("<table cellspacing='0' width='280px'  border='1' align='center'");
                out.print("<tr><pre><b><td align='center'>User id :</b></td><td><input type='text' align='center' name='uid' id='uid' value='"+rs.getString("uid")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'>User name :</b></td><td><input type='text' align='center' name='uname' id='uname' value='"+rs.getString("uname")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'>Mobile :</b></td><td><input type='text' align='center' name='mob' id='mob' value='"+rs.getString("mob")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'>Email :</b></td> <td><input type='text align='center'' name='email' id='email' value='"+rs.getString("email")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'>State :</b></td><td><input type='text' align='center' name='state' id='state' value='"+rs.getString("state")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'>City :</b></td><td><input type='text' align='center' name='city' id='city' value='"+rs.getString("city")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'>Pin :</b></td><td><input type='text' align='center' name='pin' id='pin' value='"+rs.getString("pin")+"'/></td> </tr></pre>");
                out.print("<tr><pre><b><td align='center'> Address :</b></td>     <td><input type='text' align='center' name='addr' id='addr' value='"+rs.getString("addr")+"'/></td> </tr></pre>");
                 out.print("<tr><pre><center><b> <td align='center' colspan='2'><input type='submit' value='Submit'/></b></td> </tr></center></pre>");
               out.print("</table");
               out.print("</form");
           }
           
           
           
           
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Editreturn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
               
             out.println("<font color='red'>Recorded failed</font>");
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
