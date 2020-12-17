package Model;

import java.io.IOException;
import java.util.ArrayList;
import com.alireza.amiri.resketi.G;
import Control.DBHelper;
import android.database.sqlite.SQLiteDatabase;


public class DataAccess {

    public SQLiteDatabase  newDb;
    private DBHelper       DbHelper;
    private String         myPath      = G.DB_PATH + G.DB_NAME;
    ArrayList<DataBakery>        Data        = new ArrayList<DataBakery>();
    ArrayList<DataMessage> DataMessage = new ArrayList<DataMessage>();


    public void copyDatabase() {
        DbHelper = new DBHelper(G.context);
        try {
            DbHelper.createDataBase();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openDatabase() {
        newDb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }


    public int command(String sql) {
        newDb.execSQL(sql);
        newDb.close();
        return 1;
    }

}
