/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import interfaces.objetos.Actualizacion;
import interfaces.objetos.Correo;
import interfaces.objetos.EnviosDeCorreos;
import interfaces.objetos.Servidor;
import java.io.UnsupportedEncodingException;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author mauro
 */
public class works {
    static String dEmail;
    static String dPassword;
    private Session sesion;
    
    public void enviarCorreos(String cm,String tx,String as) throws MessagingException, UnsupportedEncodingException, ClassNotFoundException, SQLException, InterruptedException{
        ArrayList dire=new ArrayList();
        EnviosDeCorreos cnc=new EnviosDeCorreos();
        Servidor sv=cargarDatosServidor(cnc.getNumeroEnvio());
        dire=cargarDirecciones(cm,sv);
        Iterator id=dire.listIterator();
        while(id.hasNext()){
            Thread.sleep(15000);
            cnc=(EnviosDeCorreos) id.next();
        Properties propiedades=new Properties();
        propiedades.put("mail.smtp.host",sv.getHost().trim());//"smtp.arnet.com.ar"
        propiedades.put("mail.smtp.starttls.enable",sv.getTls());//true
        propiedades.put("mail.smtp.port",sv.getPuerto().trim());
        propiedades.put("mail.smtp.mail.sender",sv.getSender().trim());
        propiedades.put("mail.smtp.user",sv.getUsuario().trim());//"maurodim01@arnet.com.ar"
        propiedades.put("mail.smtp.auth","true");
        sesion=Session.getDefaultInstance(propiedades);
        sesion.setDebug(true);
        MimeMessage mensaje=new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(sv.getDireccionDeEnvio().trim(),sv.getNombreDeEnvio().trim()));
        mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(cnc.getDireccionDeCorreo().trim()));
        //mensaje.addHeader("Disposition-Notification-To","administracion@centrocomercialsf.com.ar");
        
        //mensaje.addRecipient(Message.RecipientType.BCC,new InternetAddress(cnc.getDestinatarioOculto()));
        //mensaje.setReplyTo("administracion@centrocomercialsf.com.ar");
        mensaje.setSubject(as);
        mensaje.setContent(tx,"text/html");
        //mensaje.setText(cm.getTexto());
        Transport t=sesion.getTransport("smtp");
        t.connect((String)propiedades.get("mail.smtp.user"),sv.getPass().trim());//"Sutter0102"
        t.sendMessage(mensaje,mensaje.getAllRecipients());
        t.close();
        }
    }
    public static void SMTPAuthenticator(String email, String password){
    dEmail = email;
    dPassword = password;
    }
    public ArrayList cargarDirecciones(String rem,Servidor ss) throws ClassNotFoundException, SQLException{
        ArrayList listado=new ArrayList();
        ArrayList numero=new ArrayList();
        Actualizacion act=new Actualizacion();
        Correo cmm=new Correo();
        Integer i=1;
        Coneccion con=new Coneccion();
               Class.forName(con.getDriver());
               String sql="select * from "+ss.getBase().trim()+" where enviar="+ss.getNumeroDeBusqueda()+" limit 0,1";
        System.err.println(sql);
               Connection cp=con.obtenerConeccion();
        Statement st=cp.createStatement();
        st.execute(sql);
        ResultSet rs=st.getResultSet();
        Integer num=0;
        while(rs.next()){
           // listado.add(rs.getString("B"));
            cmm.setRemitente(rem);
            num=rs.getInt("numero");
            numero.add(num);
 
            
                cmm.setDestinatario(rs.getString("correo"));
                //cmm.setDestinatario("maurodi_1@hotmail.com");
            
            listado.add(cmm);
        }
        System.out.println("NUMERO ACTUAL "+num);
        if(num==0){
                System.exit(0);
                //setDefaultCloseOperation()
            }
        act.setListado(num);
        act.setBase(ss.getBase().trim());
        act.setNumero(ss.getNumeroActualizacion());
        act.start();
        rs.close();
        st.close();
        cp.close();
        numero.clear();
        return listado;
    }
   public Servidor cargarDatosServidor(int numeroEnviar){
       Servidor ss=new Servidor();

               ss.setHost("mail.centrocomercialsf.com.ar");
               ss.setPuerto("9025");
               ss.setSender("contacto@centrocomercialsf.com.ar");
               ss.setUsuario("contacto@centrocomercialsf.com.ar");
               ss.setDireccionDeEnvio("administracion@centrocomercialsf.com.ar");
               ss.setNombreDeEnvio("Centro Comercial de Santa Fe");
               ss.setPass("graciela");
               ss.setBase("envios");
               ss.setNumeroDeBusqueda(numeroEnviar);
               ss.setNumeroActualizacion(0);
               ss.setTls("false");
       return ss;
   }
}
