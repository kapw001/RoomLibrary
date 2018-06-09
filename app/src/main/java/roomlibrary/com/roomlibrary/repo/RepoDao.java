package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;


/**
 * Created by yasar on 1/6/18.
 */

@Dao
public interface RepoDao {


//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insert(User... users);

    @Query("SELECT * FROM repo")
    List<Repo> getAllRepos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Repo... repos);

    @Update
    void update(Repo... repos);

    @Delete
    void delete(Repo... repos);

    @Query("DELETE FROM repo where userId=:id")
    void deleteUser(final int id);

    @Query("SELECT * FROM repo WHERE id=:id")
    Repo getRepo(int id);

    @Query("SELECT * FROM repo WHERE name=:name")
    List<Repo> getReposByName(String name);

    @Query("SELECT * FROM repo")
    Cursor getRepoCursor();

    @Query("SELECT * FROM repo WHERE userId=:userId")
    List<Repo> findRepositoriesForUser(final int userId);
}
