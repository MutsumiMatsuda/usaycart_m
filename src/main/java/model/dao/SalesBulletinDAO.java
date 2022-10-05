package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.CarDto;
import model.dto.CustomerDto;
import model.dto.SalesDto;
import model.dto.SalesesDto;

public class SalesBulletinDAO extends SuperDAO {

    private PreparedStatement ps;

    public SalesesDto getSalesesBean() {

        SalesesDto saleses = new SalesesDto();
        this.connect();

        String SQL = "SELECT saleDateTime, cars.name,  pref, address, customers.name, price FROM sales JOIN customers ON sales.customer_id = customers.customer_id JOIN cars ON sales.car_id = cars.car_id GROUP BY customers.pref, cars.name ORDER BY saleDateTime DESC;";
        try {
            ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SalesDto sales = new SalesDto();
                CarDto car = new CarDto();
                CustomerDto customer = new CustomerDto();
                
                sales.setSaleDateTime(rs.getString("saleDateTime"));
                car.setName(rs.getString("cars.name"));
                customer.setPref(rs.getString(3));
                customer.setAddress(rs.getString("address"));
                customer.setName(rs.getString("customers.name"));
                car.setPrice(rs.getInt("price"));
                
                sales.setCar(car);
                sales.setCustomer(customer);
                saleses.addSale(sales);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return saleses;
    }
    
    public static void main(String[] args) {
        SalesBulletinDAO sales = new SalesBulletinDAO();
        System.out.println(sales.getSalesesBean());
    }

}
