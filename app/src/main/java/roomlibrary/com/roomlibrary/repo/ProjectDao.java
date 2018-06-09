package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Dao;

/**
 * Created by yasar on 1/6/18.
 */
@Dao
public interface ProjectDao extends UserDao, RepoDao, UserWithReposDao {
}
