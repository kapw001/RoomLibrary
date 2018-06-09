package roomlibrary.com.roomlibrary;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by yasar on 31/5/18.
 */

public class TestModelWithBooks {

    @Embedded
    public TestModel testModel;


    @Relation(parentColumn = "id", entityColumn = "testModelId", entity = Book.class)
    public List<Book> books;

    public TestModel getTestModel() {
        return testModel;
    }

    public void setTestModel(TestModel testModel) {
        this.testModel = testModel;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
