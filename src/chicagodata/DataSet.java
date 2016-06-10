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
public class DataSet {
    private Info meta;
    
    public String[] getCapita(){
        return meta.getCapita();
    }
    public String[] getNBs(){
        return meta.getNBs();
    }
    
    @Override
    public String toString(){
        return meta.toString();
    }
    
}
