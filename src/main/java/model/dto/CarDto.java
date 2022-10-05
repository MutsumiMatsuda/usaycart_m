package model.dto;

import java.io.Serializable;

public class CarDto implements Serializable{
        private int carId;
	private String name;
	private int price;
        private String endOfLifeDates;
        
	public CarDto() {
		super();

        }
	public CarDto(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEndOfLifeDates() {
        return endOfLifeDates;
    }

    public void setEndOfLifeDates(String endOfLifeDates) {
        this.endOfLifeDates = endOfLifeDates;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", name=" + name + ", price=" + price + ", endOfLifeDates=" + endOfLifeDates + '}';
    }     


}

