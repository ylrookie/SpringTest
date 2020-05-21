package Spring.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class userDaoMybatisImpl implements userDao {
    @Override
    public void addUser() {
        System.out.println("UserDao mybatis Impl...");
    }
}
