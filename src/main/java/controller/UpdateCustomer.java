package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CustomersDAO;
import model.dto.CustomerDto;
import util.Sanitizer;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        
        String name = Sanitizer.sanitizing(request.getParameter("name"));
        
        customer.setName(name);
        customer.setMail(request.getParameter("mail"));
        customer.setPostalCode(request.getParameter("postalCode"));
        customer.setPref(request.getParameter("pref"));
        customer.setAddress(request.getParameter("address"));
        customer.setBirthday(request.getParameter("birhday"));
        customer.setMobile(request.getParameter("mobile"));
        customer.setPass(request.getParameter("pass"));
        
        CustomersDAO cd = new CustomersDAO();
        cd.updateCustomer(customer);

        request.getRequestDispatcher("update_success.jsp").forward(request, response);
    }
}
