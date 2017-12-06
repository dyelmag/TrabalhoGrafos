/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import static Telas.testes.graph;
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dyel
 */
public class Teste2 {
    Graph graph;
    GDFReader qq;
    NovoClass nc;
    List<Vertex> vertL;
    List<Edge> aresL;
    Resutado[] res;
    perfil aux;
    /**
     * Creates new form Principal
     */
    public Teste2() {
        graph = new TinkerGraph();
        qq = new GDFReader();
        nc = new NovoClass();
    }
    
    public void tt(){
        InputStream inputstream;
        try {
            inputstream = new FileInputStream("C:\\Users\\Dyel\\Desktop\\Trabalho grafos\\prog\\AAAAA.gdf");
            GDFReader.inputGraph(graph, inputstream, nc);
            Iterator<Vertex> eitr = graph.getVertices().iterator();
            Iterator<Edge> qq1 = graph.getEdges().iterator();
            vertL = new ArrayList<>();
            while (eitr.hasNext()) {
                vertL.add(eitr.next());
            }
            aresL = new ArrayList<>();
            while (qq1.hasNext()) {
                aresL.add(qq1.next());
            }
            res = new Resutado[vertL.size()];
            aux = iniciaPerfil();
            pM();
            Arrays.sort(res, (Resutado b1, Resutado b2) -> {
                //TODO testar nulos
                if (b1.getNota() > b2.getNota()) {
                    return -1;
                }
                if (b1.getNota() < b2.getNota()) {
                    return 1;
                }
                return 0;
            });
            for (int i = 0; i < res.length; i++) {
                System.err.println("ID " + res[i].getId() + " | " + res[i].getNota());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static perfil iniciaPerfil() {
        perfil pf = new perfil();
        pf.setCidade("Bismarck");
        pf.setFilmes(new String[]{"Jurassic Park", "West Side Story", "Inception", "Star Wars", "Gladiator"});
        pf.setGames(new String[]{"Mario", "Sonic", "GTA"});
        pf.setGenero("Male");
        pf.setGrupos(new String[]{"Anime", "Film", "Usa"});
        pf.setMusica(new String[]{"1", "2", "5", "8"});
        pf.setOutros(new String[]{"Bugginho Developer", "NIHON SEKAI", " Weeaboo-chan"});
        pf.setRelacionamento("Single");
        return pf;
    }
    
    public static boolean useLoop(Resutado[] arr, String targetValue) {
        for (Resutado s: arr) {
            try{
                if (s.getId().equals(targetValue))
                    return true;
            }catch(Exception e){
                return false;
            }
        }
        return false;
    } 
    
    public List<String> listAdj(String no) {
        List<String> lista = new ArrayList<>();
        Iterator<Edge> aux1 = aresL.iterator();
        Edge aux2;
        while (aux1.hasNext()) {
            aux2 = aux1.next();
            if (aux2.getProperty("node1").equals(no)) {
                lista.add(aux2.getProperty("node2"));
            }
        }
        return lista;
    }
    public void pM(){
        for(int i = 0 ; i < vertL.size() ; i++){
            Resutado r = new Resutado();
            r.setId(vertL.get(i).getProperty("name"));
            r.setNota(Nota(vertL.get(i)));
            res[i] = r;
        }
    }
    
    
    public int Nota(Vertex v) {
        int nota = 0;
        try {
            for (String musica : aux.getMusica()) {
                if (v.getProperty("music").toString().toLowerCase().contains(musica.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            for (String filmes : aux.getFilmes()) {
                if (v.getProperty("movies").toString().toLowerCase().contains(filmes.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            if (v.getProperty("current_city").toString().toLowerCase().contains(aux.getCidade().toLowerCase())) {
                nota++;
            }
        } catch (Exception E) {

        }
        try {
            for (String games : aux.getGames()) {
                if (v.getProperty("games").toString().toLowerCase().contains(games.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getGrupos()) {
                if (v.getProperty("groups").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }

            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getOutros()) {

                if (v.getProperty("other").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getRestaurantes()) {
                if (v.getProperty("restaurants").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }

            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getTv()) {
                if (v.getProperty("television").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        return nota;
    }
    

}


/*

    public List<String> listAdj(String no) {
        List<String> lista = new ArrayList<>();
        Iterator<Edge> aux1 = aresL.iterator();
        Edge aux2;
        while (aux1.hasNext()) {
            aux2 = aux1.next();
            if (aux2.getProperty("node1").equals(no)) {
                lista.add(aux2.getProperty("node2"));
            }
        }
        return lista;
    }/*
    public Vertex bv(String name){
        //Vertex v = new Vertex
    }*/
    /*
    public void bp(String no){
        System.err.println(""+busca2(no));
        if(!useLoop(res, no)){
            Nota(busca2(no));
            List<String> ll = listAdj(no);
            for(int a = 0 ; a < ll.size() ; a++){
                ii++;
                bp(ll.get(a));
            }
        }
    }
    */
    

    /*
     public void buscaProf(String no, int i){       
        List<String> lt = listAdj(no);
        for (String lt1 : lt) {
            if(!res.equals(no)){
                res[i] =
                
            }
            int cont = 0;
            for(int j = 0 ; j < res.size() ; j++){
                if(lt1.equalsIgnoreCase(res.get(j).getId())){
                     cont++;
                 }
            }
            if(cont == 0){
                Resutado res1 = new Resutado();
                res1.setId(no);
                res.add(res1);
                buscaProf(lt1);
            }            
        }
     }
    public void Nota(Vertex v) {
        int nota = 0;
        Resutado rr = new Resutado();
        try {
            for (String musica : aux.getMusica()) {
                if (v.getProperty("music").toString().toLowerCase().contains(musica.toLowerCase())) {
                    nota++;
                }

            }
        } catch (Exception E) {

        }
        try {
            for (String filmes : aux.getFilmes()) {
                if (v.getProperty("movies").toString().toLowerCase().contains(filmes.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            if (v.getProperty("current_city").toString().toLowerCase().contains(aux.getCidade().toLowerCase())) {
                nota++;
            }
        } catch (Exception E) {

        }
        try {
            for (String games : aux.getGames()) {
                if (v.getProperty("games").toString().toLowerCase().contains(games.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getGrupos()) {
                if (v.getProperty("groups").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }

            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getOutros()) {

                if (v.getProperty("other").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getRestaurantes()) {
                if (v.getProperty("restaurants").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }

            }
        } catch (Exception E) {

        }
        try {
            for (String auxx : aux.getTv()) {
                if (v.getProperty("television").toString().toLowerCase().contains(auxx.toLowerCase())) {
                    nota++;
                }
            }
        } catch (Exception E) {

        }
        rr.setId(v.getProperty("name").toString());
        rr.setNota(nota);
        res[ii] = rr;
    }

    public void busca2() {
        System.out.println("asdasd"+ii);
        for (int i = 0; i < vertL.size(); i++) {
            Iterator<Vertex> oo = vertL.get(i).getVertices(Direction.OUT, "name").iterator();
            while (oo.hasNext()) {
                Nota(oo.next());
                ii++;
                System.out.println("a"+ii);
            }
        }
    }


*/