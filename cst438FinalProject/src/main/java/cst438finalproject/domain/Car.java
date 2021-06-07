package cst438finalproject.domain;

public class Car
{
   private String type;
   private String location;
   private String price;
   
   public Car() { }
   
   public Car(String type, String location, String price) {
      this.type = type;
      this.location = location;
      this.price = price;
   }
   
   public String getType() {
      return type;
   }
   
   public void setType(String type) {
      this.type = type;
   }
   
   public String getLocation() {
      return location;
   }
   
   public void setLocation(String location) {
      this.location = location;
   }
   
   public String getPrice() {
      return price;
   }
   
   public void setPrice(String price) {
      this.price = price;
   }
}
