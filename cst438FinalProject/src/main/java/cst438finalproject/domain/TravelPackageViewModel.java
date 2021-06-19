package cst438finalproject.domain;

public class TravelPackageViewModel
{
   private Hotel hotel;
   private Flight flight;
   private Car car;
   int packageId;
   
   public TravelPackageViewModel(Hotel hotel, Flight flight, Car car, int packageId)
   {
      super();
      this.hotel = hotel;
      this.flight = flight;
      this.car = car;
      this.packageId = packageId;
   }
   public Hotel getHotel()
   {
      return hotel;
   }
   public void setHotel(Hotel hotel)
   {
      this.hotel = hotel;
   }
   public Flight getFlight()
   {
      return flight;
   }
   public void setFlight(Flight flight)
   {
      this.flight = flight;
   }
   public Car getCar()
   {
      return car;
   }
   public void setCar(Car car)
   {
      this.car = car;
   }
   
   public int getPackageId()
   {
      return packageId;
   }
   public void setPackageId(int packageId)
   {
      this.packageId = packageId;
   }
   
   
}
