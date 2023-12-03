
package ferreteriatornillo.UserInterfaces;
import ferreteriatornillo.Logic.Comment;
import ferreteriatornillo.Logic.Controller;
import ferreteriatornillo.Logic.Product;
import ferreteriatornillo.Logic.ShopingCart;
import ferreteriatornillo.Logic.Users;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class FrmShop extends javax.swing.JFrame {

    private Users loginUser;
    
    private ArrayList<Product> data;
    
    private ArrayList<ShopingCart> shopinCart = new ArrayList<>();
    
    private int position = 0;
    
    private double total = 0;
    

    public void setLoginUser(Users user) {
        this.loginUser = user;
    }

    public void setShopinCart(ArrayList<ShopingCart> shopinCart) {
        this.shopinCart = shopinCart;
    }
    
    private void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
            image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT)
        );
        labelName.setIcon(icon);
        this.repaint();
    }
    
    private void fillText() {
        
        setImageLabel(lblImage, this.data.get(this.position).getImgName());
                    
        textTitle.setText(this.data.get(this.position).getTitle());

        textDescription.setText(this.data.get(this.position).getDescription());

        textPrice.setText(Double.toString(this.data.get(this.position).getPrice()));
        
        textStock.setText(Integer.toString(this.data.get(this.position).getStock()));
        
        textAmount.setValue(1);      
        
        Product p = this.data.get(this.position);
        Controller ctrl = new Controller();
        ArrayList<Comment> comment = ctrl.getComments(p);
        textCommentAmount.setText(String.valueOf(comment.size()));
        
    }
    
    
    
    public FrmShop() {
        initComponents();
        
        Controller ctrl = new Controller();
        this.data = ctrl.getProducts();

        fillText();
        
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnShowCart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textItemsCart = new javax.swing.JTextField();
        textValueCart = new javax.swing.JTextField();
        btnClearCart = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        textDescription = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        textPrice = new javax.swing.JTextField();
        textStock = new javax.swing.JTextField();
        textTitle = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        btnTop = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBottom = new javax.swing.JButton();
        lblStock1 = new javax.swing.JLabel();
        textAmount = new javax.swing.JSpinner();
        btnAddCart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textCommentAmount = new javax.swing.JTextField();
        btnShowComments = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tienda");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ferreteria \"El Tornillo\"");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnShowCart.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/cart_put.png")); // NOI18N
        btnShowCart.setText("Ver Carro de Compras");
        btnShowCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowCartActionPerformed(evt);
            }
        });

        jLabel2.setText("Cantidad de items:");

        jLabel3.setText("Importe:");

        textItemsCart.setEditable(false);
        textItemsCart.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textValueCart.setEditable(false);
        textValueCart.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnClearCart.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/cart_remove.png")); // NOI18N
        btnClearCart.setText("Vaciar Carro de Compras");
        btnClearCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCartActionPerformed(evt);
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
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textItemsCart, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(textValueCart, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnShowCart, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearCart, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textItemsCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textValueCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Productos para la Venta");

        jPanel3.setOpaque(false);

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImage.setOpaque(true);

        lblDescription.setText("Descripción:");

        textDescription.setEditable(false);
        textDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescriptionActionPerformed(evt);
            }
        });

        lblStock.setText("Disponible:");

        lblPrice.setText("Precio:");

        textPrice.setEditable(false);
        textPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        textStock.setEditable(false);
        textStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textTitle.setEditable(false);

        lblTitle.setText("Título:");

        btnTop.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/control_start_blue.png")); // NOI18N
        btnTop.setText("Inicio");
        btnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/control_rewind_blue.png")); // NOI18N
        btnPrev.setText("Anterior");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/control_fastforward_blue.png")); // NOI18N
        btnNext.setText("Siguiente");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBottom.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/control_end_blue.png")); // NOI18N
        btnBottom.setText("Fin");
        btnBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBottomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStock)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(lblTitle))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblDescription))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDescription)
                    .addComponent(textTitle)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(lblPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle)
                            .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescription))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStock)
                            .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice)
                            .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lblStock1.setText("Cantidad:");

        btnAddCart.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/cart_add.png")); // NOI18N
        btnAddCart.setText("Adicionar al Carrito");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        jLabel5.setText("Comentarios:");

        textCommentAmount.setEditable(false);
        textCommentAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnShowComments.setIcon(new javax.swing.ImageIcon("/home/migue/NetBeansProjects/FerreteriaTornillo/src/resources/comments.png")); // NOI18N
        btnShowComments.setText("Mostrar Comentarios");
        btnShowComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowCommentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(322, 322, 322))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStock1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCommentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowComments, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock1)
                    .addComponent(textAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(textCommentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowComments, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public void clearShoppingCart() {
        if ( this.shopinCart.size() > 0 ) {
            this.shopinCart.clear();
            this.total = 0;
            textItemsCart.setText("");
            textValueCart.setText(Double.toString(this.total));
        } else {
            JOptionPane.showMessageDialog(null, "Su carro de compras esta vacio", "Carro de Compras", JOptionPane.INFORMATION_MESSAGE);                
        }        
    }
    
    private void textDescriptionActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.data.size() - 1 > this.position) {
            this.position = this.position + 1;
        } else {
            this.position = 0;
        }
        fillText();
    }

    private void btnTopActionPerformed(java.awt.event.ActionEvent evt) {
        this.position = 0;
        fillText();
    }

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.position > 0) {
            this.position = this.position - 1;            
        } else {
            this.position = this.data.size() - 1;
        }
        fillText();
    }

    private void btnBottomActionPerformed(java.awt.event.ActionEvent evt) {
        this.position = this.data.size() - 1;
        fillText();
    }

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {
        int amount = (int) textAmount.getValue();
        int stock = Integer.parseInt(textStock.getText());
        
        if (stock >= amount) {
            
            textStock.setText(Integer.toString(stock-amount));
            Product p = this.data.get(this.position);
            p.setStock(stock-amount);
            this.data.set(this.position, p);
        
            this.shopinCart.add(new ShopingCart(this.data.get(this.position), amount));

            this.total = this.total + ( amount * Double.parseDouble(textPrice.getText()) );

            textItemsCart.setText(Integer.toString(this.shopinCart.size()));
            textValueCart.setText(Double.toString(this.total));
            textAmount.setValue(1);
        
        } else {
            JOptionPane.showMessageDialog(null, "No existe disponibilidad, de este producto", "Carro de Compras", JOptionPane.INFORMATION_MESSAGE);                            
        }
        
    }

    private void btnShowCartActionPerformed(java.awt.event.ActionEvent evt) {
        if ( this.shopinCart.size() > 0 ) {
            FrmCart cart = new FrmCart();
            cart.setShopinCart(this.shopinCart);
            cart.setVisible(true);
            cart.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Su carro de compras esta vacio", "Carro de Compras", JOptionPane.INFORMATION_MESSAGE);                
        }
    }

    private void btnClearCartActionPerformed(java.awt.event.ActionEvent evt) {
        clearShoppingCart();
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        FrmLogin frmlogin = new FrmLogin();
        frmlogin.setVisible(true);
        frmlogin.setLocationRelativeTo(null);                                                        
        
        this.dispose();
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        if (textItemsCart.getText().equals("")) {
            this.shopinCart.clear();
        }
        fillText();
    }

    private void btnShowCommentsActionPerformed(java.awt.event.ActionEvent evt) {
        Product prod = this.data.get(this.position);
        
        FrmComments frmComments = new FrmComments();
        
        frmComments.setProduct(prod);
        frmComments.setUser(loginUser);
        
        frmComments.setVisible(true);
        frmComments.setLocationRelativeTo(null);
    }


    
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnBottom;
    private javax.swing.JButton btnClearCart;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnShowCart;
    private javax.swing.JButton btnShowComments;
    private javax.swing.JButton btnTop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblStock1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSpinner textAmount;
    private javax.swing.JTextField textCommentAmount;
    private javax.swing.JTextField textDescription;
    public static javax.swing.JTextField textItemsCart;
    private javax.swing.JTextField textPrice;
    private javax.swing.JTextField textStock;
    private javax.swing.JTextField textTitle;
    public static javax.swing.JTextField textValueCart;
   
}
