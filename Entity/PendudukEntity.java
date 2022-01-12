package Entity;

public class PendudukEntity extends UserEntityAbstract {
    private String nik;
    private String dosis;
    private String jenisvaksin;
    private int status;
    
    
    public PendudukEntity(){};

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
    
    public String getdosis(){
    return dosis;
    }
    
    public void setdosis(String dosis){
    this.dosis = dosis;
    }

    public String getjenisvaksin() {
        return jenisvaksin;
    }

    public void setjenisvaksin(String jenisvaksin) {
        this.jenisvaksin = jenisvaksin;
    }
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
}
