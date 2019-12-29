/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaed2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author danid
 */
public class HashMap<K,V> implements Mapa<K,V>{
    
    private int numElem;
    private ArrayList<Par<K,V>>[] lista;
    
    
    public HashMap(int maxElem) throws IllegalArgumentException{
        
        
        if(maxElem<0){
            throw new IllegalArgumentException("Error. Tamaño negativo");
        }
        else{
            numElem = 0;
            lista = new ArrayList[maxElem];
            for (int i = 0; i < maxElem; i++) {
                lista[i]= new ArrayList<>();
            }
        }
    }
    
    public HashMap(){
        numElem=0;
        lista = new ArrayList[37];
        for (int i = 0; i < lista.length; i++) {
            lista[i]= new ArrayList<>();
        }
    }
            
    @Override
    public int getNumElem(){
        return numElem;
}
    
    @Override
    public boolean esVacio(){
        return numElem==0;
    }
    
    
    @Override
    public V get(K clave){
        List<Par<K,V>> aux = lista[funcionHash(clave)];
        
        if(aux.isEmpty()){
            return null;
        }else{
            for(Par<K,V> p : aux){
                if(p.getClave().equals(clave)){
                    return p.getValor();
                }
            }
        }
        
        return null;
         
    }
 
    
    @Override
   public V insertar(K clave, V valor){
        int codigo = funcionHash(clave);
        Par<K,V> p = new Par(clave,valor);
        V toret = null;
        
        if(!lista[codigo].isEmpty()){
            Iterator<Par<K,V>> itr = lista[codigo].iterator(); //Recorremos la lista con iteradores porque de no hacerlo
            while(itr.hasNext()){                              //obtendríamos ConcurrentModificationException
                Par par = itr.next();                          //al modificar un elemento de la lista mientras iteramos con for each
                if(par.getClave().equals(clave)){
                    toret = (V)par.getValor();
                    numElem--;
                    itr.remove();
                }
            }
            
        }
        lista[codigo].add(p);
        numElem++;
        return toret;
        
    }
    // Modfica: this
    // Produce: inserta el par clave, valor. Devuelve null si la clave no existía antes
    // Si la clave ya existe, sustituye el valor asociado por valor y devuelve el valor antiguo
    
    @Override
    public V eliminar(K clave){
        int codigo = funcionHash(clave);
        List<Par<K,V>> aux = lista[codigo];
        
        
        if(!lista[codigo].isEmpty()){
          int i=0;
        for(Par<K,V> p : aux){
                if(p.getClave().equals(clave)){
                    return  lista[codigo].remove(i).getValor();
                }
                i++;
        }
        return null;
        }
        else{
            return null;
        }
    }
    
    // Modifica: this
    // Produce: elimina el valor asociado a la clave del mapa y lo devuelve
    // Si clave no está en el mapa devuelve null
    
    
    @Override
    public List<K> listaClaves(){
        ArrayList toret = new ArrayList<>();
       
        for (int i = 0; i < lista.length; i++) {
            if(lista[i]!=null){
                for(Par p : lista[i]){
                    toret.add(p.getClave());
                }
            }
        }
        
        return toret;
    }
    // Produce: devuelve una lista con todas las claves del mapa. 
    
    
    @Override
    public List<V> listaValores(){
        List toret = new ArrayList();
       
        for(List<Par<K,V>> l : lista){
            for(Par<K,V> p : l){
                toret.add(p.getValor());
            }
       }
        
        return toret;
    }
    // Produce: devuelve una lista con todos los valores del mapa.
    
    
    @Override
    public boolean estaValor(V valor){
        for(List<Par<K,V>> listaActual: lista){
            for(Par<K,V> p : listaActual){
                if(valor.equals(p.getValor())){
                    return true;
                }
            }
        }
        
        return false;   
    }
    // Produce: devuelve true si el valor está en el mapa.
    
    @Override
     public String toString(){
        StringBuilder toret = new StringBuilder();
        
       for(List<Par<K,V>> listaActual : lista){
           for(Par<K,V> p : listaActual){
               toret.append(p.toString());
           }
       }
        return toret.toString();
     }
    
    private int funcionHash(K clave){
          return Math.abs(clave.hashCode()%37);
    }
}
