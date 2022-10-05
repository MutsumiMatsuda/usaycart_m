import model.dto.CarDto;
import model.dto.CustomerDto;
import model.dto.SalesDto;
import model.dto.SalesesDto;
import util.SerializableArrayList;

public final class SimpleTest {
	public static void main(String[] args) {
		
		//testSalesesBean();
		testCarsArrayList();

	}

	public static void testSalesesBean() {
		SalesesDto s = new SalesesDto();

		CarDto car = new CarDto("minicar", 100);
		CustomerDto customer = new CustomerDto("yama", "yuu", "457-0001", "aichi", "nagoya", "1969-11-09", "090-5629-1212", "9");
		String date = "2022-06-18";
		SalesDto sale = new SalesDto(1, car, customer, date);
		s.addSale(sale);

		System.out.println(s);
	}
	
	public static void testCarsArrayList() {
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
        
        SerializableArrayList<CarDto> cb = new SerializableArrayList<CarDto>();
        cb.add(c2);
        cb.add(c1);
        
        System.out.println(cb);
	}
}


