package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CarsDAO;
import model.dto.CarsDto;

@WebServlet("/Search")
public class Search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");

        HttpSession session = request.getSession();

        CarsDto carsbean = (CarsDto) session.getAttribute("cars");

        if (carsbean == null) {
            carsbean = new CarsDto();
        }

        CarsDAO cd = new CarsDAO();

        carsbean = cd.searchCarsBean(name);

        session.setAttribute("cars", carsbean);

        request.getRequestDispatcher("select.jsp").forward(request, response);
    }

}
