package HuXuyang.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456")
        },loadOnStartup = 1
)

public class LoginServlet extends HttpServlet {
    Connection con=null;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("link success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="Select * from usertable where username=? and password=?";
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<HTML>");
            out.println("<HEAD><TITLE>UsingServlet</TITLE></HEAD>");
            out.println("<Body>");

            if(rs.next()){
                out.println("Login Success!!!");
                out.println("<br/>");
                out.println("Welcome,"+username);

            }else{
                out.println("Username or Password Error!!!");

            }
            out.println("</HTML>");
            out.println("</Body>");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



    }

