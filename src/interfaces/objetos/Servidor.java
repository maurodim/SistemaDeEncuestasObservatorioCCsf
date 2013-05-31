/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

/**
 *
 * @author mauro
 */
public class Servidor {
private String smtp;
private String pass;
private String usuario;
private String puerto;
private String sender;
private String host;
private String direccionDeEnvio;
private String nombreDeEnvio;
private String base;
private int numeroDeBusqueda;
private int numeroActualizacion;
private String tls;
private Integer numeroParaEnviar;
private Integer numeroParaActualizar;



    public String getTls() {
        return tls;
    }

    public void setTls(String tls) {
        this.tls = tls;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDireccionDeEnvio() {
        return direccionDeEnvio;
    }

    public void setDireccionDeEnvio(String direccionDeEnvio) {
        this.direccionDeEnvio = direccionDeEnvio;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNombreDeEnvio() {
        return nombreDeEnvio;
    }

    public void setNombreDeEnvio(String nombreDeEnvio) {
        this.nombreDeEnvio = nombreDeEnvio;
    }

    public int getNumeroActualizacion() {
        return numeroActualizacion;
    }

    public void setNumeroActualizacion(int numeroActualizacion) {
        this.numeroActualizacion = numeroActualizacion;
    }

    public int getNumeroDeBusqueda() {
        return numeroDeBusqueda;
    }

    public void setNumeroDeBusqueda(int numeroDeBusqueda) {
        this.numeroDeBusqueda = numeroDeBusqueda;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   
}
