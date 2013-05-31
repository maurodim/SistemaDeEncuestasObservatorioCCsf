/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import intEncuesta.Procesos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesos.Coneccion;

/**
 *
 * @author mauro
 */
public class Cuestionarios implements Procesos{
        private Integer numero;
        private Integer numeroEncuesta;
        private String textoPregunta;
        private Integer tipoRespuesta;
        private String tituloRespuesta;
        private int numeroPregunta;
        static ArrayList cuestionarioEncuesta=new ArrayList();

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public Integer getNumeroEncuesta() {
        return numeroEncuesta;
    }

    public void setNumeroEncuesta(Integer numeroEncuesta) {
        this.numeroEncuesta = numeroEncuesta;
    }

    public String getTituloRespuesta() {
        return tituloRespuesta;
    }

    public void setTituloRespuesta(String tituloRespuesta) {
        this.tituloRespuesta = tituloRespuesta;
    }
        

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public Integer getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(Integer tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    @Override
    public void guardar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object leer(int numero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modificar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nuevo(Object objeto) {
        try {
            Cuestionarios cues=new Cuestionarios();
            cues=(Cuestionarios)objeto;
            Coneccion con=new Coneccion();
            Connection cnn=con.obtenerConeccion();
            String sql="insert into cuestionario (textoPregunta,tituloRespuesta,tipoRespuesta,encuestaNumero,numeroPregunta) values ('"+cues.getTextoPregunta()+"','"+cues.getTituloRespuesta()+"',"+cues.getTipoRespuesta()+","+cues.getNumeroEncuesta()+","+cues.getNumeroPregunta()+")";
            Statement st=cnn.createStatement();
            st.execute(sql);
            st.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cuestionarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cuestionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        
}
