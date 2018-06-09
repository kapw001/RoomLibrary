package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by yasar on 1/6/18.
 */

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Update
    void update(User... user);

    @Delete
    void delete(User... user);

    @Query("select * from user")
    List<User> getAllUser();
}
