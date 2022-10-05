package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SalesBulletinDAO;

@WebServlet(urlPatterns = {"/LoginStaff"})
public class LoginStaff extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        if (id.equals("imai") && pass.equals("p")) {

            SalesBulletinDAO sb = new SalesBulletinDAO();
            
            request.setAttribute("saleses", sb.getSalesesBean());
            
            request.getRequestDispatcher("sales_bulletin.jsp").forward(request, response);

        } else {
            response.sendRedirect("login_error.jsp");
        }
    }
}
