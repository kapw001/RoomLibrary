package roomlibrary.com.roomlibrary.repo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by yasar on 1/6/18.
 */

public class UserWithRepos {

    @Embedded
    public User user;

    @Relation(parentColumn = "id",
            entityColumn = "userId")
    public List<Repo> repoList;
}
