package roomlibrary.com.roomlibrary;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by yasar on 31/5/18.
 */

@Entity
public class Book {
    @PrimaryKey
    public int id;
    public int testModelId;
    public String title;
    public int ISBN;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestModelId() {
        return testModelId;
    }

    public void setTestModelId(int testModelId) {
        this.testModelId = testModelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
