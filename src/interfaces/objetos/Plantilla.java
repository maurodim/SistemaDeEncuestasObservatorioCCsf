/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesos.Coneccion;

/**
 *
 * @author Administrador
 */
public class Plantilla {
    private String texto;
    private Integer numero;
    private String textoReemplazo;
    private String linkCompleto;

    public String getLinkCompleto() {
        return linkCompleto;
    }

    public void setLinkCompleto(String linkCompleto) {
        this.linkCompleto = linkCompleto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoReemplazo() {
        return textoReemplazo;
    }

    public void setTextoReemplazo(String textoReemplazo) {
        this.textoReemplazo = textoReemplazo;
    }
    public void generarPlantilla(){
        try {
            Coneccion con=new Coneccion();
            Connection cnn=con.obtenerConeccion();
            Statement st=cnn.createStatement();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Plantilla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Plantilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
