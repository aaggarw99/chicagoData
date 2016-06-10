/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicagodata;

/**
 *
 * @author Ashwin
 */
public class Items {
    private int count;
   private String item;
   public int getCount(){
       return count;
   }
   public String getItem(){
       return item;
   }
   
   
   @Override
   public String toString(){
       return ("NB number is " + Integer.toString(count) + ": " + item);
   }
}
