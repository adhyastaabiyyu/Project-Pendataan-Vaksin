package Model;
import Entity.PendudukEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PendudukModel extends ModelAbstract {
    private String sql;
 
    public ArrayList<PendudukEntity> getPenduduk(){
        ArrayList<PendudukEntity> arraylistPenduduk = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from penduduk";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                
                PendudukEntity pendudukEntity = new PendudukEntity();
                pendudukEntity.setId(rs.getInt("id"));
                pendudukEntity.setNik(rs.getString("nik"));
                pendudukEntity.setNama(rs.getString("nama"));
                pendudukEntity.setAlamat(rs.getString("alamat"));
                pendudukEntity.setNoTelp(rs.getString("noTelp"));
                pendudukEntity.setdosis(rs.getString("dosis"));
                pendudukEntity.setjenisvaksin(rs.getString("jenisvaksin"));
                arraylistPenduduk.add(pendudukEntity);
                
            }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistPenduduk;
    }
    
    public ArrayList<PendudukEntity> getPenduduk(int id) {
    ArrayList<PendudukEntity> arrPenduduk = new ArrayList<>();
     try {
     sql = "SELECT *FROM penduduk where id ?";
     PreparedStatement stat = conn.prepareStatement(sql);
     stat.setInt(1,id);
     ResultSet rs = stat.executeQuery();
     while(rs.next()){
         PendudukEntity pendudukEntity = new PendudukEntity();
              pendudukEntity.setId(rs.getInt("id"));
              pendudukEntity.setNik(rs.getString("nik"));
                pendudukEntity.setNama(rs.getString("nama"));
                pendudukEntity.setAlamat(rs.getString("alamat"));
                pendudukEntity.setNoTelp(rs.getString("noTelp"));
                pendudukEntity.setdosis(rs.getString("dosis"));
                pendudukEntity.setjenisvaksin(rs.getString("jenisvaksin"));
                arrPenduduk.add(pendudukEntity);
     } 
     }catch (SQLException e){
     e.printStackTrace();
     } return arrPenduduk;
    }
    
    public void insertData(PendudukEntity PendudukEntity){
    try {
    sql = "INSERT INTO penduduk (nik, nama, alamat, noTelp, dosis, jenisvaksin) VALUE(?,?,?,?,?,?)";
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, PendudukEntity.getNik());
    stat.setString(2, PendudukEntity.getNama());
    stat.setString(3, PendudukEntity.getAlamat());
    stat.setString(4, PendudukEntity.getNoTelp());
    stat.setString(5, PendudukEntity.getdosis());
    stat.setString(6, PendudukEntity.getjenisvaksin());
    
    int rows = stat.executeUpdate();
    System.out.println(rows + "rows(s)update!");
    } catch (SQLException e){
    System.out.println("GAGAL INPUT DATA!!");
    e.printStackTrace();
    }
    }    
    public void updateDosis(String dosis, int id){
    try{
    sql = "Update penduduk SET dosis =? WHERE id=?";
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1,dosis);
    stat.setInt(2,id);
    int rows = stat.executeUpdate();
    System.out.println(rows + "row(s) update!");
    }catch (SQLException e){
    System.out.println("GAGAL RUBAH dosis!!");
    System.out.println(e);
    }
    }
    @Override
    public void updatenoTelp(String noTelp, int id) {
        try{
            sql = "UPDATE penduduk SET noTelp = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows+" row(s) updated ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateNoTelp(String noTelp, int id){
        try{
            sql = "UPDATE penduduk SET noTelp = ? WHERE id = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows+" row(s) updated ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int cekData(String nik){
    int cek = 0;
    try{
    sql = "SELECT *FROM penduduk where nik =?";
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, nik);
    ResultSet rs = stat.executeQuery();
    if(rs.next()){
        cek = rs.getInt("nik");
    }else {
    cek = 0;
    }
    }catch (Exception e){
    e.printStackTrace();
    }return cek;
    }

}
