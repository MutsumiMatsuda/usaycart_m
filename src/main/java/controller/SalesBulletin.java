package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SalesBulletinDAO;

@WebServlet("/SalesBulletin")
public class SalesBulletin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        SalesBulletinDAO sb = new SalesBulletinDAO();

        session.setAttribute("saleses", sb.getSalesesBean());

        request.getRequestDispatcher("sales_bulletin.jsp").forward(request, response);
    }

}
