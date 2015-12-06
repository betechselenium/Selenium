package java.betech.nyc;

class Human{
	   public void eat()
	   {
	      System.out.println("Human is eating");
	   }
	}
	class Boy extends Human{
	   public void eat(){
	      System.out.println("Boy is eating");
	   }
	   public static void main( String args[]) {
	      Boy obj = new Boy();
	      obj.eat();
	   }
	}
	 
	//////////////////////////////
	 
	class ABC{
	   public void disp()
	   {
	      System.out.println("disp() method of parent class");
	   }
	   public void abc()
	   {
	      System.out.println("abc() method of parent class");
	   }     
	}
	class PolymorphismOverriding extends ABC{
	   public void disp(){
	      System.out.println("disp() method of Child class");
	   }
	   public void xyz(){
	      System.out.println("xyz() method of Child class");
	   }
	   public static void main( String args[]) {
	      //Parent class reference to child class object
	      ABC obj = new PolymorphismOverriding();
	      obj.disp();
	      obj.abc();
	   }
	}
