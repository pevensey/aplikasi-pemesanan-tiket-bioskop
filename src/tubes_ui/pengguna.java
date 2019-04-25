/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_ui;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tubes_ui.Koneksi;
/**
 *
 * @author Yulianto Pambudi
 */
public class pengguna {
     Koneksi db=null;
     String hakakses,nama,username,password;
    
    public pengguna(){
        db=new Koneksi();
    }
     public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;   
    }
public String getHakakses() {
        return hakakses;
    }

    public void setHakakses(String hakakses) {
        this.hakakses = hakakses;
    }
    
    public List cariLogin(String user,String pass){
        List<pengguna> data=new ArrayList<>();
        ResultSet rs=null;
        try{
            String sql="SELECT * FROM pengguna WHERE USERNAME='"+user+"' AND PASSWORD='"+pass+"'";
            rs=db.ambilData(sql);
                        
            while(rs.next()){                   
                pengguna pm=new pengguna();   
                pm.setNama(rs.getString("nama_pengguna"));
                pm.setUsername(rs.getString("username"));
                pm.setPassword(rs.getString("password"));   
                pm.setHakakses(rs.getString("hakAkses"));   
                data.add(pm);
            }               
            db.tutupKoneksi(rs);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, "Login gagal, Pesan Error : \n"+x);
        }        
        return data;
    }     
}
