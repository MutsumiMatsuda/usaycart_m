package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CustomersDAO;
import model.dto.CustomerDto;

@WebServlet(urlPatterns = {"/Login"})
//public class Login extends HttpServlet {
public class Login extends Controller {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    // CSRFトークンの設定
    setCsrｆ(request);

    request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // CSRFチェック
    if (!verifyToken(request)) {
      request.getRequestDispatcher("err419.jsp").forward(request, response);
    }

    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    CustomersDAO cd = new CustomersDAO();

    CustomerDto customer = cd.getCustomer(id, pass);
    //        CustomerBean customer = cd.getCustomer("yuu@saycon.co.jp", "p");

    if (customer != null) {

      HttpSession session = request.getSession();

      session.setAttribute("customer", customer);

      request.getRequestDispatcher("member_only.jsp").forward(request, response);

    } else {
      response.sendRedirect("login_error.jsp");
    }
  }
}
