package id.hnslabs.jadwalku;

/**
 * Created by HaidarNS on 13/01/2015.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by HaidarNS on 02/01/2015.
 */

public class DBCenter extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "jadkul";
    private static final int DATABASE_VERSION = 1;

    public static final String TBL_JK = "jadkul";
    public static final String COL_ID = "id";
    public static final String COL_HARI = "hari";
    public static final String COL_MATKUL = "matkul";
    public static final String COL_JAM1 = "jam1";
    public static final String COL_JAM2 = "jam2";
    public static final String COL_RUANG = "ruang";
    public static final String COL_DOSEN = "dosen";

    SQLiteDatabase db;

    public DBCenter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        // Create Table
        db.execSQL("CREATE TABLE "+
                TBL_JK+" ("+
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_HARI+" TEXT, "+
                COL_MATKUL+" TEXT, "+
                COL_JAM1+" TEXT, "+
                COL_JAM2+" TEXT, "+
                COL_RUANG+" TEXT,"+
                COL_DOSEN+" TEXT)");
    }

    public void open() throws SQLiteException{
        try{
            db = getWritableDatabase();
        }
        catch (SQLiteException e){
            db = getReadableDatabase();
        }
    }

    public long addJadkul(ContentValues values) {
        // TODO Auto-generated method stub
        open();

        try {

            long rows = db.insert("jadkul", null, values);

            Log.i("addJadKul","sukses");

            db.close();

            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }
    }


    // Select Data
    public Cursor JadHari(String sHari) {
        // TODO Auto-generated method stub
        try {
            db = this.getReadableDatabase(); // Read Data
            Cursor cursor = db.query(
                    TBL_JK,
                    new String[] { "id AS _id, *" },
                    COL_HARI+" = "+sHari,
                    null, null, null, null);

            if(cursor != null)
            { return cursor; }
            else
            { return null; }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS "+TBL_JK);

        // Re Create on method  onCreate
        onCreate(db);
    }
}
