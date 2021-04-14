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
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456")
        },loadOnStartup = 1
)

public class LoginServlet extends HttpServlet{
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();

        boolean isValid = false;
        PreparedStatement pre = null;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM usertable WHERE username=? AND password=?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            result = pre.executeQuery();
            if (result.next()){
                isValid = true;
//                writer.println("Login success!!!");
                request.setAttribute("id",result.getInt("id"));
                request.setAttribute("username",result.getString("Username"));
                request.setAttribute("password",result.getString("password"));
                request.setAttribute("email",result.getString("Email"));
                request.setAttribute("gender",result.getString("Gender"));
                request.setAttribute("birthDate",result.getString("BirthDate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(!isValid){
//            writer.println("Username or Password Error!!!");
            request.setAttribute("message","username or password Error");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}

