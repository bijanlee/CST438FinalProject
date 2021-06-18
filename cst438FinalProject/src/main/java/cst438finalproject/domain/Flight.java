package cst438finalproject.domain;

public class Flight
{
   private String flightNum;
   private int airlineID;
   private String leaveTime;
   private String leaveDate;
   private String arriveTime;
   private String arriveDate;
   private int price;
   private int numStops;
   private int seatsAvailable;
   private int originCity;
   private int destCity;
   private String originAirport;
   private String destAirport;
   
   
   public Flight() {}
   
   public Flight(String flightNum, int airlineID, String leaveTime, String leaveDate, String arriveTime, String arriveDate,
         int price, int numStops, int seatsAvailable, int originCity, int destCity, String originAirport,
         String destAirport)
   {
      super();
      this.flightNum = flightNum;
      this.airlineID = airlineID;
      this.leaveTime = leaveTime;
      this.leaveDate = leaveDate;
      this.arriveTime = arriveTime;
      this.arriveDate = arriveDate;
      this.price = price;
      this.numStops = numStops;
      this.seatsAvailable = seatsAvailable;
      this.originCity = originCity;
      this.destCity = destCity;
      this.originAirport = originAirport;
      this.destAirport = destAirport;
   }
   
   public String getFlightNum()
   {
      return flightNum;
   }

   public void setFlightNum(String flightNum)
   {
      this.flightNum = flightNum;
   }

   public int getAirlineID()
   {
      return airlineID;
   }

   public void setAirlineID(int airlineID)
   {
      this.airlineID = airlineID;
   }

   public String getLeaveTime()
   {
      return leaveTime;
   }

   public void setLeaveTime(String leaveTime)
   {
      this.leaveTime = leaveTime;
   }

   public String getLeaveDate()
   {
      return leaveDate;
   }

   public void setLeaveDate(String leaveDate)
   {
      this.leaveDate = leaveDate;
   }

   public String getArriveTime()
   {
      return arriveTime;
   }

   public void setArriveTime(String arriveTime)
   {
      this.arriveTime = arriveTime;
   }

   public String getArriveDate()
   {
      return arriveDate;
   }

   public void setArriveDate(String arriveDate)
   {
      this.arriveDate = arriveDate;
   }

   public int getPrice()
   {
      return price;
   }

   public void setPrice(int price)
   {
      this.price = price;
   }

   public int getNumStops()
   {
      return numStops;
   }

   public void setNumStops(int numStops)
   {
      this.numStops = numStops;
   }

   public int getSeatsAvailable()
   {
      return seatsAvailable;
   }

   public void setSeatsAvailable(int seatsAvailable)
   {
      this.seatsAvailable = seatsAvailable;
   }

   public int getOriginCity()
   {
      return originCity;
   }

   public void setOriginCity(int originCity)
   {
      this.originCity = originCity;
   }

   public int getDestCity()
   {
      return destCity;
   }

   public void setDestCity(int destCity)
   {
      this.destCity = destCity;
   }

   public String getOriginAirport()
   {
      return originAirport;
   }

   public void setOriginAirport(String originAirport)
   {
      this.originAirport = originAirport;
   }

   public String getDestAirport()
   {
      return destAirport;
   }

   public void setDestAirport(String destAirport)
   {
      this.destAirport = destAirport;
   }


   
}
