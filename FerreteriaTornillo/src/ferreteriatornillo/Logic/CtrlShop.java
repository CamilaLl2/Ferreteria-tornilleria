package ferreteriatornillo.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlShop {
    public final String path = Util.getProgramDirectory();
    private ArrayList<ShopingCart> shopinCart = new ArrayList<>();
    
    public CtrlShop() {
        super();        
    }

    public void setShopinCart(ArrayList<ShopingCart> shopinCart) {
        this.shopinCart = shopinCart;
    }   
    
    public boolean saveShopinCart(ArrayList<ShopingCart> shopCart) {
        this.shopinCart = shopCart;
        boolean res = false;
        String fileName = this.path + "/data/shopcart.txt";

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File file=new File(fileName); 
            
            Util utl = new Util();
            utl.prepareFolder(file, path);
            
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter write = new FileWriter(file, true);
            
            for (int i=0; i<this.shopinCart.size(); i++) {  
                ShopingCart shopcart = this.shopinCart.get(i);
                write.write("productId="+shopcart.getProduct().getId()+",amount="+Integer.toString(shopcart.getAmount())+"\r\n");                
            }

            //Cerramos la conexion
            write.close();   
            
            res = true;
            
            System.out.println("Información guardada con éxito");
            
        } //Si existe un problema al escribir cae aqui
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Tienda", JOptionPane.INFORMATION_MESSAGE);                            
            
            System.out.println("Error al escribir en el archivo de productos");
        }                                       
        
        return res;
        
    }
    
    public ArrayList<ShopingCart> getShopinCart() {
        String fileName = this.path + "/data/shopcart.txt";
        
        CtrlProduct ctrlProd = new CtrlProduct();
                
        File file=new File(fileName);
                    
        ArrayList<ShopingCart> arrayShopCart = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(file));
            String text = br.readLine();

            while(text != null) {

                String[] attr = text.split(",");
                String[] product = attr[0].split("=");
                String[] amount = attr[1].split("=");

                arrayShopCart.add(new ShopingCart(ctrlProd.getProduct(product[1]), Integer.parseInt(amount[1])));               

                // Leer la siguiente línea
                text = br.readLine();
            }            

        }               
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (IOException ex) {
                System.out.println("Error al cerrar el fichero");
            }
        }                
        
        return arrayShopCart;        
    }
    
    
}
