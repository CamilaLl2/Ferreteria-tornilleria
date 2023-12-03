
package ferreteriatornillo.UserInterfaces;

import ferreteriatornillo.Logic.Comment;
import ferreteriatornillo.Logic.Controller;
import ferreteriatornillo.Logic.Product;
import ferreteriatornillo.Logic.Users;
import ferreteriatornillo.Logic.Util;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FrmComments extends javax.swing.JFrame {
    private Product product;
    private Users user;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    
    public FrmComments() {
        initComponents();              
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        textProduct = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComments = new javax.swing.JTable();
        lblComment = new javax.swing.JLabel();
        textComment = new javax.swing.JTextField();
        btnAddComment = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(null);

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); 
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Ferreteria \"El Tornillo\"");

        lblSubtitle.setFont(new java.awt.Font("Ubuntu", 1, 18)); 
        lblSubtitle.setText("Comentarios");

        lblProduct.setText("Producto:");

        textProduct.setEditable(false);

        tblComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "Comentario", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComments);
        if (tblComments.getColumnModel().getColumnCount() > 0) {
            tblComments.getColumnModel().getColumn(0).setMinWidth(40);
            tblComments.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblComments.getColumnModel().getColumn(1).setMinWidth(300);
            tblComments.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblComments.getColumnModel().getColumn(2).setMinWidth(60);
            tblComments.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        lblComment.setText("Comentar:");

        btnAddComment.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/comments_add.png")); // NOI18N
        btnAddComment.setText("...");
        btnAddComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCommentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblComment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textComment, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddComment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(lblSubtitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubtitle)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduct)
                    .addComponent(textProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddComment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblComment)
                        .addComponent(textComment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btnSave1.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/disk.png")); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        btnClose1.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/door_in.png")); // NOI18N
        btnClose1.setText("Cerrar");
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnAddCommentActionPerformed(java.awt.event.ActionEvent evt) {
        if (!textComment.getText().equals("")) {
            Controller ctrl = new Controller();
            ArrayList<Comment> arrayComments = ctrl.getAllComments();
            int id = arrayComments.size() + 1;

            DefaultTableModel model = (DefaultTableModel)tblComments.getModel(); 

            model.addRow(new Object[]{id, textComment.getText(), this.user.getName()});
            tblComments.setModel(model);       

            textComment.setText("");        
        } else {
            JOptionPane.showMessageDialog(null, "Olvido escribir el comentario", "Nuevo Comentario", JOptionPane.INFORMATION_MESSAGE);                        
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        textProduct.setText(this.product.getTitle());
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Comentario");
        model.addColumn("Usuario");
        
        Comment comment = null;
        
        Controller ctrl = new Controller();
        ArrayList<Comment> arrayComments = ctrl.getComments(this.product);
        
        for (int i = 0; i < arrayComments.size(); i++) {
            comment = arrayComments.get(i);
            model.addRow(new Object[]{comment.getId(), comment.getComment(), comment.getUser().getName()});
        }
        
        tblComments.setModel(model);
        
        tblComments.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tblComments.setRowHeight(30);

        int[] arrCol = {40,450,120};        
        
        Util u = new Util();
        u.tableFmt(tblComments, arrCol);       
        
    }

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {
        Controller ctrl = new Controller();

        DefaultTableModel model = (DefaultTableModel)tblComments.getModel();
        ArrayList<Comment> arrayComments = new ArrayList<>();

        for (int i=0; i<model.getRowCount(); i++) {                
            arrayComments.add(new Comment(model.getValueAt(i, 0).toString(), this.product, this.user, model.getValueAt(i, 1).toString()));
        }

        boolean isSaved = ctrl.setComments(arrayComments);
        
        if ( isSaved ) {
            JOptionPane.showMessageDialog(null, "Información guardada con éxito", "Productos", JOptionPane.INFORMATION_MESSAGE);            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar los datos", "Productos", JOptionPane.ERROR_MESSAGE);                        
        }
    }

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private javax.swing.JButton btnAddComment;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnSave1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblComments;
    private javax.swing.JTextField textComment;
    private javax.swing.JTextField textProduct;
   
    
}