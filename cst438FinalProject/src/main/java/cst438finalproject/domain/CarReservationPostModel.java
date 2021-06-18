package cst438finalproject.domain;

public class CarReservationPostModel
{
   private String pickupDateTime;
   private String returnDateTime;
   private int pickupLocationId;
   private int returnLocationId;
   private int userId;
   private int carId;
   
   public CarReservationPostModel() {}
   
   public CarReservationPostModel(String pickupDateTime, String returnDateTime, int pickupLocationId,
         int returnLocationId, int userId, int carId)
   {
      super();
      this.pickupDateTime = pickupDateTime;
      this.returnDateTime = returnDateTime;
      this.pickupLocationId = pickupLocationId;
      this.returnLocationId = returnLocationId;
      this.userId = userId;
      this.carId = carId;
   }

   public String getPickupDateTime()
   {
      return pickupDateTime;
   }

   public void setPickupDateTime(String pickupDateTime)
   {
      this.pickupDateTime = pickupDateTime;
   }

   public String getReturnDateTime()
   {
      return returnDateTime;
   }

   public void setReturnDateTime(String returnDateTime)
   {
      this.returnDateTime = returnDateTime;
   }

   public int getPickupLocationId()
   {
      return pickupLocationId;
   }

   public void setPickupLocationId(int pickupLocationId)
   {
      this.pickupLocationId = pickupLocationId;
   }

   public int getReturnLocationId()
   {
      return returnLocationId;
   }

   public void setReturnLocationId(int returnLocationId)
   {
      this.returnLocationId = returnLocationId;
   }

   public int getUserId()
   {
      return userId;
   }

   public void setUserId(int userId)
   {
      this.userId = userId;
   }

   public int getCarId()
   {
      return carId;
   }

   public void setCarId(int carId)
   {
      this.carId = carId;
   }
   
   
   
}
