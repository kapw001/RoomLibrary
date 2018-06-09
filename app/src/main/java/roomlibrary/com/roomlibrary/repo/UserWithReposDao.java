package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by yasar on 1/6/18.
 */
@Dao
public interface UserWithReposDao {

    @Query("SELECT * from user")
    public List<UserWithRepos> getUsersWithRepos();


    @Query("SELECT * from user where id=:id")
    public UserWithRepos getUsersWithRepos(final int id);

}

