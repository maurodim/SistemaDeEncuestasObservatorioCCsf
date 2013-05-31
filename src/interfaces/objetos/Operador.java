/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import intEncuesta.validarUsuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesos.Coneccion;

/**
 *
 * @author mauro
 */
public class Operador implements validarUsuarios{
    private Integer numero;
    private String nombre;
    private String nombreDeUsuario;
    private String contrasenaUsuario;
    private Integer estado;
    private Integer nivelDeAutorizacion;

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getNivelDeAutorizacion() {
        return nivelDeAutorizacion;
    }

    public void setNivelDeAutorizacion(Integer nivelDeAutorizacion) {
        this.nivelDeAutorizacion = nivelDeAutorizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public Object cargarUsuario(String usuario, String clave) {
        try {
            Coneccion con=new Coneccion();
            Connection cnn=con.obtenerConeccion();
            Statement st=cnn.createStatement();
            String sql="select * from usuarios where usuario='"+usuario+"' and clave='"+clave+"'";
            st.execute(sql);
            ResultSet rs=st.getResultSet();
            while(rs.next()){
                this.setNombre(rs.getString("nombre"));
                this.setContrasenaUsuario(rs.getString("clave"));
                this.setEstado(1);
                this.setNumero(rs.getInt("numero"));
            }
            rs.close();
            st.close();
            
            return this;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public Integer confirmarEstado(Object usua) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
