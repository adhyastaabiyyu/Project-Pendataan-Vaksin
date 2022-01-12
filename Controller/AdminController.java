package Controller;
import Entity.AdminEntity;
public class AdminController{
    
    public void insertData(String nip,String nama, String alamat, String password, String no_telp){
    AllObjectModel.adminmodel.insertData(new AdminEntity(nip,nama,alamat,password,no_telp));
    }
    public void deleteData(int id){
    AllObjectModel.adminmodel.deleteData(id);
    }
    public void updatePassword(String pass, int id){
    AllObjectModel.adminmodel.updatePassword(pass, id);
    }
    public void updateNoTelp(String noTelp, int id){
    AllObjectModel.adminmodel.updateNoTelp(noTelp, id);
    }
    
    public int login(String nip, String password){
    int log = AllObjectModel.adminmodel.cekLogin(nip, password);
            return log;
    }
   
}
 
