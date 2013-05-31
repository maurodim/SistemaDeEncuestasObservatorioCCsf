/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.objetos.tablas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class MiTabaModEncuesta extends DefaultTableModel{
    public MiTabaModEncuesta(){
        
    }
   public Class getColumnClass(int column){
        if(column==0)return String.class;
        return String.class;
    }
}

