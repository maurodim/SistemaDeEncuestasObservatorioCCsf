/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intEncuesta;

import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public interface Procesos {
    public void guardar(Object objeto);
    public Object leer(int numero);
    public ArrayList listar();
    public void modificar(Object objeto);
    public void nuevo(Object objeto);
    
}
