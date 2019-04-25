/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_ui;

/**
 *
 * @author Mclay
 */
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mysql.jdbc.Statement;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class MenuPesan extends javax.swing.JFrame {
    Connection con;
    Statement st;
    ResultSet rs;
    String query;
    Koneksi db = new Koneksi();
    private DefaultTableModel model;
    String user = LoginForm.getPengguna();

    /**
     * Creates new form MenuPesan
     */
    int xMouse;
    int yMouse;
    public MenuPesan() {
        initComponents();
        this.model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        GetListFilm();
        GetListTanggal();
        GetListWaktu();
        GetKursi();
        tbljadwal.setModel(model);
        model.addColumn("Id Jadwal");
        model.addColumn("Judul Film");
        model.addColumn("Studio");
        model.addColumn("Kursi");
        model.addColumn("Tanggal");
        model.addColumn("Waktu");
        model.addColumn("Harga");
        tbljadwal.getColumnModel().getColumn(0).setMaxWidth(0);
        tbljadwal.getColumnModel().getColumn(0).setMinWidth(0);
        tbljadwal.getColumnModel().getColumn(0).setPreferredWidth(0);
        GetDataJadwal();
        
    }
    public void GetListFilm(){
        try{
            con = db.con;
            
            st = (Statement) con.createStatement();
            query = "SELECT * FROM film";
            rs = st.executeQuery(query);
            
            while(rs.next()){
                String film = rs.getString("judul_film");
                listfilm.addItem(film);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void GetKursi(){
       try{
           
            con = db.con;
            
            st = (Statement) con.createStatement();
            query = "SELECT * FROM kursi";
            rs = st.executeQuery(query);
             
            while(rs.next()){
                String kursi = rs.getString("nama_kursi");
                listkursi.addItem(kursi);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
    public void GetListTanggal(){
        try{
           
            con = db.con;
            
            st = (Statement) con.createStatement();
            query = "SELECT * FROM tanggal";
            rs = st.executeQuery(query);
             
            while(rs.next()){
                String tanggal = rs.getString("tanggal");
                listtanggal.addItem(tanggal);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void GetListWaktu(){
        try{
           
            con = db.con;
            
            st = (Statement) con.createStatement();
            query = "SELECT * FROM waktu";
            rs = st.executeQuery(query);
             
            while(rs.next()){
                String waktu = rs.getString("waktu_mulai");
                listwaktu.addItem(waktu);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void GetDataJadwal(){
        //menghapus isi tabel
        
         try{
            con = db.con;
            query = "SELECT distinct tayang.id_tayang, film.judul_film, studio.nama_studio, kursi.nama_kursi, \n"
                    + "tanggal.tanggal, waktu.waktu_mulai, tarif.harga \n"
                    + "from film, studio, kursi, tanggal, waktu, tarif, tempat, jadwal, tayang\n"
                    + "where tayang.id_film = film.id_film and tempat.id_kursi = kursi.id_kursi and tempat.id_studio = studio.id_studio and\n"
                    + "jadwal.tanggal = tanggal.tanggal and jadwal.id_waktu = waktu.id_waktu and\n"
                    + "jadwal.id_tarif = tarif.id_tarif and tayang.id_tempat = tempat.id_tempat and\n"
                    + "tayang.id_jadwal = jadwal.id_jadwal  and tayang.id_tayang not in \n"
                    + "(select pesan.id_tayang from pesan)";
            
            st = (Statement) con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                Object[] obj = new Object[7];
                obj[0] = rs.getString("id_tayang");
                obj[1] = rs.getString("judul_film");
                obj[2] = rs.getString("nama_studio");
                obj[3] = rs.getString("nama_kursi");
                obj[4] = rs.getString("tanggal");
                obj[5] = rs.getString("waktu_mulai");
                obj[6] = rs.getString("harga");
                
                
                model.addRow(obj);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
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

        kursi = new javax.swing.JFrame();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel14 = new javax.swing.JLabel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel17 = new javax.swing.JLabel();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jLabel16 = new javax.swing.JLabel();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();
        kGradientPanel13 = new keeptoo.KGradientPanel();
        jLabel18 = new javax.swing.JLabel();
        kGradientPanel14 = new keeptoo.KGradientPanel();
        jLabel21 = new javax.swing.JLabel();
        kGradientPanel15 = new keeptoo.KGradientPanel();
        jLabel20 = new javax.swing.JLabel();
        kGradientPanel16 = new keeptoo.KGradientPanel();
        jLabel23 = new javax.swing.JLabel();
        kGradientPanel17 = new keeptoo.KGradientPanel();
        jLabel22 = new javax.swing.JLabel();
        kGradientPanel18 = new keeptoo.KGradientPanel();
        jLabel25 = new javax.swing.JLabel();
        kGradientPanel19 = new keeptoo.KGradientPanel();
        jLabel24 = new javax.swing.JLabel();
        kGradientPanel20 = new keeptoo.KGradientPanel();
        jLabel27 = new javax.swing.JLabel();
        kGradientPanel21 = new keeptoo.KGradientPanel();
        jLabel26 = new javax.swing.JLabel();
        kGradientPanel22 = new keeptoo.KGradientPanel();
        jLabel29 = new javax.swing.JLabel();
        kGradientPanel23 = new keeptoo.KGradientPanel();
        jLabel28 = new javax.swing.JLabel();
        kGradientPanel24 = new keeptoo.KGradientPanel();
        jLabel31 = new javax.swing.JLabel();
        kGradientPanel25 = new keeptoo.KGradientPanel();
        jLabel38 = new javax.swing.JLabel();
        kGradientPanel26 = new keeptoo.KGradientPanel();
        jLabel33 = new javax.swing.JLabel();
        kGradientPanel27 = new keeptoo.KGradientPanel();
        jLabel32 = new javax.swing.JLabel();
        kGradientPanel28 = new keeptoo.KGradientPanel();
        jLabel35 = new javax.swing.JLabel();
        kGradientPanel29 = new keeptoo.KGradientPanel();
        jLabel34 = new javax.swing.JLabel();
        kGradientPanel30 = new keeptoo.KGradientPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        listfilm = new javax.swing.JComboBox();
        listkursi = new javax.swing.JComboBox();
        listtanggal = new javax.swing.JComboBox();
        listwaktu = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbljadwal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        search = new javax.swing.JButton();
        pesan = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();

        kursi.setUndecorated(true);
        kursi.setResizable(false);

        kGradientPanel5.setEndColor(new java.awt.Color(153, 153, 255));

        kGradientPanel6.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("A2");
        kGradientPanel6.add(jLabel13);
        jLabel13.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel6);
        kGradientPanel6.setBounds(80, 60, 40, 50);

        kGradientPanel7.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("A1");
        kGradientPanel7.add(jLabel12);
        jLabel12.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel7);
        kGradientPanel7.setBounds(30, 60, 40, 50);

        kGradientPanel8.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("A4");
        kGradientPanel8.add(jLabel15);
        jLabel15.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel8);
        kGradientPanel8.setBounds(180, 60, 40, 50);

        kGradientPanel9.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("A3");
        kGradientPanel9.add(jLabel14);
        jLabel14.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel9);
        kGradientPanel9.setBounds(130, 60, 40, 50);

        kGradientPanel10.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("A6");
        kGradientPanel10.add(jLabel17);
        jLabel17.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel10);
        kGradientPanel10.setBounds(280, 60, 40, 50);

        kGradientPanel11.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("A5");
        kGradientPanel11.add(jLabel16);
        jLabel16.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel11);
        kGradientPanel11.setBounds(230, 60, 40, 50);

        kGradientPanel12.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("A8");
        kGradientPanel12.add(jLabel19);
        jLabel19.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel12);
        kGradientPanel12.setBounds(450, 60, 40, 50);

        kGradientPanel13.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("A7");
        kGradientPanel13.add(jLabel18);
        jLabel18.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel13);
        kGradientPanel13.setBounds(400, 60, 40, 50);

        kGradientPanel14.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("A10");
        kGradientPanel14.add(jLabel21);
        jLabel21.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel14);
        kGradientPanel14.setBounds(550, 60, 40, 50);

        kGradientPanel15.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("A9");
        kGradientPanel15.add(jLabel20);
        jLabel20.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel15);
        kGradientPanel15.setBounds(500, 60, 40, 50);

        kGradientPanel16.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("A12");
        kGradientPanel16.add(jLabel23);
        jLabel23.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel16);
        kGradientPanel16.setBounds(650, 60, 40, 50);

        kGradientPanel17.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("A11");
        kGradientPanel17.add(jLabel22);
        jLabel22.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel17);
        kGradientPanel17.setBounds(600, 60, 40, 50);

        kGradientPanel18.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("B2");
        kGradientPanel18.add(jLabel25);
        jLabel25.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel18);
        kGradientPanel18.setBounds(80, 170, 40, 50);

        kGradientPanel19.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("B1");
        kGradientPanel19.add(jLabel24);
        jLabel24.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel19);
        kGradientPanel19.setBounds(30, 170, 40, 50);

        kGradientPanel20.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("B4");
        kGradientPanel20.add(jLabel27);
        jLabel27.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel20);
        kGradientPanel20.setBounds(180, 170, 40, 50);

        kGradientPanel21.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("B3");
        kGradientPanel21.add(jLabel26);
        jLabel26.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel21);
        kGradientPanel21.setBounds(130, 170, 40, 50);

        kGradientPanel22.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("B6");
        kGradientPanel22.add(jLabel29);
        jLabel29.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel22);
        kGradientPanel22.setBounds(280, 170, 40, 50);

        kGradientPanel23.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("B5");
        kGradientPanel23.add(jLabel28);
        jLabel28.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel23);
        kGradientPanel23.setBounds(230, 170, 40, 50);

        kGradientPanel24.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("B8");
        kGradientPanel24.add(jLabel31);
        jLabel31.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel24);
        kGradientPanel24.setBounds(450, 170, 40, 50);

        kGradientPanel25.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("LAYAR");
        kGradientPanel25.add(jLabel38);
        jLabel38.setBounds(170, 0, 50, 17);

        kGradientPanel5.add(kGradientPanel25);
        kGradientPanel25.setBounds(170, 390, 390, 20);

        kGradientPanel26.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("B10");
        kGradientPanel26.add(jLabel33);
        jLabel33.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel26);
        kGradientPanel26.setBounds(550, 170, 40, 50);

        kGradientPanel27.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("B9");
        kGradientPanel27.add(jLabel32);
        jLabel32.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel27);
        kGradientPanel27.setBounds(500, 170, 40, 50);

        kGradientPanel28.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("B12");
        kGradientPanel28.add(jLabel35);
        jLabel35.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel28);
        kGradientPanel28.setBounds(650, 170, 40, 50);

        kGradientPanel29.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("B11");
        kGradientPanel29.add(jLabel34);
        jLabel34.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel29);
        kGradientPanel29.setBounds(600, 170, 40, 50);

        kGradientPanel30.setStartColor(new java.awt.Color(51, 255, 51));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("B7");
        kGradientPanel30.add(jLabel30);
        jLabel30.setBounds(0, 0, 40, 50);

        kGradientPanel5.add(kGradientPanel30);
        kGradientPanel30.setBounds(400, 170, 40, 50);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_50px_1.png"))); // NOI18N
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        kGradientPanel5.add(jLabel36);
        jLabel36.setBounds(0, 350, 70, 60);

        javax.swing.GroupLayout kursiLayout = new javax.swing.GroupLayout(kursi.getContentPane());
        kursi.getContentPane().setLayout(kursiLayout);
        kursiLayout.setHorizontalGroup(
            kursiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        kursiLayout.setVerticalGroup(
            kursiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

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

        kGradientPanel1.setEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setStartColor(new java.awt.Color(204, 0, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SALTO BIOSKOP");
        kGradientPanel1.add(jLabel4);
        jLabel4.setBounds(280, 0, 190, 30);

        kGradientPanel2.setEndColor(new java.awt.Color(0, 204, 255));

        kGradientPanel4.setEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel4.setStartColor(new java.awt.Color(255, 51, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PESAN TIKET");
        kGradientPanel4.add(jLabel1);
        jLabel1.setBounds(0, 0, 170, 40);

        kGradientPanel2.add(kGradientPanel4);
        kGradientPanel4.setBounds(-1, -1, 170, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("PILIH FILM");
        kGradientPanel2.add(jLabel2);
        jLabel2.setBounds(10, 70, 80, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("PILIH KURSI");
        kGradientPanel2.add(jLabel3);
        jLabel3.setBounds(10, 100, 79, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 255));
        jLabel5.setText("PILIH TANGGAL");
        kGradientPanel2.add(jLabel5);
        jLabel5.setBounds(10, 130, 110, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 255));
        jLabel6.setText("PILIH WAKTU");
        kGradientPanel2.add(jLabel6);
        jLabel6.setBounds(10, 160, 90, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");
        kGradientPanel2.add(jLabel7);
        jLabel7.setBounds(120, 70, 20, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");
        kGradientPanel2.add(jLabel9);
        jLabel9.setBounds(120, 100, 20, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(":");
        kGradientPanel2.add(jLabel10);
        jLabel10.setBounds(120, 130, 20, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(":");
        kGradientPanel2.add(jLabel11);
        jLabel11.setBounds(120, 160, 20, 20);

        listfilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listfilmActionPerformed(evt);
            }
        });
        kGradientPanel2.add(listfilm);
        listfilm.setBounds(140, 70, 140, 20);

        listkursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listkursiActionPerformed(evt);
            }
        });
        kGradientPanel2.add(listkursi);
        listkursi.setBounds(140, 100, 140, 20);

        kGradientPanel2.add(listtanggal);
        listtanggal.setBounds(140, 130, 140, 20);

        listwaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listwaktuActionPerformed(evt);
            }
        });
        kGradientPanel2.add(listwaktu);
        listwaktu.setBounds(170, 160, 110, 20);

        tbljadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbljadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbljadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbljadwal);

        kGradientPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(50, 200, 620, 180);

        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(jButton1);
        jButton1.setBounds(50, 390, 90, 23);

        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        kGradientPanel2.add(search);
        search.setBounds(450, 390, 90, 23);

        pesan.setText("PESAN TIKET");
        pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanActionPerformed(evt);
            }
        });
        kGradientPanel2.add(pesan);
        pesan.setBounds(560, 390, 110, 23);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Office_Chair_100px.png"))); // NOI18N
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        kGradientPanel2.add(jLabel37);
        jLabel37.setBounds(430, 50, 160, 120);

        kGradientPanel1.add(kGradientPanel2);
        kGradientPanel2.setBounds(10, 40, 720, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(740, 479));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void listfilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listfilmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listfilmActionPerformed

    private void listkursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listkursiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listkursiActionPerformed

    private void listwaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listwaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listwaktuActionPerformed

    private void tbljadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbljadwalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbljadwalMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        MenuUtama menu = new MenuUtama();
        menu.setVisible(true);       
    }//GEN-LAST:event_jButton1ActionPerformed

    private String getTanggal(){
        DateFormat dateform = new SimpleDateFormat("yyyy:MM:dd");
        Date date = new Date();
        return dateform.format(date);
    }
    public void DelTable(){
        int baris = model.getRowCount();
        for(int i=0 ; i<baris ; i++){
            model.removeRow(0);
        }
    }
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        DelTable();
        try{
            con = db.con;
            st = (Statement) con.createStatement();
            query = "SELECT tayang.id_tayang, film.judul_film, studio.nama_studio, kursi.nama_kursi, \n"
                    + "tanggal.tanggal, waktu.waktu_mulai, tarif.harga \n"
                    + "from film, studio, kursi, tanggal, waktu, tarif, tempat, jadwal, tayang\n"
                    + "where tayang.id_film = film.id_film and tempat.id_kursi = kursi.id_kursi and tempat.id_studio = studio.id_studio and\n"
                    + "jadwal.tanggal = tanggal.tanggal and jadwal.id_waktu = waktu.id_waktu and\n"
                    + "jadwal.id_tarif = tarif.id_tarif and tayang.id_tempat = tempat.id_tempat and\n"
                    + "tayang.id_jadwal = jadwal.id_jadwal and "
                    + "kursi.nama_kursi = '" + listkursi.getSelectedItem()+"' "
                    + "and film.judul_film = '" + listfilm.getSelectedItem()+"' "
                    + "and tanggal.tanggal = '"+listtanggal.getSelectedItem()+"' "
                    + "and waktu.waktu_mulai = '"+listwaktu.getSelectedItem()+"'";
            
            rs = st.executeQuery(query);
            
            while(rs.next()){
                Object[] obj = new Object[7];
                obj[0] = rs.getString("id_tayang");
                obj[1] = rs.getString("judul_film");
                obj[2] = rs.getString("nama_studio");
                obj[3] = rs.getString("nama_kursi");
                obj[4] = rs.getString("tanggal");
                obj[5] = rs.getString("waktu_mulai");
                obj[6] = rs.getString("harga");
                
                
                model.addRow(obj);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_searchActionPerformed

    private void pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ?? ", "CONFIRM PESAN TIKET", JOptionPane.YES_NO_OPTION);
       if(n == JOptionPane.YES_OPTION){
           int i = tbljadwal.getSelectedRow();
           String id_pemesanan = tbljadwal.getValueAt(i, 0).toString();
           String kasir = "-";  
           String tanggal_pemesanan = getTanggal();
           String status = "Belum Lunas";
           try{
            con = db.con;
            
            st = (Statement) con.createStatement();
            query = "insert into pesan values "
                    + "(default, '"+id_pemesanan+"', '"+user+"', '-', '"+tanggal_pemesanan+"', 'belum lunas')";
            
            st.executeUpdate(query);
            System.out.println("pemesanan berhasil");
            JOptionPane.showMessageDialog(null, "Tiket Berhasil Dipesan");
            DelTable();
            GetDataJadwal();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
           
           
           
           
       }


    }//GEN-LAST:event_pesanActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        dispose();   
        kursi.setVisible(true);
        kursi.setSize(721,407);
        kursi.setLocationRelativeTo(this);
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        
        new MenuPesan().setVisible(true);
        kursi.dispose();
    }//GEN-LAST:event_jLabel36MouseClicked

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
            java.util.logging.Logger.getLogger(MenuPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPesan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel13;
    private keeptoo.KGradientPanel kGradientPanel14;
    private keeptoo.KGradientPanel kGradientPanel15;
    private keeptoo.KGradientPanel kGradientPanel16;
    private keeptoo.KGradientPanel kGradientPanel17;
    private keeptoo.KGradientPanel kGradientPanel18;
    private keeptoo.KGradientPanel kGradientPanel19;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel20;
    private keeptoo.KGradientPanel kGradientPanel21;
    private keeptoo.KGradientPanel kGradientPanel22;
    private keeptoo.KGradientPanel kGradientPanel23;
    private keeptoo.KGradientPanel kGradientPanel24;
    private keeptoo.KGradientPanel kGradientPanel25;
    private keeptoo.KGradientPanel kGradientPanel26;
    private keeptoo.KGradientPanel kGradientPanel27;
    private keeptoo.KGradientPanel kGradientPanel28;
    private keeptoo.KGradientPanel kGradientPanel29;
    private keeptoo.KGradientPanel kGradientPanel30;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JFrame kursi;
    private javax.swing.JComboBox listfilm;
    private javax.swing.JComboBox listkursi;
    private javax.swing.JComboBox listtanggal;
    private javax.swing.JComboBox listwaktu;
    private javax.swing.JButton pesan;
    private javax.swing.JButton search;
    private javax.swing.JTable tbljadwal;
    // End of variables declaration//GEN-END:variables
}
