/*package HuXuyang.week4;

import javafx.scene.web.HTMLEditor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;


@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456")
        },loadOnStartup = 1
)

public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    private HTMLEditor writer;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//connection within do get
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;databaseName=userdb";
        //String username="sa";
        //String password="123456";
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("谢谢张凯");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet rs=null;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("selfValidateType");
        String birthDate=request.getParameter("date");
        String sql1="INSERT INTO dbo.usertable"+
                "(username,password,email,gender,birthDate)VALUES(?,?,?,?,?)";
        try{
            PreparedStatement statement=con.prepareStatement(sql1);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,email);
            //statement.setString(4,gender);
           // statement.setDate(5,Date.valueOf(birthDate));
            int num= statement.executeUpdate();
            if(num>0){
                System.out.println("add success");
            }else{
                System.out.println("false");
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        response.setContentType("text/html");
        String sql2="select*from usertable";
        PrintWriter writer = response.getWriter();
        try {
            Statement statement;
            statement=con.createStatement();
            rs=statement.executeQuery(sql2);

            writer.print("<table  border=\"1\" align=\"center\">");
            writer.print("<tr>");
            writer.print("<td>"+"id"+"</td>");
            writer.print("<td>"+"username"+"</td>");
            writer.print("<td>"+"password"+"</td>");
           writer.print("<td>"+"email"+"</td>");
            writer.print("<td>"+"gender"+"</td>");
            writer.print("</tr>");
            while (rs.next()){

                writer.print("<tr>");
                writer.print("<td>"+rs.getObject("id")+"</td>");
               writer.print("<td>"+rs.getObject("username")+"</td>");
               writer.print("<td>"+rs.getObject("password")+"</td>");
                writer.print("<td>"+rs.getObject("email")+"</td>");
                writer.print("<td>"+rs.getObject("gender")+"</td>");
                writer.print("<td>"+rs.getObject("birhtDate")+"</td>");
                writer.print("</tr>");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void destroy(){
        super.destroy();
        try{
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
*/