package model.dto;

//import java.io.Serializable;

public class SalesDto {

    private int saleId;
    private CarDto car;
    private CustomerDto customer;
    private String saleDateTime;

    public SalesDto() {
        super();
    }

    public SalesDto(int saleId, CarDto car, CustomerDto customer, String saleDateTime) {
        this.saleId = saleId;
        this.car = car;
        this.customer = customer;
        this.saleDateTime = saleDateTime;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public String getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(String saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    @Override
    public String toString() {
        return "SalesBean{" + "saleId=" + saleId + ", car=" + car + ", customer=" + customer + ", saleDateTime=" + saleDateTime + '}';
    }
    
    public static void main(String[] args) {
        CarDto car = new CarDto("minicar",100);
        CustomerDto customer = new CustomerDto("yama", "yuu@saycon.co.jp", "460-1111", "愛知", "名古屋市", "1969-11-09", "090-2345-6789", "p");
        
        System.out.println(car);
        System.out.println(customer);
            
    }

}
