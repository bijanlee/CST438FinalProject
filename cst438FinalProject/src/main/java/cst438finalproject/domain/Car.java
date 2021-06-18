package cst438finalproject.domain;

public class Car
{
   private int id;
   private String brand;
   private String model;
   private String color;
   private int year;
   private String description;
   private int carTypeId;
   private int locationId;

   
   public Car() { }
   
   public Car(int id, String brand, String model, String color, int year, 
         String description, int carTypeId, int locationId) {
      this.setId(id);
      this.setBrand(brand);
      this.setModel(model);
      this.setColor(color);
      this.setYear(year);
      this.setDescription(description);
      this.setCarTypeId(carTypeId);
      this.setLocationId(locationId);
   }

   public String getBrand()
   {
      return brand;
   }

   public void setBrand(String brand)
   {
      this.brand = brand;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getModel()
   {
      return model;
   }

   public void setModel(String model)
   {
      this.model = model;
   }

   public String getColor()
   {
      return color;
   }

   public void setColor(String color)
   {
      this.color = color;
   }

   public int getYear()
   {
      return year;
   }

   public void setYear(int year)
   {
      this.year = year;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public int getCarTypeId()
   {
      return carTypeId;
   }

   public void setCarTypeId(int carTypeId)
   {
      this.carTypeId = carTypeId;
   }

   public int getLocationId()
   {
      return locationId;
   }

   public void setLocationId(int locationId)
   {
      this.locationId = locationId;
   }
   
   

}
