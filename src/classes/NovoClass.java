/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author Dyel
 */
public class NovoClass {
    List<String> aux;
    List<String> aux2;
    
    public void setPropy(List<String> aux){     
        this.aux = aux;
    }
    
    public List<String> getPropy(){
        return aux;
    }
    
    public void setPropyEd(List<String> aux){     
        this.aux2 = aux;
    }
    
    public List<String> getPropyEd(){
        return aux2;
    }
}
