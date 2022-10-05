package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.CustomerDto;

public class CustomersDAO extends SuperDAO {

    private PreparedStatement ps;

    public boolean addCustomer(CustomerDto customer) {
        String SQL = "INSERT INTO customers(customer_id,name,mail,postalCode,pref,address,birthday,mobile,pass,points) VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.connect();
            ps = con.prepareStatement(SQL);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getMail());
            ps.setString(3, customer.getPostalCode());
            ps.setString(4, customer.getPref());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getBirthday());
            ps.setString(7, customer.getMobile());
            ps.setString(8, customer.getPass());
            ps.setInt(9, customer.getPoints());

            System.out.println(ps.executeUpdate());

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            this.close(ps);
        }
        return true;
    }

    public CustomerDto getCustomer(String mail, String pass) {

        String SQL = "SELECT customer_id,name,mail,postalCode,pref,address,birthday,mobile,pass,points from customers where mail = ? and pass = ? ";

        CustomerDto customer = new CustomerDto();
        try {
            this.connect();

            ps = con.prepareStatement(SQL);

            ps.setString(1, mail);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            int cnt = 0;

            while (rs.next()) {
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setMail(rs.getString("mail"));
                customer.setPostalCode(rs.getString("postalCode"));
                customer.setPref(rs.getString("pref"));
                customer.setAddress(rs.getString("address"));
                customer.setBirthday(rs.getString("birthday"));
                customer.setMobile(rs.getString("mobile"));
                customer.setPass(rs.getString("pass"));
                customer.setPoints(rs.getInt("points"));
                cnt++;
            }

            if (cnt == 0) {
                return null;
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.close(ps);
        }
        return customer;
    }

    public boolean updateCustomer(CustomerDto customer) {

        String SQL = "UPDATE customers SET customer_id= ? ,name = ? ,mail = ? ,postalCode = ? ,pref = ? ,address = ? ,birthday = ?,mobile = ? ,pass = ? ,points= ? WHERE customer_id=?";
        try {
            this.connect();
            ps = con.prepareStatement(SQL);

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getMail());
            ps.setString(4, customer.getPostalCode());
            ps.setString(5, customer.getPref());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getBirthday());
            ps.setString(8, customer.getMobile());
            ps.setString(9, customer.getPass());
            ps.setInt(10, customer.getPoints());
            ps.setInt(11, customer.getCustomerId());

            System.out.println(ps.executeUpdate());
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            this.close(ps);
        }
        return true;
    }

    public static void main(String[] args) {

        CustomersDAO cd = new CustomersDAO();
        String id = "yuu@saycon.co.jp";
        String pass = "p";

        System.out.println(cd.getCustomer(id, pass));

        CustomerDto customer = new CustomerDto("水野", "mizuno@saycon.co.jp", "457-0001", "愛知", "桑名市", "2001-01-01", "090-0000-0000", "p");
//        cd.addCustomer(customer);
        customer.setCustomerId(113);
        cd.updateCustomer(customer);
    }

}
