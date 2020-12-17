package Model;

import java.util.ArrayList;
import android.database.Cursor;


public class Message extends DataAccess {

    private int id;


    public int getId() {
        return id;
    }


    public void setId(int ID) {
        id = ID;
    }


    public ArrayList<DataMessage> getAllOfMessage() {
        DataMessage.clear();
        openDatabase();
        String sql = "SELECT * from message";

        Cursor cursor = newDb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            DataMessage data = new DataMessage();

            data.id = cursor.getInt(cursor.getColumnIndex("id"));
            data.text = cursor.getString(cursor.getColumnIndex("text"));
            data.title = cursor.getString(cursor.getColumnIndex("title"));
            data.read = cursor.getInt(cursor.getColumnIndex("read"));

            DataMessage.add(data);
        }
        cursor.close();
        newDb.close();
        return DataMessage;

    }


    public void updateReadMessage() {
        openDatabase();
        String sql = "update message set read=0 where id='" + getId() + "'";
        newDb.execSQL(sql);
        newDb.close();

    }
}
