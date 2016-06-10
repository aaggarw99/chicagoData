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
public class Info {
    private moreInfo view;
    
    public String[] getCapita(){
        return view.getCapita();
    }
    public String[] getNBs(){
        return view.getNBs();
    }
     @Override
     public String toString(){
         return view.toString();
     }
}
