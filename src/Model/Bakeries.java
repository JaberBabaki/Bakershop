package Model;

import java.util.ArrayList;
import java.util.Calendar;
import android.database.Cursor;


public class Bakeries extends DataAccess {

    private int like;
    private int id;


    public void setLike(int Like) {
        like = Like;
    }


    public int getLike() {
        return like;
    }


    public void setId(int Id) {
        id = Id;
    }


    public int getId() {
        return id;
    }


    public ArrayList<DataBakery> getAllOfBakeries() {
        Data.clear();
        openDatabase();
        String sql = "SELECT" +
                " A.id," +
                "A.name," +
                "A.address," +
                "A.phone," +
                "A.baker," +
                "A.like," +
                "A.note," +
                "A.picture," +
                "A.cooking," +
                "A.bread," +
                "B.hour," +
                "B.holiday" +
                " FROM " +
                "bakeshop A," +
                "working B " +
                "WHERE B.id_bakershop = A.id";
        Cursor cursor = newDb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            DataBakery data = new DataBakery();

            data.id = cursor.getInt(cursor.getColumnIndex("id"));
            data.name = cursor.getString(cursor.getColumnIndex("name"));
            data.address = cursor.getString(cursor.getColumnIndex("address"));
            data.phone = cursor.getString(cursor.getColumnIndex("phone"));
            data.baker = cursor.getString(cursor.getColumnIndex("baker"));
            data.like = cursor.getInt(cursor.getColumnIndex("like"));
            data.photo = cursor.getString(cursor.getColumnIndex("picture"));
            data.note = cursor.getString(cursor.getColumnIndex("note"));
            data.cooking = cursor.getString(cursor.getColumnIndex("cooking"));
            data.bread = cursor.getString(cursor.getColumnIndex("bread"));
            data.hour = cursor.getString(cursor.getColumnIndex("hour"));
            data.holiday = cursor.getString(cursor.getColumnIndex("holiday"));

            Data.add(data);
        }
        cursor.close();
        newDb.close();
        return Data;

    }


    public ArrayList<DataBakery> getAllOfLike() {
        Data.clear();
        openDatabase();
        String sql = "SELECT" +
                " A.id," +
                "A.name," +
                "A.address," +
                "A.phone," +
                "A.baker," +
                "A.like," +
                "A.note," +
                "A.picture," +
                "A.cooking," +
                "A.bread," +
                "B.hour," +
                "B.holiday" +
                " FROM " +
                "bakeshop A," +
                "working B " +
                "WHERE B.id_bakershop = A.id and A.like=1";
        Cursor cursor = newDb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            DataBakery data = new DataBakery();

            data.id = cursor.getInt(cursor.getColumnIndex("id"));
            data.name = cursor.getString(cursor.getColumnIndex("name"));
            data.address = cursor.getString(cursor.getColumnIndex("address"));
            data.phone = cursor.getString(cursor.getColumnIndex("phone"));
            data.baker = cursor.getString(cursor.getColumnIndex("baker"));
            data.like = cursor.getInt(cursor.getColumnIndex("like"));
            data.photo = cursor.getString(cursor.getColumnIndex("picture"));
            data.note = cursor.getString(cursor.getColumnIndex("note"));
            data.cooking = cursor.getString(cursor.getColumnIndex("cooking"));
            data.bread = cursor.getString(cursor.getColumnIndex("bread"));
            data.hour = cursor.getString(cursor.getColumnIndex("hour"));
            data.holiday = cursor.getString(cursor.getColumnIndex("holiday"));

            Data.add(data);
        }
        cursor.close();
        newDb.close();
        return Data;

    }


    public ArrayList<DataBakery> getAllOfRuning() {
        Data.clear();
        ArrayList<DataBakery> Data2 = new ArrayList<DataBakery>();
        openDatabase();
        String sql = "SELECT" +
                " A.id," +
                "A.name," +
                "A.address," +
                "A.phone," +
                "A.baker," +
                "A.like," +
                "A.note," +
                "A.picture," +
                "A.cooking," +
                "A.bread," +
                "B.hour," +
                "B.holiday" +
                " FROM " +
                "bakeshop A," +
                "working B " +
                "WHERE B.id_bakershop = A.id";
        Cursor cursor = newDb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            DataBakery data = new DataBakery();

            data.id = cursor.getInt(cursor.getColumnIndex("id"));
            data.name = cursor.getString(cursor.getColumnIndex("name"));
            data.address = cursor.getString(cursor.getColumnIndex("address"));
            data.phone = cursor.getString(cursor.getColumnIndex("phone"));
            data.baker = cursor.getString(cursor.getColumnIndex("baker"));
            data.like = cursor.getInt(cursor.getColumnIndex("like"));
            data.photo = cursor.getString(cursor.getColumnIndex("picture"));
            data.note = cursor.getString(cursor.getColumnIndex("note"));
            data.cooking = cursor.getString(cursor.getColumnIndex("cooking"));
            data.bread = cursor.getString(cursor.getColumnIndex("bread"));
            data.hour = cursor.getString(cursor.getColumnIndex("hour"));
            data.holiday = cursor.getString(cursor.getColumnIndex("holiday"));

            Data.add(data);
        }
        cursor.close();
        newDb.close();
        for (int i = 0; i <= Data.size() - 1; i++) {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            String[] array = Data.get(i).hour.split("-");
            String f1 = array[0].substring(0, 2);
            String f2 = array[0].substring(2, 4);
            String s1 = array[1].substring(0, 2);
            String s2 = array[1].substring(2, 4);
            if ((Integer.parseInt(f1) <= hour && hour <= Integer.parseInt(f2)) || (Integer.parseInt(s1) <= hour && hour <= Integer.parseInt(s2))) {
                Data2.add(Data.get(i));
            }
        }
        return Data2;

    }


    public void updateLike() {
        openDatabase();
        String sql = "update bakeshop set like='" + getLike() + "' where id='" + getId() + "'";
        newDb.execSQL(sql);
        newDb.close();

    }
}
