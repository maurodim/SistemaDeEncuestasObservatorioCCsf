/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import intEncuesta.Envios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import procesos.Coneccion;

/**
 *
 * @author Administrador
 */
public class EnviosDeCorreos implements Envios{
    private Integer numeroEnvio;
    private String idSocio;
    private Integer idEncuesta;
    private String direccionDeCorreo;
    private Integer numero;

    public String getDireccionDeCorreo() {
        return direccionDeCorreo;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getNumeroEnvio() {
        return numeroEnvio;
    }

    public void enviosPendientes() throws ClassNotFoundException, SQLException{
        Coneccion con=new Coneccion();
        Connection cnn=con.obtenerConeccion();
        ArrayList env=new ArrayList();
        String sql="select *,(select encuesta.textoEncuesta from encuesta where numero=envios.idEncuesta)as texto,(select encuesta.tituloEncuesta from encuesta where numero = envios.idEncuesta)as asunto from envios where enviar > 0 order by idEncuesta";
        Statement st=cnn.createStatement();
        st.execute(sql);
        ResultSet rs=st.getResultSet();
        while(rs.next()){
            
        }
    }
    @Override
    public int enviar(int numeroEncuesta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void marcarEnviado(int numeroSocio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void generarCorreos(int numeroEncuesta, Integer numeroEnvio, Integer numeroActualizar, ArrayList lista,String asunto,String texto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
