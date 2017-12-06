/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import classes.GDFReader;
import classes.NovoClass;
import classes.Resutado;
import classes.perfil;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dyel
 */
public class testes {

    static Graph graph;
    static GDFReader qq;
    static NovoClass nc;
    static List<Vertex> vertL;
    static List<Edge> aresL;
    static Resutado[] res;
    static perfil aux;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Teste2 aa = new Teste2();
        aa.tt();
    }
}
