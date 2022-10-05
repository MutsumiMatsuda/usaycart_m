package util;

import model.dto.CarDto;
import model.dto.CartDto;

public class CartLogic {

    public void execute(CartDto cart, CarDto car) {
        cart.getList().add(car);
        cart.setTotal(cart.getTotal() + car.getPrice());
    }
}
