package ferreteriatornillo.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CtrlComment {
    public final String path = Util.getProgramDirectory();
    private ArrayList<Comment> comments = new ArrayList<>();

    public CtrlComment() {
        super();        
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
        
        CtrlUser ctrlUser = new CtrlUser();
        CtrlProduct ctrlProd = new CtrlProduct();
                       
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
                
                arrayComments.add(new Comment(id[1], ctrlProd.getProduct(productId[1]), ctrlUser.getUser(user[1]), comment[1]));

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
            
            Util utl = new Util();
            utl.prepareFolder(file, path);
            
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
