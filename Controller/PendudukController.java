package Controller;
import Entity.PendudukEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class  PendudukController {
    public void insertData(String nik, String nama, String alamat, String no_telp, String dosis, String jenisvaksin){
    PendudukEntity pendudukEntities = new PendudukEntity();
    pendudukEntities.setNik(nik);
    pendudukEntities.setNama(nama);
    pendudukEntities.setAlamat(alamat);
    pendudukEntities.setNoTelp(no_telp);
    pendudukEntities.setdosis(dosis);
    pendudukEntities.setjenisvaksin(jenisvaksin);
    AllObjectModel.pendudukModel.insertData(pendudukEntities);
    }
    public void updateDosis(String dosis, int id){
    AllObjectModel.pendudukModel.updateDosis(dosis, id);
    }
    
    public void updatenoTelp(String notelp, int id){
    AllObjectModel.pendudukModel.updateNoTelp(notelp, id);
    }
    public ArrayList<PendudukEntity> getDataPenduduk(){
    return AllObjectModel.pendudukModel.getPenduduk();
    }

    public ArrayList<PendudukEntity> getByid(int cekData){
    return AllObjectModel.pendudukModel.getPenduduk(cekData);
    } 
    
    public int CekData(String nik){
        int cek = AllObjectModel.pendudukModel.cekData(nik);
        return cek;
    }
    public DefaultTableModel daftarpenduduk(){
        DefaultTableModel dataDaftarPenduduk = new DefaultTableModel();
        Object[] kolom = {"ID", "NIK", "NAMA", "ALAMAT", "NOTELP", "DOSIS", "JENISVAKSIN"};
        dataDaftarPenduduk.setColumnIdentifiers(kolom);
        int size = getDataPenduduk().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[7];
            data[0] = AllObjectModel.pendudukModel.getPenduduk().get(i).getId();
            data[1] = AllObjectModel.pendudukModel.getPenduduk().get(i).getNik();
            data[2] = AllObjectModel.pendudukModel.getPenduduk().get(i).getNama();
            data[3] = AllObjectModel.pendudukModel.getPenduduk().get(i).getAlamat();
            data[4] = AllObjectModel.pendudukModel.getPenduduk().get(i).getNoTelp();
            data[5] = AllObjectModel.pendudukModel.getPenduduk().get(i).getdosis();
            data[6] = AllObjectModel.pendudukModel.getPenduduk().get(i).getjenisvaksin();
            dataDaftarPenduduk.addRow(data);
        }
        return dataDaftarPenduduk;
    }
}
