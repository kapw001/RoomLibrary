package roomlibrary.com.roomlibrary;


import android.arch.persistence.room.Database;

import android.arch.persistence.room.RoomDatabase;
/**
 * Created by yasar on 31/5/18.
 */


@Database(entities = {Book.class, TestModel.class}, version = 1, exportSchema = false)
public abstract class TestModelDatabase extends RoomDatabase {


    public abstract TestModelDao daoAccess();
}
