package cst438finalproject.domain;

public class Flight
{
   private String time;
   private String sourceLocation;
   private String destinationLocation;
   private String price;
   
   public Flight() {}
   
   public Flight(String time, String sourceLocation, String destinationLocation, String price) {
      this.time = time;
      this.sourceLocation = sourceLocation;
      this.destinationLocation = destinationLocation;
      this.price = price;
   }
   
   public String getTime() {
      return time;
   }
   
   public void setTime(String time) {
      this.time = time;
   }
   
   public String getSourceLocation() {
      return sourceLocation;
   }
   
   public void setSourceLocation(String sourceLocation) {
      this.sourceLocation = sourceLocation;
   }
   
   public String getDestinationLocation() {
      return this.destinationLocation;
   }
   
   public void setDestinationLocation(String destinationLocation) {
      this.destinationLocation = destinationLocation;
   }
   
   public String getPrice() {
      return price;
   }
   
   public void setPrice(String price) {
      this.price = price;
   }
}
