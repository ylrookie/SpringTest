package Spring.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class userDaoImpl implements userDao {

    @Override
    public void addUser() {
        System.out.println("userDao JDBC impl..");
    }
}
