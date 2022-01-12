package Entity;

public abstract class UserEntityAbstract {
    protected int id;
    protected String nama, password, noTelp, alamat;
    public UserEntityAbstract(){
        
    }
    
    public UserEntityAbstract(String nama, String password, String noTelp, String alamat){
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
}