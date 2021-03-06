package sqlite.unipac.com.br.aulasqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "books.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE books ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, "+
                "author TEXT )";

        // create books table
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");

        // create fresh books table
        this.onCreate(db);
    }

    public SQLiteDatabase openDatabase() {
        return this.getWritableDatabase();
    }
}
