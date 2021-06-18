package cst438finalproject.domain;

public class Hotel
{
   private int id;
   private String name;
   private int price;
   private String address;
   private int stars;
   private String city;
   
   public Hotel() { }
   
   public Hotel(int id, String name, int price, String address, int stars, String city) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.address = address;
      this.stars = stars;
      this.city = city;
   }
   
   public int getId() {
      return this.id;
   }
   
   public void setId(int id) {
      this.id = id;
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
   
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String address) {
      this.address = address;
   }
   
   public int getStars() {
      return stars;
   }
   
   public void setStars(int stars) {
      this.stars = stars;
   }
   
   public String getCity() {
      return city;
   }
   
   public void setCity(String city) {
      this.city = city;
   }
}
