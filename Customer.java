package application;

public class Customer {
	
	private Integer id;
    private String name;
    private String phone;
    
     Integer get_id()
     {return id;}
     String getName()
     {return name;}
     String getPhone()
     {return phone;}
     
      void setid(int id)
         {this.id=id;}
      void setname(String name)
         {this.name=name;}
      void setPhone(String phone)
         {this.phone=phone;}

     Customer(int id,String name,String phone)
     {
    	  this.id=id;
    	  this.name=name;
    	  this.phone=phone;
    	  
     }
}
