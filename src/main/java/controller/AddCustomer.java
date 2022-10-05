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

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String postalCode = request.getParameter("postalCode");
        String pref = request.getParameter("pref");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birhday");
        String mobile = request.getParameter("mobile");
        String pass = request.getParameter("pass");

        name = Sanitizer.sanitizing(name);

        HttpSession session = request.getSession();
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        if (customer == null) {
            customer = new CustomerDto(name, mail, postalCode, pref, address, birthday, mobile, pass);
        }

        CustomersDAO cd = new CustomersDAO();
        cd.addCustomer(customer);

        request.getRequestDispatcher("thankyou.jsp").forward(request, response);
    }
}
