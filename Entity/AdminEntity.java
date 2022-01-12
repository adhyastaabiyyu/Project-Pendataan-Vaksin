package Entity;


public class AdminEntity extends UserEntityAbstract {
    private String nip;
    public AdminEntity(String nip, String nama, String alamat, String password, String noTelp)
    {
    super (nama,password,noTelp,alamat);
    this.nip = nip;
    }
    public String getNip() {
    return nip;
    }
    public void setNip(String nip){
    this.nip = nip;
    }
}
