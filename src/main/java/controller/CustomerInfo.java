package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.CustomerDto;

@WebServlet(urlPatterns = {"/CustomerInfo"})
public class CustomerInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        HttpSession session = request.getSession();
        
        CustomerDto customer = (CustomerDto)session.getAttribute("customer");
        
        if (customer != null) {
            request.getRequestDispatcher("customer_info.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
