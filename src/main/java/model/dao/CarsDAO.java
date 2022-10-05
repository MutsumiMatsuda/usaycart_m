package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.CarDto;
import model.dto.CarsDto;

public class CarsDAO extends SuperDAO {

    private PreparedStatement ps;

    public int countCarsBean() {

        int ret = 0;

        this.connect();

        String SQL = "SELECT count(*) FROM cars";
        try {
            ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            rs.next();

            ret = rs.getInt("count(*)");

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return ret;
    }

    public CarsDto getCarsBean() {

        CarsDto carsBean = new CarsDto();
        this.connect();

        String SQL = "SELECT * FROM cars";
        try {
            ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CarDto car = new CarDto();
                car.setCarId(rs.getInt("car_id"));
                car.setName(rs.getString("name"));
                car.setPrice(rs.getInt("price"));
                car.setEndOfLifeDates("end_of_life_dates");
                carsBean.addCar(car);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return carsBean;
    }

    public CarsDto searchCarsBean(String keyword) {

        CarsDto carsBean = new CarsDto();
        this.connect();

        String SQL = "select * from cars where name like ?";

        try {
            ps = con.prepareStatement(SQL);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CarDto car = new CarDto();
                car.setCarId(rs.getInt("car_id"));
                car.setName(rs.getString("name"));
                car.setPrice(rs.getInt("price"));
                car.setEndOfLifeDates("end_of_life_dates");
                carsBean.addCar(car);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return carsBean;

    }

    public CarDto getACar(String id) {

        CarDto car = new CarDto();
        this.connect();

        String SQL = "select * from cars where car_id = ?";

        try {
            ps = con.prepareStatement(SQL);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            rs.next();

            car.setCarId(rs.getInt("car_id"));
            car.setName(rs.getString("name"));
            car.setPrice(rs.getInt("price"));
            car.setEndOfLifeDates("end_of_life_dates");

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return car;

    }

    public int addACar(CarDto aCar) {
        int ret = 0;
        this.connect();
        String SQL = "INSERT INTO cars(car_id, name, price,end_of_life_dates) VALUES(null, ?, ?, ?)";
        try {
            ps = con.prepareStatement(SQL);

            ps.setString(1, aCar.getName());
            ps.setInt(2, aCar.getPrice());
            ps.setString(3, aCar.getEndOfLifeDates());
            
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return ret;
    }

    public int updateACar(CarDto aCar) {
        int ret = 0;
        this.connect();
        String SQL = SQL = "UPDATE cars SET name = ?, price = ?, end_of_life_dates = ? WHERE car_id = ?";;
        try {
            ps = con.prepareStatement(SQL);

            ps.setString(1, aCar.getName());
            ps.setInt(2, aCar.getPrice());
            ps.setString(3, aCar.getEndOfLifeDates());
            ps.setInt(4, aCar.getCarId());
            
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return ret;
    }


    public static void main(String[] args) {
        CarsDAO carsdao = new CarsDAO();

        System.out.println(carsdao.countCarsBean());

        System.out.println(carsdao.searchCarsBean("車"));
        
        System.out.println(carsdao.getACar("1"));
        
        CarDto car = new CarDto("USJ",123456);
        
        System.out.println(carsdao.addACar(car));
        
        car.setCarId(22);
        car.setEndOfLifeDates("2022-01-01");
        
        System.out.println(carsdao.updateACar(car));
    }

}
