/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_ui;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mclay
 */
public class verifikasi extends javax.swing.JFrame {
    Connection con;
    Statement st;
    ResultSet rs;
    String query;
    Koneksi db = new Koneksi();
    
    String user = LoginForm.getPengguna();
    private DefaultTableModel model;

    /**
     * Creates new form verifikasi
     */
    int xMouse;
    int yMouse;
    public verifikasi() {
        initComponents();
         this.model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblriwayat.setModel(model);
        model.addColumn("Id Pemesanan");
        model.addColumn("Username");
        model.addColumn("Film");
        model.addColumn("Studio");
        model.addColumn("Kursi");
        model.addColumn("Tanggal Tayang");
        model.addColumn("Waktu Tayang");
        model.addColumn("Harga");
        model.addColumn("Tanggal Pemesanan");
        model.addColumn("Status");
        model.addColumn("Kasir");
        GetDataRiwayat();
        
    }
    public void GetDataRiwayat(){
        try{
            con = db.con;
            query = "select distinct pesan.id_pesan, pesan.username, film.judul_film, studio.nama_studio, kursi.nama_kursi, \n"
                    + "tanggal.tanggal, waktu.waktu_mulai, tarif.harga, pesan.tanggal_pemesanan,"
                    + " pesan.status, pesan.username_kasir \n"
                    + "from film, studio, kursi, tanggal, waktu, tarif, "
                    + "tempat, jadwal, tayang, pesan, pengguna, kasir\n"
                    + "where pesan.id_tayang = tayang.id_tayang and tayang.id_film = film.id_film and \n"
                    + "tempat.id_studio = studio.id_studio and tempat.id_kursi = kursi.id_kursi and \n"
                    + "jadwal.tanggal = tanggal.tanggal and jadwal.id_waktu = waktu.id_waktu and \n"
                    + "jadwal.id_tarif = tarif.id_tarif and tayang.id_tempat = tempat.id_tempat and \n"
                    + "tayang.id_jadwal = jadwal.id_jadwal and pesan.username = pengguna.username "
                    + "order by pesan.tanggal_pemesanan";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                Object[] obj = new Object[11];
                obj[0] = rs.getString("id_pesan");
                obj[1] = rs.getString("username");
                obj[2] = rs.getString("judul_film");
                obj[3] = rs.getString("nama_studio");
                obj[4] = rs.getString("nama_kursi");
                obj[5] = rs.getString("tanggal");
                obj[6] = rs.getString("waktu_mulai");
                obj[7] = rs.getString("harga");
                obj[8] = rs.getString("tanggal_pemesanan");
                obj[9] = rs.getString("status");
                obj[10] = rs.getString("username_kasir");
                
                
                model.addRow(obj);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void DelTable(){
        int baris = model.getRowCount();
        for(int i=0 ; i<baris ; i++){
            model.removeRow(0);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblriwayat = new javax.swing.JTable();
        search = new javax.swing.JButton();
        verif = new javax.swing.JButton();
        pesan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        kGradientPanel1.setEndColor(new java.awt.Color(153, 204, 255));

        tblriwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblriwayat);

        kGradientPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 80, 950, 290);

        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        kGradientPanel1.add(search);
        search.setBounds(550, 400, 90, 23);

        verif.setText("VERIFIKASI");
        verif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifActionPerformed(evt);
            }
        });
        kGradientPanel1.add(verif);
        verif.setBounds(660, 400, 100, 23);

        pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanActionPerformed(evt);
            }
        });
        kGradientPanel1.add(pesan);
        pesan.setBounds(360, 400, 170, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Pemesanan : ");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(230, 400, 130, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Verifikasi Pembelian Tiket");
        kGradientPanel1.add(jLabel4);
        jLabel4.setBounds(380, 20, 300, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Logout_Rounded_Up_50px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(970, 420, 50, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1028, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:try{
            DelTable();
            try{
                con = db.con;
                query = "select distinct pesan.id_pesan, pesan.username, film.judul_film, studio.nama_studio, kursi.nama_kursi, \n"
                + "tanggal.tanggal, waktu.waktu_mulai, tarif.harga, pesan.tanggal_pemesanan,"
                + " pesan.status, pesan.username_kasir \n"
                + "from film, studio, kursi, tanggal, waktu, tarif, "
                + "tempat, jadwal, tayang, pesan, pengguna, kasir\n"
                + "where pesan.id_tayang = tayang.id_tayang and tayang.id_film = film.id_film and \n"
                + "tempat.id_studio = studio.id_studio and tempat.id_kursi = kursi.id_kursi and \n"
                + "jadwal.tanggal = tanggal.tanggal and jadwal.id_waktu = waktu.id_waktu and \n"
                + "jadwal.id_tarif = tarif.id_tarif and tayang.id_tempat = tempat.id_tempat and \n"
                + "tayang.id_jadwal = jadwal.id_jadwal and pesan.username = pengguna.username and \n"
                + "pesan.id_pesan ='"+pesan.getText()+"'";
                st = (Statement) con.createStatement();
                rs = st.executeQuery(query);

                while(rs.next()){
                    Object[] obj = new Object[11];
                    obj[0] = rs.getString("id_pesan");
                    obj[1] = rs.getString("username");
                    obj[2] = rs.getString("judul_film");
                    obj[3] = rs.getString("nama_studio");
                    obj[4] = rs.getString("nama_kursi");
                    obj[5] = rs.getString("tanggal");
                    obj[6] = rs.getString("waktu_mulai");
                    obj[7] = rs.getString("harga");
                    obj[8] = rs.getString("tanggal_pemesanan");
                    obj[9] = rs.getString("status");
                    obj[10] = rs.getString("username_kasir");

                    model.addRow(obj);
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_searchActionPerformed

    private void verifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "VERIFIKASI PEMBAYARAN ?", "CONFIRM VERIFIKASI TIKET", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            int i = tblriwayat.getSelectedRow();

            String id_pesan = tblriwayat.getValueAt(i, 0).toString();

            try{
                con = db.con;
                st = (Statement) con.createStatement();
                query = "update pesan set status = 'LUNAS', username_kasir = '"+user+"' where id_pesan = '"+id_pesan+"'";
                st.executeUpdate(query);

                //query2 = "delete from tayang where id_tayang = '"+id_tayang+"'";
                //st2.executeUpdate(query2);
                System.out.println("verifikasi berhasil");
                JOptionPane.showMessageDialog(null, "Verifikasi Berhasil");
               DelTable();
               GetDataRiwayat();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_verifActionPerformed

    private void pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesanActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(verifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verifikasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField pesan;
    private javax.swing.JButton search;
    private javax.swing.JTable tblriwayat;
    private javax.swing.JButton verif;
    // End of variables declaration//GEN-END:variables
}
