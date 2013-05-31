/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import intEncuesta.Procesos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesos.Coneccion;

/**
 *
 * @author mauro
 */
public class Encuesta implements Procesos{
    private Integer numero;
    private String titulo;
    private String baseDeDatos;
    private Date fechaDesde;
    private Date fechaHasta;
    private ArrayList cuestionario=new ArrayList();
    private Integer cuestionarioNumero;
    private String nombreOperador;
    private Integer numeroOperador;
    private Integer movimientoNumero;
    private String comentario;
    private String html;
    private String textoCorreo;
    private Integer rubroNumero;
    private Integer subRubroNumero;
    static ArrayList listadoEncuestas=new ArrayList();
    private Integer numeroEnvio;
    private Integer numeroActualizacion;

    public Integer getNumeroActualizacion() {
        return numeroActualizacion;
    }

    public void setNumeroActualizacion(Integer numeroActualizacion) {
        this.numeroActualizacion = numeroActualizacion;
    }

    public Integer getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(Integer numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }
    
    
    public String getTextoCorreo() {
        return textoCorreo;
    }

    public void setTextoCorreo(String textoCorreo) {
        this.textoCorreo = textoCorreo;
    }

    
    public ArrayList getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(ArrayList cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Integer getSubRubroNumero() {
        return subRubroNumero;
    }

    public void setSubRubroNumero(Integer subRubroNumero) {
        this.subRubroNumero = subRubroNumero;
    }

    public Integer getRubroNumero() {
        return rubroNumero;
    }

    public void setRubroNumero(Integer rubroNumero) {
        this.rubroNumero = rubroNumero;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getCuestionarioNumero() {
        return cuestionarioNumero;
    }

    public void setCuestionarioNumero(Integer cuestionarioNumero) {
        this.cuestionarioNumero = cuestionarioNumero;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Integer getMovimientoNumero() {
        return movimientoNumero;
    }

    public void setMovimientoNumero(Integer movimientoNumero) {
        this.movimientoNumero = movimientoNumero;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumeroOperador() {
        return numeroOperador;
    }

    public void setNumeroOperador(Integer numeroOperador) {
        this.numeroOperador = numeroOperador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer ultimo() throws ClassNotFoundException, SQLException{
        Coneccion con=new Coneccion();
        Connection cnn=con.obtenerConeccion();
        String sql="select * from encuesta order by numero";
        Statement st=cnn.createStatement();
        st.execute(sql);
        ResultSet rs=st.getResultSet();
        Integer ul=0;
        while(rs.next()){
            ul=rs.getInt("numero");
            System.err.println("numero "+ul);
        }
        rs.close();
        st.close();
        con.cerrarConeccion(cnn);
        return ul;
    }
    @Override
    public void guardar(Object objeto) {
        
    }

    @Override
    public Object leer(int numero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listar() {
        try {
            Coneccion con=new Coneccion();
            ArrayList listado=new ArrayList();
            Connection cnn=con.obtenerConeccion();
            String sql="select * from encuesta order by numero desc";
            Statement st=cnn.createStatement();
            st.execute(sql);
            ResultSet rs=st.getResultSet();
            while(rs.next()){
                Encuesta enc=new Encuesta();
                enc.titulo=rs.getString("tituloEncuesta");
                enc.fechaDesde=rs.getDate("fechaDesde");
                enc.fechaHasta=rs.getDate("fechaHasta");
                enc.textoCorreo=rs.getString("textoEncuesta");
                listado.add(enc);
            }
            rs.close();
            st.close();
            con.cerrarConeccion(cnn);
            return listado;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Encuesta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Encuesta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void modificar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nuevo(Object obj) {
        try {
            Coneccion con=new Coneccion();
            Encuesta enc=(Encuesta)obj;
            String link="http://www.maurodi.net/observatorio/encuestas.php?numero="+enc.getNumero()+"&socio=";
            /*
             * ACA DEBERIA LLAMAR A LA PLANTILLA Y REEMPLAZAR LOS DATOS PARA QUE QUEDE GENERADO EL TEXTO CON EL BOTON Y TODO
             * 
             */
            Connection cnn=con.obtenerConeccion();
            String sql="insert into encuesta (tituloEncuesta,rubro,link,numeroEnvio,numeroActualizacion,textoEncuesta)values('"+enc.titulo+"',"+enc.rubroNumero+",'"+link+"',"+enc.numeroEnvio+","+enc.numeroActualizacion+",'"+enc.textoCorreo+"')";            
            Statement st=cnn.createStatement();
            st.executeUpdate(sql);
            st.close();
            System.out.println(sql);
            con.cerrarConeccion(cnn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}