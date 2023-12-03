
package ferreteriatornillo.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Controller {
    
    private ArrayList<Users> users = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<ShopingCart> shopinCart = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    
    private final String path = Util.getProgramDirectory();

    private void prepareFolder(File file) {
        File dir = new File(this.path + "/data");            

        if (!dir.isDirectory()) {
            dir.mkdirs();
        } else {
            if (file.exists()) {
                file.delete();
            }
        }        
    }
    
    public int productAmount(String id) {
        int res = 0;
        
        for (int i=0; i<this.shopinCart.size(); i++) {
            ShopingCart sc = this.shopinCart.get(i);
            if ( sc.getProduct().getId().equals(id) ) {
                res = sc.getAmount();
            }
        }
        
        return res;
    }

    public void setShopinCart(ArrayList<ShopingCart> shopinCart) {
        this.shopinCart = shopinCart;
    }
    
    public boolean saveUsers(ArrayList<Users> users) {
        this.users = users;
        boolean res = false;

        String fileName = this.path + "/data/usuarios.txt";
        
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File file=new File(fileName); 
            
            prepareFolder(file);
            
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter write = new FileWriter(file, true);
            String role = "2";

            for (int i=0; i<this.users.size(); i++) {                
                Users usr = this.users.get(i);
                
                if (usr instanceof Customer) {
                    role = "0";
                } else if (usr instanceof Vendor) {
                    role = "1";
                }
                
                write.write("id="+usr.getId()+",username="+usr.getName()+",password="+usr.getPassword()+",role="+role+"\r\n");                
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

    public ArrayList<Users> getUsers() {
               
        String fileName = this.path + "/data/usuarios.txt";
                
        File file=new File(fileName); 
                    
        ArrayList<Users> arrayUsers = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(file));
            String text = br.readLine();

            while(text != null) {

                String[] attr = text.split(",");
                String[] id = attr[0].split("=");
                String[] name = attr[1].split("=");
                String[] passw = attr[2].split("=");
                String[] role = attr[3].split("=");

                switch (role[1]) {
                    case "0":
                        arrayUsers.add(new Customer(id[1], name[1], passw[1]));
                        break;
                    case "1":
                        arrayUsers.add(new Vendor(id[1], name[1], passw[1]));
                        break;
                    default:
                        arrayUsers.add(new Admin(id[1], name[1], passw[1]));
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
        
        return arrayUsers;
    }
    
    
    public Users getUser(String id) {
        Users user = null;
        ArrayList<Users> arrayUsers = this.getUsers();
        
        for (int i = 0; i < arrayUsers.size(); i++) {
            user = arrayUsers.get(i);
            if (user.getId().equals(id)) {
                break;
            }
        }        
        
        return user;
    }    
       
    /**
     *
     * @param user
     * @param pasw
     * @return
     * @throws IOException
     */

    public Users userExist(String user, String pasw) throws IOException {
    	user = user.replace("'","");
	user = user.replace("--","");
        
        ArrayList<Users> arrayUsers = getUsers();
        Users usr = null;

        if ( user.equals("root") && pasw.equals("admin") ) {

            arrayUsers.add(new Admin("1", user, pasw));
            usr = arrayUsers.get(0);
            
        } else {

            for (int i = 0; i < arrayUsers.size(); i++) {
                Users u = arrayUsers.get(i);
                if ( u.getName().equals(user) && u.getPassword().equals(pasw) ) {
                    usr = arrayUsers.get(i);
                    break;
                }
            }
        
        }

        return usr;
        
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
                String[] image = attr[5].split("=");
                
                arrayProducts.add(new Product(id[1], title[1], description[1], Integer.parseInt(stock[1]) ,Double.parseDouble(price[1]), image[1]));               

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
            
            prepareFolder(file);
            
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter write = new FileWriter(file, true);

            for (int i=0; i<this.products.size(); i++) {                
                Product prod = this.products.get(i);
                int amount = prod.getStock() - productAmount(prod.getId());
                write.write("id="+prod.getId()+",title="+prod.getTitle()+",description="+prod.getDescription()+",stock="+Integer.toString(amount)+",price="+Double.toString(prod.getPrice())+",image="+prod.getImgName()+"\r\n");                
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
    
    
    public ArrayList<Comment> getComments(Product product) {
        ArrayList<Comment> arrayComments = this.getAllComments();
        
        for (int i=0; i<arrayComments.size(); i++) {
            Comment comm = arrayComments.get(i);
            if (product.getId().equals(comm.getProduct().getId())) {
                this.comments.add(new Comment(comm.getId(), comm.getProduct(), comm.getUser(), comm.getComment()));
            }
        }
        return this.comments;        
    }

    public ArrayList<Comment> getAllComments() {
        String fileName = this.path + "/data/comments.txt";
                
        File file=new File(fileName); 
        
        ArrayList<Comment> arrayComments = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(file));
            String text = br.readLine();

            while(text != null) {

                String[] attr = text.split(",");
                String[] id = attr[0].split("=");
                String[] productId = attr[1].split("=");
                String[] user = attr[2].split("=");
                String[] comment = attr[3].split("=");
                
                arrayComments.add(new Comment(id[1], this.getProduct(productId[1]), this.getUser(user[1]), comment[1]));               

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
        
        return arrayComments;
        
    }
    
    public boolean setComments(ArrayList<Comment> comments) {
        // Aqui estam los comentarios de un solo producto hechos por cualquier usuario.
        this.comments = comments;
        
        // hay que tener todos los comentarios que hay en el fichero de comentarios.
        ArrayList<Comment> allComments = this.getAllComments();


        for (int i=0; i<this.comments.size(); i++) {
            Comment comment = this.comments.get(i);
            boolean isExist = false;
            
            for (int j=0; j<allComments.size(); j++) {
                Comment com = allComments.get(j);
                if (comment.getId().equals(com.getId())) {
                    isExist= true;
                    break;
                }
            }

            if (!isExist) {
                allComments.add(new Comment(comment.getId(), comment.getProduct(), comment.getUser(), comment.getComment()));
            }
        }
        
        boolean res = false;
        
        String fileName = this.path + "/data/comments.txt";
        
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File file=new File(fileName); 
            
            prepareFolder(file);
            
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter write = new FileWriter(file, true);

            for (int i=0; i<allComments.size(); i++) {                
                Comment comment = allComments.get(i);
                write.write("id="+comment.getId()+",productId="+comment.getProduct().getId()+",userId="+comment.getUser().getId()+",comment="+comment.getComment()+"\r\n");                                                        
            }

            //Cerramos la conexion
            write.close();   
            
            res = true;
            
            System.out.println("Información guardada con éxito");
            
        } //Si existe un problema al escribir cae aqui
        catch (IOException e) {
            System.out.println("Error al escribir en el archivo de comentarios");
        }                                       
        
        
        return res;
    }    
    
}
