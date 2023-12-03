
package ferreteriatornillo.UserInterfaces;

import ferreteriatornillo.Logic.Controller;
import ferreteriatornillo.Logic.Product;
import ferreteriatornillo.Logic.ShopingCart;
import ferreteriatornillo.Logic.Util;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class FrmCart extends javax.swing.JFrame {
       
    private ArrayList<ShopingCart> shopinCart = new ArrayList<>();

    public ArrayList<ShopingCart> getShopinCart() {
        return shopinCart;
    }
    
    public Product getProduct(String id) {
        Product prod = null;
        Controller ctrl = new Controller();
        ArrayList<Product> arrayProducts = ctrl.getProducts();
        for (int i = 0; i < arrayProducts.size(); i++) {
            if (arrayProducts.get(i).getId().equals(id)) {
                prod = arrayProducts.get(i);
                break;
            }
        }
        return prod;
    }
    
    public void fillCart() {
        ArrayList<ShopingCart> cart = this.getShopinCart();

        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Importe");
        
        double total = 0;
        
        for (int i = 0; i < cart.size(); i++) {
            ShopingCart c = cart.get(i);
            Product prod = getProduct(c.getProduct().getId());
            model.addRow(new Object[]{prod.getTitle(), prod.getPrice(), c.getAmount(), Double.toString(prod.getPrice()*c.getAmount())});
            total = total + prod.getPrice()*c.getAmount();
        }
      
        tblCart.setModel(model);
        
        tblCart.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tblCart.setRowHeight(30);
        textTotal.setText(Double.toString(total));
        
        
        int[] arrCol = {300,80,80,80};        
        Util u = new Util();
        u.tableFmt(tblCart, arrCol);       
        
    }

    public void setShopinCart(ArrayList<ShopingCart> shopinCart) {
        this.shopinCart = shopinCart;
        fillCart();        
    }
      

    
    public FrmCart() {
        initComponents();   
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carro de Compras");
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Carro de Compras");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setPreferredWidth(300);
            tblCart.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblCart.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblCart.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPay.setText("Pagar");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel2.setText("Total a Pagar:");

        textTotal.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay)
                    .addComponent(btnClose))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {
      
        Controller ctrl = new Controller();
        ArrayList<Product> arrayProducts = new ArrayList<>();
        arrayProducts = ctrl.getProducts();
        
        ctrl.setShopinCart(this.shopinCart);
        
        if ( ctrl.setProducts(arrayProducts) ) {
            FrmShop.textItemsCart.setText("");
            FrmShop.textValueCart.setText("");            
            JOptionPane.showMessageDialog(null, "Pago realizado con éxito", "Carro de Compras", JOptionPane.INFORMATION_MESSAGE);                          
        } else {
            JOptionPane.showMessageDialog(null, "El pago no se ha podido completar", "Carro de Compras", JOptionPane.INFORMATION_MESSAGE);                                      
        }
        
        this.setVisible(false);
    }
    
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCart;
    private javax.swing.JTextField textTotal;
    
}
