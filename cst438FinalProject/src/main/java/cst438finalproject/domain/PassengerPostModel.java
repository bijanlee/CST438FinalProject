package cst438finalproject.domain;

public class PassengerPostModel
{
   private String firstName;
   private String lastName;
   private String flightNum;
   
   public PassengerPostModel(String firstName, String lastName, String flightNum)
   {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.flightNum = flightNum;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getFlightNum()
   {
      return flightNum;
   }

   public void setFlightNum(String flightNum)
   {
      this.flightNum = flightNum;
   }
   
   
}
