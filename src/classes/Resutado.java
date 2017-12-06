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
public class Resutado {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    private String id;
    private int nota;
    private List<String> comun;

    public List<String> getComun() {
        return comun;
    }

    public void setComun(List<String> comun) {
        this.comun = comun;
    }
    
}
