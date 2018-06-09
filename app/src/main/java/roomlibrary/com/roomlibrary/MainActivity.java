package roomlibrary.com.roomlibrary;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import roomlibrary.com.roomlibrary.repo.ProjectDao;
import roomlibrary.com.roomlibrary.repo.Repo;
import roomlibrary.com.roomlibrary.repo.RepoDao;
import roomlibrary.com.roomlibrary.repo.RepoDatabase;
import roomlibrary.com.roomlibrary.repo.User;
import roomlibrary.com.roomlibrary.repo.UserDao;
import roomlibrary.com.roomlibrary.repo.UserWithRepos;
import roomlibrary.com.roomlibrary.repo.UserWithReposDao;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "movies_db";

    private static final String TAG = "MainActivity";
    TestModelDatabase movieDatabase;

//    RepoDao repoDatabase;
//
//    UserDao userDao;
//
//    UserWithReposDao userWithReposDao;

    ProjectDao projectDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        movieDatabase = Room.databaseBuilder(getApplicationContext(),
                TestModelDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();


//        repoDatabase = RepoDatabase.getInstance(this).getRepoDao();
//        userDao = RepoDatabase.getInstance(this).getUserDao();
//        userWithReposDao = RepoDatabase.getInstance(this).getUserWithReposDao();

        projectDao = RepoDatabase.getInstance(this).getProjectDao();


        new Thread(new Runnable() {
            @Override
            public void run() {


                User user = new User(1, "login1", "");
                User user1 = new User(2, "login2", "");
                User user2 = new User(3, "login3", "");

                projectDao.insert(user, user1, user2);


                Repo repo = new Repo(0, "Test", "http://google.com", 1);
                Repo repo1 = new Repo(0, "Mani", "http://googlezxczxcxzczx.com", 2);
                Repo repo5 = new Repo(0, "Mani1", "http://googlezxczxcxzczx.com", 1);
                Repo repo6 = new Repo(0, "Mani2", "http://googlezxczxcxzczx.com", 3);

                projectDao.delete(repo, repo5);

                projectDao.insert(repo, repo1, repo5, repo6);


                projectDao.delete(repo6);
                projectDao.delete(user2);

                List<User> list = projectDao.getAllUser();

                for (User user3 : list
                        ) {

                    Log.e(TAG, "run: " + user3.login + "    " + user3.id + "  " + user3.avatarUrl);
                }


                List<Repo> list1 = projectDao.getAllRepos();

                for (Repo repo2 : list1
                        ) {

                    Log.e(TAG, "run: " + repo2.getName() + "    " + repo2.getUrl() + "  " + repo2.getId());
                }


                List<UserWithRepos> usersWithRepos = projectDao.getUsersWithRepos();

                for (UserWithRepos repos : usersWithRepos) {


                    Log.e(TAG, "run: userwith " + repos.repoList.size() + "   " + repos.user.id + "  " + repos.user.login);

                }


                UserWithRepos withRepos = projectDao.getUsersWithRepos(1);

                Log.e(TAG, "run: User id based  " + withRepos.user.login + "     " + withRepos.user.id);

                for (int i = 0; i < withRepos.repoList.size(); i++) {

                    Log.e(TAG, "run: ok testing " + withRepos.repoList.get(i).getName() + "  Id  " + withRepos.repoList.get(i).getId());

                }


            }
        }).start();


        Log.e(TAG, "onCreate: ---------------------------------------------------------------- ");

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                TestModelDao testModelDao = movieDatabase.daoAccess();
//
//                Book book = new Book();
//                book.id = 1;
//                book.testModelId = 12;
//                book.title = "Hello";
//                book.ISBN = 333;
//
//                Book book1 = new Book();
//                book1.id = 8;
//                book1.testModelId = 12;
//                book1.title = "Rooow";
//                book1.ISBN = 222;
//
//
//                TestModel testModel = new TestModel();
//
//                testModel.id =12;
//                testModel.name = "zx<x<zx<z";
//
//                testModelDao.insertTestModel(testModel);
//                testModelDao.insertBook(book);
//                testModelDao.insertBook(book1);
//
//
//                TestModelWithBooks books = testModelDao.loadTestModelWithBooks();
//
//                TestModel testModel1 = books.getTestModel();
//
//                Log.e(TAG, "run: " + testModel1.getName());
//
//                List<Book> bookList = books.books;
//
//                for (Book book2 : bookList
//                        ) {
//
//
//                    Log.e(TAG, "onCreate: values title " + book2.title);
//
//                }
//
//
//            }
//        }).start();


    }
}
