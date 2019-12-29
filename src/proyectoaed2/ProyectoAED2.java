/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaed2;

import java.util.Iterator;
import grafo.*;
import java.util.ArrayList;

/**
 *
 * @author danid
 */
public class ProyectoAED2 {

    
    public static <E> Mapa<Vertice<E>,String> colorearMapa (Grafo<E,Integer> g,
    String [] colores){
        Mapa<Vertice<E>, String> toret = new HashMap<>();
        Iterator <Vertice<E>> iterVert = g.vertices();
        while(iterVert.hasNext()){
            Vertice<E> vActual = iterVert.next();
            toret.insertar(vActual, "");
        }
        iterVert=g.vertices();
        while(iterVert.hasNext()){
            Vertice<E> vActual = iterVert.next();
            String color = escogerColor(colores, g, vActual, toret);
            toret.insertar(vActual, color);
        }
        return toret;
    }
    
    private static <E> String escogerColor(String[] colores, Grafo<E,Integer> g, Vertice<E> v,
    Mapa<Vertice<E>,String> mapaColor){
        Iterator <Vertice<E>> iter = g.adyacentes(v);
        int i=0;
        while(iter.hasNext()){
            Vertice<E> vActual = iter.next();
            if(mapaColor.get(vActual).equals(colores[i])){
                i++;
                iter = g.adyacentes(v);
            }
        }
        return colores[i];
    }
    
    
    public static <E> Mapa<Vertice<E>,Integer> dijkstra(Grafo<E, Integer> g, Vertice<E> v){
        Mapa<Vertice<E>, Integer> toret = new HashMap<>();
        ArrayList <Vertice<E>> porVisitar = new ArrayList<>();
        
        Iterator <Vertice<E>> iterVer = g.vertices();
        Vertice<E> actual;
        
        while (iterVer.hasNext()){
            actual = iterVer.next();
            toret.insertar(actual, Integer.MAX_VALUE);
            porVisitar.add(actual);
        }
        toret.insertar(v, 0);
        
        while (!porVisitar.isEmpty()){
            actual = distanciaMinima(toret, porVisitar);
            porVisitar.remove(actual);
            
            Iterator<Arco<E, Integer>> iterArc = g.arcos();
            while(iterArc.hasNext()){
                Arco<E, Integer> arco = iterArc.next();
                if (arco.getOrigen().equals(actual) && porVisitar.contains(arco.getDestino())){
                    if (toret.get(arco.getOrigen()) + arco.getEtiqueta() < toret.get(arco.getDestino())){
                        toret.insertar(arco.getDestino(), toret.get(arco.getOrigen()) + arco.getEtiqueta());
                    }
                }
            }
        }      
        
        return toret;
    }
    
    private static <E> Vertice<E> distanciaMinima(Mapa<Vertice<E>, Integer> mapa, ArrayList<Vertice<E>> porVisitar){
        Vertice<E> actual, toret;
        Iterator <Vertice<E>> iterador = porVisitar.iterator();
        
        toret = iterador.next();
        
        while (iterador.hasNext()){
            actual = iterador.next();
            if (mapa.get(toret) > mapa.get(actual)){
                toret = actual;
            }
        }
        
        return toret;
    }
    
}
