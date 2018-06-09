package roomlibrary.com.roomlibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by yasar on 31/5/18.
 */

@Dao
public interface TestModelDao {


    @Insert
    void insertBook(Book book);

    @Insert
    void insertTestModel(TestModel testModel);

    @Query("SELECT * FROM TestModel")
    public TestModelWithBooks loadTestModelWithBooks();

}
