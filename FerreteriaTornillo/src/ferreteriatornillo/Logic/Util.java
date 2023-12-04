/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriatornillo.Logic;

import java.io.File;
import java.net.URISyntaxException;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author migue
 */
public class Util {
    
    
    private static String getJarName()
    {
        return new File(Util.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath())
                .getName();
    }

    private static boolean runningFromJAR()
    {
        String jarName = getJarName();
        return jarName.contains(".jar");
    }

    public static String getProgramDirectory()
    {
        if (runningFromJAR())
        {
            return getCurrentJARDirectory();
        } else
        {
            return getCurrentProjectDirectory();
        }
    }

    private static String getCurrentProjectDirectory()
    {
        return new File("").getAbsolutePath();
    }

    private static String getCurrentJARDirectory()
    {
        try
        {
            return new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent();
        } catch (URISyntaxException exception)
        {
            exception.printStackTrace();
        }

        return null;
    }    
    // Formatear columnas de una tabla
    // Recibe un JTable  y un arreglo de enteros que tiene el ancho de cada columna
    public void tableFmt(JTable table, int[] arrWidth) {
        int widthColumn = 0, widthColumnMin = 0, widthColumnMax = 0;
          //TableColumn nos provee de métodos para minimizar, maximizar,etc. columnas de tabla.
        TableColumn  columnTable = null;
  
        // recorrer cada columna de la tabla, el getColumnCount retorna la cant de columna de la tabla
        for(int i=0; i<table.getColumnCount(); i++) {
            //Obtenemos el modelo de las columnas de la tabla.
            columnTable = table.getColumnModel().getColumn(i);

            // asignar el tamano de la columna
            widthColumn = arrWidth[i];     
            widthColumnMin = arrWidth[i];  
            widthColumnMax = arrWidth[i];
 
             //Aplicamos el ancho para cada columna de la tabla.
             columnTable.setPreferredWidth(widthColumn);
             columnTable.setMinWidth(widthColumnMin);
             columnTable.setMaxWidth(widthColumnMax);
        }        
    }
    
}
