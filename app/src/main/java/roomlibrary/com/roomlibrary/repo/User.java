package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by yasar on 1/6/18.
 */

@Entity
public class User {

    @PrimaryKey
    public final int id;
    public final String login;
    public final String avatarUrl;

    public User(int id, String login, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }
}
