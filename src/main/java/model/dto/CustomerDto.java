package model.dto;

//import java.io.Serializable;

public class CustomerDto {

    private int customerId;
    private String name;
    private String mail;
    private String postalCode;
    private String pref;
    private String address;
    private String birthday;
    private String mobile;
    private String pass;
    private int points;

    public CustomerDto() {
    }

    public CustomerDto(String name, String mail, String postalCode, String pref, String address, String birthday, String mobile, String pass) {
        this.name = name;
        this.mail = mail;
        this.postalCode = postalCode;
        this.pref = pref;
        this.address = address;
        this.birthday = birthday;
        this.mobile = mobile;
        this.pass = pass;
        this.points = 100;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", name=" + name + ", mail=" + mail + ", postalCode=" + postalCode + ", pref=" + pref + ", address=" + address + ", birthday=" + birthday + ", mobile=" + mobile + ", pass=" + pass + ", points=" + points + '}';
    }
    
    


    
    public static void main(String[] args) {
        CustomerDto c = new CustomerDto("今井克哉","imai@saycon.co.jp","460-0001","愛知県","名古屋市千種区","1969-11-09","090-0000-0000","p");
        
        System.out.println(c);
        
        System.out.println(c.getName());
                
    }


}
