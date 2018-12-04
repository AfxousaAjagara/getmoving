package com.example.dlfan.project_getmoving;

import android.provider.BaseColumns;

public final class VaultContract {
    public static final String DB_NAME = "vault.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private VaultContract(){}

    //데이터 테이블 내용을 결정할 내부클래스
    public static class Vault implements BaseColumns{
        public static final String TABLE_NAME = "Vaults";
        public static final String KEY_NAME = "Name";
        public static final String KEY_SOURCE = "Source";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                                                    _ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                                                    KEY_NAME + TEXT_TYPE + COMMA_SEP +
                                                    KEY_SOURCE + TEXT_TYPE + " )";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
