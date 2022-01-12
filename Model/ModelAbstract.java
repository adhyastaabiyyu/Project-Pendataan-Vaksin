package Model;

import Helper.KoneksiDb;

import java.sql.Connection;

public abstract class ModelAbstract {
    public Connection conn = KoneksiDb.getconection();

    public abstract void updatenoTelp(String noTelp,int id);

    public abstract void updateNoTelp(String noTelp, int id);
}
