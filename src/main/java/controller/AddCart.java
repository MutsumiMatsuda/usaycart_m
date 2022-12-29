package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CarsDAO;
import model.dto.CarDto;
import model.dto.CartDto;
import util.CartLogic;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");

    HttpSession session = request.getSession();

    CartDto cart = (CartDto) session.getAttribute("cart");
    if (cart == null) {
      cart = new CartDto();
    }

    CarsDAO cd = new CarsDAO();

    CarDto car = cd.getACar(id);

    CartLogic logic = new CartLogic();
    logic.execute(cart, car);

    session.setAttribute("cart", cart);
    request.setAttribute("message", car.getName() + "をカートに追加しました");
    request.getRequestDispatcher("cart.jsp").forward(request, response);
  }
}
