/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import intEncuesta.Envios;
import intEncuesta.Procesos;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class Socios implements Envios,Procesos{
    private Integer numero;
    private String razonSocial;
    private String numeroTango;
    private String direccionDeCorreo;
    private Integer preferenciaDeEncuesta;
    private String direccion;
    private String telefono;
    private Integer cantidadDeEmpleados;
    private Integer zona;
    private Integer rubro;
    private String descripcionRubro;
    private Integer subRubro;
    private String descripcionSubRubro;
    private Integer enviar;

    public Integer getCantidadDeEmpleados() {
        return cantidadDeEmpleados;
    }

    public void setCantidadDeEmpleados(Integer cantidadDeEmpleados) {
        this.cantidadDeEmpleados = cantidadDeEmpleados;
    }

    public String getDescripcionRubro() {
        return descripcionRubro;
    }

    public void setDescripcionRubro(String descripcionRubro) {
        this.descripcionRubro = descripcionRubro;
    }

    public String getDescripcionSubRubro() {
        return descripcionSubRubro;
    }

    public void setDescripcionSubRubro(String descripcionSubRubro) {
        this.descripcionSubRubro = descripcionSubRubro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionDeCorreo() {
        return direccionDeCorreo;
    }

    public void setDireccionDeCorreo(String direccionDeCorreo) {
        this.direccionDeCorreo = direccionDeCorreo;
    }

    public Integer getEnviar() {
        return enviar;
    }

    public void setEnviar(Integer enviar) {
        this.enviar = enviar;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNumeroTango() {
        return numeroTango;
    }

    public void setNumeroTango(String numeroTango) {
        this.numeroTango = numeroTango;
    }

    public Integer getPreferenciaDeEncuesta() {
        return preferenciaDeEncuesta;
    }

    public void setPreferenciaDeEncuesta(Integer preferenciaDeEncuesta) {
        this.preferenciaDeEncuesta = preferenciaDeEncuesta;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getRubro() {
        return rubro;
    }

    public void setRubro(Integer rubro) {
        this.rubro = rubro;
    }

    public Integer getSubRubro() {
        return subRubro;
    }

    public void setSubRubro(Integer subRubro) {
        this.subRubro = subRubro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
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
    public void generarCorreos(int numeroEncuesta,Integer numEnvio,Integer numActual,ArrayList listado,String asunto,String texto) {
        try {
            Coneccion con=new Coneccion();
            
            Connection cnn=con.obtenerConeccion();
            Statement st=cnn.createStatement();
            String sql="";
            Iterator il=listado.listIterator();
            Socios soc=new Socios();
            while(il.hasNext()){
                soc=(Socios)il.next();
                sql="insert into envios (direccion,enviar,idSocio,idEncuesta,asunto,texto) values ('"+soc.direccionDeCorreo+"',"+numEnvio+",'"+soc.numeroTango+"',"+numeroEncuesta+",'"+asunto+"','"+texto+"')";
                st.executeUpdate(sql);
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
        try {
            Coneccion con=new Coneccion();
            Connection cnn=con.obtenerConeccion();
            ArrayList lista=new ArrayList();
            String sql="select socios.COD_CLIENT,socios.RAZON_SOCI,socios.E_MAIL from socios where E_MAIL is not null";
            Statement st=cnn.createStatement();
            st.execute(sql);
            ResultSet rs=st.getResultSet();
            while(rs.next()){
                Socios soc=new Socios();
                soc.numeroTango=rs.getString(1);
                soc.razonSocial=rs.getString(2);
                soc.direccionDeCorreo=rs.getString(3);
                lista.add(soc);
            }
            rs.close();
            st.close();
            con.cerrarConeccion(cnn);
            return lista;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void modificar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nuevo(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
