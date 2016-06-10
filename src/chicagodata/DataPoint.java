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
public class DataPoint {
    private String name;
    private contain cachedContents;
    private int position;
    
    public String[] getItems(){
        return cachedContents.getItems();
    }
 
    @Override
    public String toString(){
        return name + "\n" + cachedContents.toString();
    }
}
