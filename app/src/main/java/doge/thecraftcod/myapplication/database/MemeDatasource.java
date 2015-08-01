package doge.thecraftcod.myapplication.database;

import android.content.Context;

/**
 * Created by Gerardo
 */
public class MemeDatasource {

    private Context mContext;
    private MemeSQLiteHelper mMemeSqlLiteHelper;

    public MemeDatasource(Context context) {
        mContext = context;
        mMemeSqlLiteHelper = new MemeSQLiteHelper(context);
    }
}
