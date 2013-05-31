/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import procesos.Coneccion;

/**
 *
 * @author mauro
 */
public class Rubros {
    private int numero;
    private String descripcion;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public ArrayList listarRubros() throws ClassNotFoundException, SQLException{
        Coneccion con=new Coneccion();
        ArrayList listado=new ArrayList();
        Connection cnn=con.obtenerConeccion();
        String sql="select * from rubros";
        Statement st=cnn.createStatement();
        st.execute(sql);
        ResultSet rs=st.getResultSet();
        while(rs.next()){
            Rubros rb=new Rubros();
            rb.numero=rs.getInt("numero");
            rb.descripcion=rs.getString("descripcion");
            listado.add(rb);
        }
        rs.close();
        st.close();
        con.cerrarConeccion(cnn);
        return listado;
    }
    
}
