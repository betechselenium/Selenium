package java.betech.nyc;

class ConstructorDemo
{
      private int var;
      public ConstructorDemo()
      {
             //code for default one
             var = 10;
      }
      public ConstructorDemo(int num)
      {
             //code for parameterized one
             var = num;
      }
      public int getValue()
      {
              return var;
      }
      public static void main(String args[])
      {
              ConstructorDemo constructorDemo = new ConstructorDemo();
              System.out.println("var is: "+constructorDemo.getValue());
      }
}