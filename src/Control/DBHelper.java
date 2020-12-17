package Control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alireza.amiri.resketi.G;


public class DBHelper extends SQLiteOpenHelper {

    private final Context context;


    public DBHelper(Context context) {
        super(context, G.DB_NAME, null, 1);
        this.context = context;
        new File(G.DB_PATH).mkdirs();

    }


    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();
        if (dbExist) {

        } else {

            this.getReadableDatabase();

            try {
                copyDataBase();

            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }


    private boolean checkDataBase() {
        File dbFile = new File(G.DB_PATH + G.DB_NAME);
        return dbFile.exists();
    }


    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(G.DB_NAME);
        String outFileName = G.DB_PATH + G.DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;

        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);

        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }


    @Override
    public void onCreate(SQLiteDatabase arg0) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}