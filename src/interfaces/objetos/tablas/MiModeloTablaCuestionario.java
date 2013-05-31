/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos.tablas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro
 */
public class MiModeloTablaCuestionario extends DefaultTableModel{
    public MiModeloTablaCuestionario(){
        
    }
    public Class getColumnClass(int column){
        if(column==0)return String.class;
        return Boolean.class;
    }
}
