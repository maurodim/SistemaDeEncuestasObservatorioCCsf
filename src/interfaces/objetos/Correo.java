/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public class Correo {
    private String texto;
    private String destinatario;
    private String destinatarioOculto;
    private String asunto;
    private String remitente;
    private String pass;
    private String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        
        this.html = html;
    }

    public String getPass() {
        return pass;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDestinatarioOculto() {
        return destinatarioOculto;
    }

    public void setDestinatarioOculto(String destinatarioOculto) {
        this.destinatarioOculto = destinatarioOculto;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
