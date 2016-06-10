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
public class contain {
    private Items[] top;
    
    public String all = "";
    
    public String[] getItems(){
        String[] temp = new String[top.length];
        for (int i = 0; i < temp.length; i++){
            temp[i] = top[i].getItem();
            
        }
        return temp;
    }
    
    @Override
    public String toString(){
        for(int i=0;i<=18;i++){
            all += "\n" + top[i].toString();
            
        }
        all += "\n" + top[19].toString() + "\n \n";
        return all;
    }
}
