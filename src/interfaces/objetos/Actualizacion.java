/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesos.Coneccion;

/**
 *
 * @author mauro
 */
public class Actualizacion extends Thread{
    private Integer listado;
    private String base;
    private Integer numero;

    public void setBase(String base) {
        this.base = base;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    

    public void setListado(Integer listado) {
        this.listado = listado;
    }
    
    public void run(){
        try {
            Coneccion con=new Coneccion();
                          Class.forName(con.getDriver());
            Connection cp=con.obtenerConeccion();
            Statement st=cp.createStatement();
            //Iterator il=this.listado.listIterator();
            //while(il.hasNext()){
                //Object num=il.next();
                   String sql="update "+this.base.trim()+" set enviar="+this.numero+" where numero ="+this.listado;
                   System.err.println(sql);
            st.executeUpdate(sql);
            //}
            st.close();
            cp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Actualizacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Actualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
