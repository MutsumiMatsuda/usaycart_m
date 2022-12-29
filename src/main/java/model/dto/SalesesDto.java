package model.dto;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalesesDto {

  private List<SalesDto> saleArrayList = new ArrayList<>();

  public SalesesDto() {
  }

  public List<SalesDto> getSaleArrayList() {
    return saleArrayList;
  }

  public void setSaleArrayList(List<SalesDto> saleArrayList) {
    this.saleArrayList = saleArrayList;
  }

  public void addSale(SalesDto aSale) {
    this.saleArrayList.add(aSale);
  }

  public int getSalesSize() {
    return this.saleArrayList.size();
  }

  @Override
  public String toString() {
    return "SalesesBean{" + "saleArrayList=" + saleArrayList + '}';
  }
}
