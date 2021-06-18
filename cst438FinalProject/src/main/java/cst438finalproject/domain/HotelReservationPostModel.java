package cst438finalproject.domain;

public class HotelReservationPostModel
{
   private int hotelId;
   private String roomtype;
   private String startdate;
   private String enddate;
   
   public HotelReservationPostModel() {}
   
   public HotelReservationPostModel(int hotelId, String roomtype, String startdate, String enddate)
   {
      this.hotelId = hotelId;
      this.roomtype = roomtype;
      this.startdate = startdate;
      this.enddate = enddate;
   }

   public int getHotelId()
   {
      return hotelId;
   }

   public void setHotelId(int hotelId)
   {
      this.hotelId = hotelId;
   }

   public String getRoomtype()
   {
      return roomtype;
   }

   public void setRoomtype(String roomtype)
   {
      this.roomtype = roomtype;
   }

   public String getStartdate()
   {
      return startdate;
   }

   public void setStartdate(String startdate)
   {
      this.startdate = startdate;
   }

   public String getEnddate()
   {
      return enddate;
   }

   public void setEnddate(String enddate)
   {
      this.enddate = enddate;
   }
}
