package cst438finalproject.domain;

public class CarType
{
   private int id;
   private String name;
   private int passengerCount;
   private int airbagCount;
   private String transmission;
   private double price;
   private String description;
   
   public CarType() {}
   
   public CarType(int id, String name, int passengerCount, int airbagCount,
         String transmission, double price, String description)
   {
      this.setId(id);
      this.setName(name);
      this.setPassengerCount(passengerCount);
      this.setAirbagCount(airbagCount);
      this.setTransmission(transmission);
      this.setPrice(price);
      this.setDescription(description);
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public int getPassengerCount()
   {
      return passengerCount;
   }

   public void setPassengerCount(int passengerCount)
   {
      this.passengerCount = passengerCount;
   }

   public int getAirbagCount()
   {
      return airbagCount;
   }

   public void setAirbagCount(int airbagCount)
   {
      this.airbagCount = airbagCount;
   }

   public String getTransmission()
   {
      return transmission;
   }

   public void setTransmission(String transmission)
   {
      this.transmission = transmission;
   }

   public double getPrice()
   {
      return price;
   }

   public void setPrice(double price)
   {
      this.price = price;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }
   
   
}
