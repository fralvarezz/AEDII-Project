/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaed2;
import java.util.List;

/**
 *
 * @author danid
 */
public interface Mapa<K ,V> {
    public int getNumElem();
    // Produce: devuelve el numero de elementos del mapa
    public boolean esVacio();
    // Produce: devuelve true si el mapa está vacío, false en caso contrario
    public V get(K clave);
    // Produce: devuelve el valor asociado a la clave, devuelve null si no hay ningún valor
    // asociado a la clave
    public V insertar(K clave, V valor);
    // Modfica: this
    // Produce: inserta el par clave, valor. Devuelve null si la clave no existe 
    // Si la clave ya existe, sustituye el valor asociado por valor y devuelve el valor antiguo
    
   public  V eliminar(K clave);
    // Modifica: this
    // Produce: elimina el valor asociado a la clave del mapa y lo devuelve
    // Si clave no está en el mapa devuelve null
    public List<K> listaClaves();
    // Produce: devuelve una lista con todas las claves del mapa. 
    public List<V> listaValores();
    // Produce: devuelve una lista con todos los valores del mapa.
    public boolean estaValor(V valor);
    // Produce: devuelve true si el valor está en el mapa.
    
    @Override
    public String toString();
    // Produce: devuelve una lista con todos los pares <Clave, Valor>
    
    }
    
   
