package HuXuyang.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class RegisterServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birthDate = request.getParameter("birthDate");

        PrintWriter writer = response.getWriter();
       // writer.println("<br>username :"+username);
        //writer.println("<br>password :"+password);
        //writer.println("<br>email :"+email);
        //writer.println("<br>gender :"+gender);
        //writer.println("<br>birthDate :"+birthDate);
        //writer.close();
           // System.out.println("username:" +username);
            //System.out.println("password:"+password);
           // System.out.println("email:"+email);
           // System.out.println("gender:"+gender);
           // System.out.println("birthDate:"+birthDate);
        String[][]arr=new String[100][6];
        int a=0;
        try{
            System.out.println("con:"+con);
            try {
                Statement createDbStatement=con.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String add="insert into usertable values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            //createDbStatement.executeUpdate(add);
        }catch (Exception e){
            System.out.println(e);
        }
        response.sendRedirect("login.jsp");

    }
}
