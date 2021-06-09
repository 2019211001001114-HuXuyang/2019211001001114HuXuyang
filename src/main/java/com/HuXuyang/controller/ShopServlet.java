package com.HuXuyang.controller;

import com.HuXuyang.dao.ProductDao;
import com.HuXuyang.model.Category;
import com.HuXuyang.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value="/shop")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        try {
            List<Category> categoryList=category.findAllCategory((Connection)getServletContext().getAttribute("con"));
            request.setAttribute("categoryList",categoryList);
            ProductDao productDao =new ProductDao();
            List<Product> productList=null;
            if(request.getParameter("categoryId")==null) {
                productList=productDao.findAll((Connection)getServletContext().getAttribute("con"));
            }
            else {
                int categoryId= Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(categoryId,(Connection)getServletContext().getAttribute("con"));

            }
            request.setAttribute("productList",productList);
            String path="/WEB-INF/views/shop.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
