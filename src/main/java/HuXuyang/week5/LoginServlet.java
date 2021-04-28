package HuXuyang.week5;

import com.HuXuyang.dao.UserDao;
import com.HuXuyang.model.User;

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
/*@WebServlet(
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456")
        },loadOnStartup = 1
)*/
@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet{
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //when user click login menu - request is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();

        //now move jdbc code in dao - MVC design
        //write mvc code
        //use model and dao
        UserDao userDao=new UserDao();
        try {
           User user= userDao.findByUsernamePassword(con,username,password);//this methods use for login
            if(user!=null){

                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session =  request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                //invalid
                request.setAttribute("message","Username or Paaaword error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





        //forward - JSP
//        boolean isValid = false;
//        PreparedStatement pre = null;
//        ResultSet result = null;
//        try {
//            String sql = "SELECT * FROM usertable WHERE username=? AND password=?";
//            pre = con.prepareStatement(sql);
//            pre.setString(1, username);
//            pre.setString(2, password);
//            result = pre.executeQuery();
//            if (result.next()){
//                isValid = true;
////              writer.println("Login success!!!");
//                request.setAttribute("id",result.getInt("id"));
//                request.setAttribute("username",result.getString("Username"));
//                request.setAttribute("password",result.getString("password"));
//                request.setAttribute("email",result.getString("Email"));
//                request.setAttribute("gender",result.getString("Gender"));
//                request.setAttribute("birthDate",result.getString("BirthDate"));
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            }
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        if(!isValid){
////            writer.println("Username or Password Error!!!");
//            request.setAttribute("message","username or password Error");
//            request.getRequestDispatcher("login.jsp").forward(request,response);
//        }

    }
}

