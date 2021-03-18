package HuXuyang.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWork extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-mm-dd");
            String time=format.format(date);
            PrintWriter writer= response.getWriter();
            writer.println("Name:"+"huxuyang"+"<br>");
            writer.println("Id:"+"2019211001001114"+"<br>");
            writer.println("Date:"+time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            PrintWriter writer = response.getWriter();
//            writer.println("huxvyang");
//            String password=request.getParameter("password");
//            writer.println(password);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
