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
public interface Envios {
    public int enviar(int numeroEncuesta);
    //retorna el numero de socio
    public void marcarEnviado(int numeroSocio);
    public void generarCorreos(int numeroEncuesta,Integer numeroEnvio,Integer numeroActualizar,ArrayList lista,String asunto,String tx);
}
