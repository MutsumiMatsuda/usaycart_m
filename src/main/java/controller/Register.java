package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.CustomerDto;
import util.Varidator;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String postalCode = request.getParameter("postalCode");
        String pref = request.getParameter("pref");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birhday");
        String mobile = request.getParameter("mobile");
        String pass = request.getParameter("pass");
        
        List<String> errorMessage = new ArrayList<>();

        if (name.isEmpty() | mail.isEmpty() | postalCode.isEmpty() | pref.isEmpty() | address.isEmpty() | birthday.isEmpty() | mobile.isEmpty() | pass.isEmpty()) {
            errorMessage.add("入力されていない項目があります。");
        }

        if (!Varidator.isMail(mail)) {
            errorMessage.add("メールアドレスの形式を確認してください。");
        }
        if (!Varidator.isPostalCode(postalCode)) {
            errorMessage.add("郵便番号の形式を確認してください。");
        }
        if (!Varidator.isMobilePhone(mobile)) {
            errorMessage.add("携帯電話の形式を確認してください。");
        }

        request.setAttribute("errorMessage", errorMessage);
        
        CustomerDto customer = new CustomerDto(name,mail,postalCode,pref,address,birthday,mobile,pass);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("customer",customer);

        if (errorMessage.isEmpty()) {
            request.getRequestDispatcher("confirm.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        }
    }

}
