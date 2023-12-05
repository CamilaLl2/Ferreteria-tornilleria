package ferreteriatornillo.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlUser {
    public final String path = Util.getProgramDirectory();
    private ArrayList<Users> users = new ArrayList<>();

    public CtrlUser() {
        super();        
    }

    public ArrayList<Users> getUsers() {
        String fileName = path + "/data/usuarios.txt";
                
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
    
    public boolean saveUsers(ArrayList<Users> users) {
        this.users = users;
        boolean res = false;

        String fileName = this.path + "/data/usuarios.txt";
        
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File file=new File(fileName); 
            
            Util utl = new Util();
            utl.prepareFolder(file, path);
            
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
    
}
