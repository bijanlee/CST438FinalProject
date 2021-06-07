package cst438finalproject.domain;

public class Hotel
{
   private String name;
   private String price;
   private String location;
   
   public Hotel() { }
   
   public Hotel(String name, String price, String location) {
      this.name = name;
      this.price = price;
      this.location = location;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getPrice() {
      return price;
   }
   
   public void setPrice(String price) {
      this.price = price;
   }
   
   public String getLocation() {
      return location;
   }
   
   public void setLocation(String location) {
      this.location = location;
   }
}
