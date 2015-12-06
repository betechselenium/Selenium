package java.betech.nyc;

import java.util.*;
 
public class ArrayListDemo {
   public static void main(String args[]) {
      /*Creation of ArrayList: I'm going to add String
       *elements so I made it of string type */
      ArrayList<String> obj = new ArrayList<String>();
 
      /*This is how elements should be added to the array list*/
      obj.add("Ammar");
      obj.add("Messi");
      obj.add("Ronaldo");
      obj.add("Steve");
      obj.add("Gates");
 
      /* Displaying array list elements */
      System.out.println("Currently the array list has following elements:"+obj);
 
      /*Add element at the given index*/
      obj.add(0, "Rahul");
      obj.add(1, "Justin");
 
      /*Remove elements from array list like this*/
      obj.remove("Ronaldo");
      obj.remove("Gates");
 
      System.out.println("Current array list is:"+obj);
 
      /*Remove element from the given index*/
      obj.remove(1);
 
      System.out.println("Current array list is:"+obj);
   }
}