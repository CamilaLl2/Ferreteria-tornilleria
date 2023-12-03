
package ferreteriatornillo.UserInterfaces;

import ferreteriatornillo.Logic.Controller;
import ferreteriatornillo.Logic.Users;
import ferreteriatornillo.Logic.Product;
import ferreteriatornillo.Logic.Util;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class FrmProduct extends javax.swing.JFrame {
    
    private Users loginUser;
    
    private final ArrayList<Product> data;
    
    public void setLoginUser(Users user) {
        this.loginUser = user;
    }
    

    
    public FrmProduct() {
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };        
        
        model.addColumn("Id");
        model.addColumn("Título");
        model.addColumn("Descripción");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Imagen");
        
        Controller ctrl = new Controller();
        ArrayList<Product> arrayProducts = ctrl.getProducts();
        this.data = ctrl.getProducts();
        
        Product product = null;
        
        for (int i = 0; i < arrayProducts.size(); i++) {
            product = arrayProducts.get(i);
            model.addRow(new Object[]{product.getId(), product.getTitle(), product.getDescription(), product.getStock(), product.getPrice(), product.getImgName()});
        }
        
        tblProduct.setModel(model);
        
        tblProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tblProduct.setRowHeight(30);
        
        
        int[] arrCol = {40,280,280,60,60,200};        
        Util u = new Util();
        u.tableFmt(tblProduct, arrCol);       
        
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblVendor = new javax.swing.JLabel();
        textVendor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        textTitle = new javax.swing.JTextField();
        textDescription = new javax.swing.JTextField();
        textStock = new javax.swing.JTextField();
        textPrice = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        textImage = new javax.swing.JTextField();
        btnChooser = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Productos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Descripción", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setResizable(false);
            tblProduct.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblProduct.getColumnModel().getColumn(1).setResizable(false);
            tblProduct.getColumnModel().getColumn(1).setPreferredWidth(330);
            tblProduct.getColumnModel().getColumn(2).setResizable(false);
            tblProduct.getColumnModel().getColumn(2).setPreferredWidth(330);
            tblProduct.getColumnModel().getColumn(3).setResizable(false);
            tblProduct.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblProduct.getColumnModel().getColumn(4).setResizable(false);
            tblProduct.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        lblVendor.setText("Vendedor:");

        textVendor.setEditable(false);
        textVendor.setBackground(java.awt.Color.lightGray);
        textVendor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTitle.setText("Título:");

        lblDescription.setText("Descripción:");

        lblStock.setText("Cantidad:");

        lblPrice.setText("Precio:");

        textDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescriptionActionPerformed(evt);
            }
        });

        textStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnNew.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/add.png")); // NOI18N
        btnNew.setText("Agregar");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/pencil.png")); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/delete.png")); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblImage.setText("Nombre de Imagen");

        textImage.setEditable(false);

        btnChooser.setText("Imagen");
        btnChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImage)
                    .addComponent(lblDescription)
                    .addComponent(lblTitle)
                    .addComponent(lblStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textTitle)
                    .addComponent(textDescription)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblStock)
                    .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImage)
                    .addComponent(textImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSave.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/disk.png")); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/door_in.png")); // NOI18N
        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(lblVendor)
                        .addGap(18, 18, 18)
                        .addComponent(textVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnClose))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        
        if ( !textTitle.getText().equals("") && !textDescription.getText().equals("") && !textStock.getText().equals("") && !textPrice.getText().equals("") ) {
        
            DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();        
            int id = model.getRowCount() + 1;
            model.addRow(new Object[]{id, textTitle.getText(), textDescription.getText(), textStock.getText(), textPrice.getText(), textImage.getText()});
            tblProduct.setModel(model);       

            textTitle.setText("");
            textDescription.setText("");
            textStock.setText("");
            textPrice.setText("");
            textImage.setText("");
        
        } else {
            JOptionPane.showMessageDialog(null, "Complete los campos para añadir un producto", "Añadir Producto", JOptionPane.INFORMATION_MESSAGE);                        
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tblProduct.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        model.setValueAt(textTitle.getText().trim(), row, 1);
        model.setValueAt(textDescription.getText().trim(), row, 2);
        model.setValueAt(textStock.getText().trim(), row, 3);
        model.setValueAt(textPrice.getText().trim(), row, 4);
        model.setValueAt(textImage.getText().trim(), row, 5);
        
        textTitle.setText("");
        textDescription.setText("");
        textStock.setText("");
        textPrice.setText("");
        textImage.setText("");       
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        
        int row = tblProduct.getSelectedRow();
        
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        
            int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar este producto", "Eliminar Producto", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(resp == 0) {
                model.removeRow(row);
                
                textTitle.setText("");
                textDescription.setText("");
                textStock.setText("");
                textPrice.setText("");
                textImage.setText("");
                
            }
        
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el Producto que desea eliminar", "Eliminar Producto", JOptionPane.INFORMATION_MESSAGE);            
        }        
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        FrmLogin frmlogin = new FrmLogin();
        frmlogin.setVisible(true);
        frmlogin.setLocationRelativeTo(null);                                                        
        
        this.dispose();
    }

    private void textDescriptionActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        ArrayList<Product> arrayProducts = new ArrayList<>();

        for (int i=0; i<model.getRowCount(); i++) {                
            arrayProducts.add(new Product(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString(), Integer.parseInt(model.getValueAt(i, 3).toString()), Double.parseDouble(model.getValueAt(i, 4).toString()), model.getValueAt(i, 5).toString()));
        }

        Controller ctrl = new Controller();
        boolean isSaved = ctrl.setProducts(arrayProducts);
        
        if ( isSaved ) {
            JOptionPane.showMessageDialog(null, "Información guardada con éxito", "Productos", JOptionPane.INFORMATION_MESSAGE);            

            FrmLogin frmlogin = new FrmLogin();
            frmlogin.setVisible(true);
            frmlogin.setLocationRelativeTo(null);                                                        
            
            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar los datos", "Productos", JOptionPane.ERROR_MESSAGE);                        
        }
    }

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblProduct.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
            textTitle.setText(model.getValueAt(row, 1).toString());
            textDescription.setText(model.getValueAt(row, 2).toString());
            textStock.setText(model.getValueAt(row, 3).toString());        
            textPrice.setText(model.getValueAt(row, 4).toString());    
            textImage.setText(model.getValueAt(row, 5).toString());
        }
    }

    private void btnChooserActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File f = jfc.getSelectedFile();
            textImage.setText(f.getAbsolutePath());            
        } catch (Exception e) {
            System.out.println(e);
        }         
    }


    
    private javax.swing.JButton btnChooser;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVendor;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField textDescription;
    private javax.swing.JTextField textImage;
    private javax.swing.JTextField textPrice;
    private javax.swing.JTextField textStock;
    private javax.swing.JTextField textTitle;
    public static javax.swing.JTextField textVendor;
    
}
