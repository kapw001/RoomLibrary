package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

/**
 * Created by yasar on 1/6/18.
 */

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE), indices = {@Index(value =
        {"name"}, unique = true)})
public class Repo {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    public final String name;
    public final String url;
    public final int userId;

    public Repo(final int id, String name, String url,
                final int userId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getUserId() {
        return userId;
    }
}
