/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mauro
 */
public class Coneccion {
    private String base="jdbc:mysql://201.235.253.65:3306/maurodim_observatorio";
    private String stringDeConeccion;
    private String driver="com.mysql.jdbc.Driver";
    private String usuario="maurodim";
    private String clave="mau*2012";

    public String getBase() {
        return base;
    }

    public String getClave() {
        return clave;
    }

    public String getDriver() {
        return driver;
    }

    public String getStringDeConeccion() {
        return stringDeConeccion;
    }

    public String getUsuario() {
        return usuario;
    }
    public Connection obtenerConeccion() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        Connection cp=DriverManager.getConnection(base,usuario,clave);
        return cp;
    }
    public void cerrarConeccion(Connection cc) throws SQLException{
        cc.close();
        
    }
    
}
