package ferreteriatornillo.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CtrlProduct {
    public final String path = Util.getProgramDirectory();

    private ArrayList<Product> products = new ArrayList<>();
    
    public CtrlProduct() {
        super();        
    }
    
    public int productAmount(String id) {
        int res = 0;
        CtrlShop shopCart = new CtrlShop();
        ArrayList<ShopingCart> shopinCart = shopCart.getShopinCart();
        
        for (int i=0; i<shopinCart.size(); i++) {
            ShopingCart sc = shopinCart.get(i);
            if ( sc.getProduct().getId().equals(id) ) {
                res = sc.getAmount();
            }
        }
        
        return res;
    }   
    
    public ArrayList<Product> getProducts() {
        
        String fileName = this.path + "/data/products.txt";
                
        File file=new File(fileName); 
                    
        ArrayList<Product> arrayProducts = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(file));
            String text = br.readLine();

            while(text != null) {

                String[] attr = text.split(",");
                String[] id = attr[0].split("=");
                String[] title = attr[1].split("=");
                String[] description = attr[2].split("=");
                String[] stock = attr[3].split("=");
                String[] price = attr[4].split("=");
                String[] type = attr[5].split("=");
                String[] image = attr[6].split("=");
                
                switch (type[1]) {
                    case "0":
                        arrayProducts.add(new Madera(id[1], title[1], description[1], Integer.parseInt(stock[1]) ,Double.parseDouble(price[1]), image[1]));               
                        break;
                    case "1":
                        arrayProducts.add(new Metal(id[1], title[1], description[1], Integer.parseInt(stock[1]) ,Double.parseDouble(price[1]), image[1]));               
                        break;
                    default:
                        arrayProducts.add(new Chapa(id[1], title[1], description[1], Integer.parseInt(stock[1]) ,Double.parseDouble(price[1]), image[1]));               
                        break;
                }

                // Leer la siguiente línea
                text = br.readLine();
            }            

        }               
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero...");
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
        
        return arrayProducts;
    }   
    
    public Product getProduct(String id) {
        Product product = null;
        ArrayList<Product> arrayProducts = getProducts();
        
        for (int i = 0; i < arrayProducts.size(); i++) {
            product = arrayProducts.get(i);
            if (product.getId().equals(id)) {
                break;
            }
        }        
        
        return product;
    }
    
    public boolean setProducts(ArrayList<Product> products) {
        this.products = products;
        
        boolean res = false;
        
        String fileName = this.path + "/data/products.txt";
        
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File file=new File(fileName); 
            
            Util utl = new Util();
            utl.prepareFolder(file, path);          
            
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter write = new FileWriter(file, true);
            String type = "0";

            for (int i=0; i<this.products.size(); i++) {                
                Product prod = this.products.get(i);
                
                if (prod instanceof Madera) {
                    type = "0";
                } else if (prod instanceof Metal) {
                    type = "1";
                } else {
                    type = "2";
                }
                
                int amount = prod.getStock() - productAmount(prod.getId());
                write.write("id="+prod.getId()+",title="+prod.getTitle()+",description="+prod.getDescription()+",stock="+Integer.toString(amount)+",price="+Double.toString(prod.getPrice())+",type="+type+",image="+prod.getImgName()+"\r\n");                
            }

            //Cerramos la conexion
            write.close();   
            
            res = true;
            
            System.out.println("Información guardada con éxito");
            
        } //Si existe un problema al escribir cae aqui
        catch (IOException e) {
            System.out.println("Error al escribir en el archivo de productos");
        }                                       
        
        
        return res;
    }
    
}
