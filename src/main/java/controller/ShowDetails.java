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
import model.dto.CarsDto;

@WebServlet("/ShowDetails")
public class ShowDetails extends HttpServlet {

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
        CarDto car = carsbean.getCarArrayList().get(0);

        session.setAttribute("car", car);

        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

}
