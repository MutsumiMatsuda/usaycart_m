package model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartDto implements Serializable{
	private List<CarDto> list;
	private int total;
	public CartDto() {
		super();
		list=new ArrayList<>();
		total=0;
	}

	public List<CarDto> getList() {
		return list;
	}
	public void setList(List<CarDto> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}