package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by yasar on 1/6/18.
 */

@Database(entities = {User.class, Repo.class}, version = 5)
public abstract class RepoDatabase extends RoomDatabase {


    private static final String DB_NAME = "repoDatabase.db";
    private static volatile RepoDatabase instance;

    public static synchronized RepoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static RepoDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                RepoDatabase.class,
                DB_NAME).fallbackToDestructiveMigration().build();
    }

    public abstract RepoDao getRepoDao();

    public abstract UserDao getUserDao();

    public abstract UserWithReposDao getUserWithReposDao();

    public abstract ProjectDao getProjectDao();

}
