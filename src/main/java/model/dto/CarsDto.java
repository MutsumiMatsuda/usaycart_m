package model.dto;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//public class CarsBean implements Serializable {
public class CarsDto {

    private List<CarDto> carArrayList = new ArrayList<>();

    public CarsDto() {
    }

    public List<CarDto> getCarArrayList() {
        return carArrayList;
    }

    public void setCarArrayList(List<CarDto> carArrayList) {
        this.carArrayList = carArrayList;
    }

    public void addCar(CarDto aCar) {
        this.carArrayList.add(aCar);
    }
    
    public int getCarsSize() {
        return this.carArrayList.size();
    }
    

    @Override
    public String toString() {
        return "CarsBean{" + "carArrayList=" + carArrayList + '}';
    }
    
     public static void main(String[] args) {
         
         CarDto c1 = new CarDto();
         c1.setCarId(1);
         c1.setName("harry");
         c1.setPrice(100000);
         c1.setEndOfLifeDates(null);
         
         CarDto c2 = new CarDto();
         c2.setCarId(2);
         c2.setName("spider");
         c2.setPrice(10);
         c2.setEndOfLifeDates(null);
         
         CarsDto cb = new CarsDto();
         cb.addCar(c2);
         cb.addCar(c1);
         
         System.out.println(cb);

    }

}
