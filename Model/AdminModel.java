package Model;
import Entity.AdminEntity;
import java.sql.*;

public class AdminModel extends ModelAbstract {
    private String sql;
    
    public void insertData(AdminEntity adminEntity){
    try{
    sql = "INSERT INTO Admin(nip, nama, alamat, password, noTelp)values(?,?,?,?,?)";
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, adminEntity.getNip());
    stat.setString(2, adminEntity.getNama());
    stat.setString(3, adminEntity.getAlamat());
    stat.setString(4, adminEntity.getPassword());
    stat.setString(5, adminEntity.getNoTelp());
    
    int rows = stat.executeUpdate();
    System.out.println(rows + "rows(s)update!");
    } catch (SQLException e){
    System.out.println("GAGAL INPUT DATA!!");
    e.printStackTrace();
    }
    }
    
     public void updatePassword(String password, int id){
    try{
    sql = "Update admin SET password =? WHERE id=?";
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1,password);
    stat.setInt(2,id);
    int rows = stat.executeUpdate();
    System.out.println(rows + "row(s) update!");
    }catch (SQLException e){
    System.out.println("GAGAL RUBAH PASWWORD!!");
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
    
     public int cekLogin(String nip, String password){
    int cek = 0;
    try{
    sql = "SELECT *FROM admin where nip =? and password =?";
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, nip);
    stat.setString(2, password);
    ResultSet rs = stat.executeQuery();
    if(rs.next()){
    cek = rs.getInt("id");
    String nama = rs.getString("nama");
    System.out.println("Selamat Datang" +nama);
    }else {
    cek = 0;
    }
    }catch (Exception e){
    e.printStackTrace();
    }return cek;
    }
     
 
      public void deleteData(int id){
     try{
     sql = "DELETE FROM penduduk WHERE id =?";
     PreparedStatement stat = conn.prepareStatement(sql);
     stat.setInt(1, id);
     int row = stat.executeUpdate();
     System.out.println(row +"row(s) DELETE");
     }catch (SQLException e){
         System.out.println("GAGAL HAPUS DATA!!");
         System.out.println(e);
     }
     }
}
