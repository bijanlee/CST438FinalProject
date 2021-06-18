package cst438finalproject.domain;

public class Location
{
   private int id;
   private String street;
   private String city;
   private String state;
   private String country;
   private int zipcode;
   private String phone;
   private double tax;
   
   public Location() {}
 
   public Location(int id, String street, String city, String state, String country,
         int zipcode, String phone, double tax)
   {
      this.setId(id);
      this.setStreet(street);
      this.setCity(city);
      this.setState(state);
      this.setCountry(country);
      this.setZipcode(zipcode);
      this.setPhone(phone);
      this.setTax(tax);
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getStreet()
   {
      return street;
   }

   public void setStreet(String street)
   {
      this.street = street;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   public String getState()
   {
      return state;
   }

   public void setState(String state)
   {
      this.state = state;
   }

   public String getCountry()
   {
      return country;
   }

   public void setCountry(String country)
   {
      this.country = country;
   }

   public int getZipcode()
   {
      return zipcode;
   }

   public void setZipcode(int zipcode)
   {
      this.zipcode = zipcode;
   }

   public String getPhone()
   {
      return phone;
   }

   public void setPhone(String phone)
   {
      this.phone = phone;
   }

   public double getTax()
   {
      return tax;
   }

   public void setTax(double tax)
   {
      this.tax = tax;
   }

}
