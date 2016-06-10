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
public class moreInfo {
    private DataPoint[] columns;
    private String all;
    
    public String[] getNBs(){
        return columns[9].getItems();
    }
    public String[] getCapita(){
        return columns[15].getItems();
    }
    @Override
    public String toString(){
        all += columns[9].toString();
        all += columns[15].toString();
        return all;
    }
}
