package com.example.dlfan.project_getmoving;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    final  static String TAG = "SQLiteDBTest";

    public DBHelper(Context context){
        super(context, VaultContract.DB_NAME, null, VaultContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.i(TAG, getClass().getName()+".onCreate()");
        db.execSQL(VaultContract.Vault.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        Log.i(TAG,getClass().getName()+".onUpgrade()");
        db.execSQL(VaultContract.Vault.DELETE_TABLE);
        onCreate(db);
    }

    public void insertUsersBySQL(String name, String source){
        try{
            String sql = String.format(
                    "INSERT INTO %s (%s, %s, %s) VALUES (NULL, '%s', '%s')",
                    VaultContract.Vault.TABLE_NAME,
                    VaultContract.Vault._ID,
                    VaultContract.Vault.KEY_NAME,
                    VaultContract.Vault.KEY_SOURCE,
                    name,
                    source);

            getWritableDatabase().execSQL(sql);
        } catch (SQLException e){
            Log.e(TAG,"Error in inserting recodes");
        }
    }

    public Cursor getAllUsersBySQL(){
        String sql = "SELECT * FROM " + VaultContract.Vault.TABLE_NAME;
        return getReadableDatabase().rawQuery(sql,null);
    }

    public void deleteUserBySQL(String _id) {
        try {
            String sql = String.format (
                    "DELETE FROM %s WHERE %s = %s",
                    VaultContract.Vault.TABLE_NAME,
                    VaultContract.Vault._ID,
                    _id);
            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG,"Error in deleting recodes");
        }
    }

    public void updateUserBySQL(String _id, String name, String phone) {
        try {
            String sql = String.format (
                    "UPDATE  %s SET %s = '%s', %s = '%s' WHERE %s = %s",
                    VaultContract.Vault.TABLE_NAME,
                    VaultContract.Vault.KEY_NAME, name,
                    VaultContract.Vault.KEY_SOURCE, phone,
                    VaultContract.Vault._ID, _id) ;
            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG,"Error in updating recodes");
        }
    }

    public long insertUserByMethod(String name, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(VaultContract.Vault.KEY_NAME, name);
        values.put(VaultContract.Vault.KEY_SOURCE,phone);

        return db.insert(VaultContract.Vault.TABLE_NAME,null,values);
    }

    public Cursor getAllUsersByMethod() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(VaultContract.Vault.TABLE_NAME,null,null,null,null,null,null);
    }

    public long deleteUserByMethod(String _id) {
        SQLiteDatabase db = getWritableDatabase();

        String whereClause = VaultContract.Vault._ID +" = ?";
        String[] whereArgs ={_id};
        return db.delete(VaultContract.Vault.TABLE_NAME, whereClause, whereArgs);
    }

    public long updateUserByMethod(String _id, String name, String phone) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VaultContract.Vault.KEY_NAME, name);
        values.put(VaultContract.Vault.KEY_SOURCE,phone);

        String whereClause = VaultContract.Vault._ID +" = ?";
        String[] whereArgs ={_id};

        return db.update(VaultContract.Vault.TABLE_NAME, values, whereClause, whereArgs);
    }
}
