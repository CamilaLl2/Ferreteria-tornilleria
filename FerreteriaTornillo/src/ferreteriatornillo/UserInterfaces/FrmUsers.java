package ferreteriatornillo.UserInterfaces;

import ferreteriatornillo.Logic.Admin;
import ferreteriatornillo.Logic.Controller;
import ferreteriatornillo.Logic.Customer;
import ferreteriatornillo.Logic.Users;
import ferreteriatornillo.Logic.Util;
import ferreteriatornillo.Logic.Vendor;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmUsers extends javax.swing.JFrame {
    
    private Users loginUser;
    
    private ArrayList<Users> data;
    
    public void setLoginUser(Users user) {
        this.loginUser = user;
    }
    
    
    public FrmUsers() {
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };        
        
        
        model.addColumn("Id");
        model.addColumn("Nombre de Usuario");
        model.addColumn("Contraseña");
        model.addColumn("Rol");
       
        
        Controller ctrl = new Controller();
        ArrayList<Users> arrayUsers = ctrl.getUsers();
        this.data = ctrl.getUsers();

        Users usr = null;
        String role = null;
        
        for (int i = 0; i < arrayUsers.size(); i++) {
            usr = arrayUsers.get(i);
            if (usr instanceof Customer) {
                role = "Comprador";
            } else if (usr instanceof Vendor) {
                role = "Vendedor";
            } else {
                role = "Administrador";
            }

            model.addRow(new Object[]{usr.getId(), usr.getName(), usr.getPassword(), role});
        }
      
        usersTable.setModel(model);
        
        usersTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usersTable.setRowHeight(30);
        
        int[] arrCol = {40,260,100,100};        
        
        Util u = new Util();
        u.tableFmt(usersTable, arrCol);       
        
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblPaswword = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        textPassword = new javax.swing.JTextField();
        cmbRole = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        lblName.setText("Nombre de Usuario:");

        lblPaswword.setText("Contraseña:");

        lblRole.setText("Rol:");

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprador", "Vendedor", "Administrador" }));
        cmbRole.setToolTipText("");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRole)
                            .addComponent(lblPaswword)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblName)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textName)
                    .addComponent(textPassword)
                    .addComponent(cmbRole, 0, 235, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaswword))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Contraseña", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Usuarios de la Ferreteria");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        pack();
    }

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = usersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
        textName.setText(model.getValueAt(row, 1).toString());
        textPassword.setText(model.getValueAt(row, 2).toString());
        cmbRole.setSelectedItem(model.getValueAt(row, 3).toString());
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        if ( !textName.getText().equals("") && !textPassword.getText().equals("") ) {
            DefaultTableModel model = (DefaultTableModel)usersTable.getModel();        
            String role = null;
            int id = model.getRowCount() + 1;
            switch (cmbRole.getSelectedIndex()) {
                case 0:
                    role="Comprador";
                    break;
                case 1:
                    role="Vendedor";
                    break;
                case 2:
                    role="Administrador";
                    break;
            }
            model.addRow(new Object[]{id, textName.getText(), textPassword.getText(), role});
            usersTable.setModel(model);
            
            textName.setText("");
            textPassword.setText("");
            cmbRole.setSelectedIndex(0);
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        int row = usersTable.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
            model.setValueAt(textName.getText().trim(), row, 1);
            model.setValueAt(textPassword.getText().trim(), row, 2);
            String role = null;
            switch (cmbRole.getSelectedIndex()) {
                case 0:
                    role="Comprador";
                    break;
                case 1:
                    role="Vendedor";
                    break;
                case 2:
                    role="Administrador";
                    break;
            }
            model.setValueAt(role, row, 3);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int row = usersTable.getSelectedRow();
        
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
            
            String id = model.getValueAt(row, 0).toString();
            
            if (!this.loginUser.getId().equals(id)) {
        
                int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar este usuario", "Eliminar usuario", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(resp == 0) {
                    model.removeRow(row);
                    
                    textName.setText("");
                    textPassword.setText("");
                    cmbRole.setSelectedIndex(0);                    
                }
            
            } else {
                JOptionPane.showMessageDialog(null, "El usuario logueado no se puede eliminar", "Eliminar Usuario", JOptionPane.INFORMATION_MESSAGE);                        
            }
        
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el usuario que desea eliminar", "Eliminar Usuario", JOptionPane.INFORMATION_MESSAGE);            
        }
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        FrmLogin frmlogin = new FrmLogin();
        frmlogin.setVisible(true);
        frmlogin.setLocationRelativeTo(null);                                                        
        
        this.dispose();
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        
        DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
        ArrayList<Users> arrayUsers = new ArrayList<>();

        for (int i=0; i<model.getRowCount(); i++) {                
            switch (model.getValueAt(i, 3).toString()) {
                case "Comprador":
                    arrayUsers.add(new Customer(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString()));
                    break;
                case "Vendedor":
                    arrayUsers.add(new Vendor(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString()));
                    break;
                case "Administrador":
                    arrayUsers.add(new Admin(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString()));
                    break;
            }
            
        }
        
        Controller ctrl = new Controller();
        boolean isSaved = ctrl.saveUsers(arrayUsers);
        
        if ( isSaved ) {
            JOptionPane.showMessageDialog(null, "Información guardada con éxito", "Usuarios", JOptionPane.INFORMATION_MESSAGE);  
            
            FrmLogin frmlogin = new FrmLogin();
            frmlogin.setVisible(true);
            frmlogin.setLocationRelativeTo(null);                                                        
            
            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar los datos", "Usuarios", JOptionPane.ERROR_MESSAGE);                        
        }
    }



    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPaswword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTable usersTable;
    
}
