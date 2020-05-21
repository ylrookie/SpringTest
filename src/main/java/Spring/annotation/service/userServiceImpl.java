package Spring.annotation.service;

import Spring.annotation.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    /**
     *  @Autowired 完成bean属性的自动装配
     *
     *  工作机制:  首先会使用byType的方式进行自动装配，如果能唯一匹配，则装配成功，
     *           如果匹配到多个兼容类型的bean, 还会尝试使用byName的方式进行唯一确定.
     *           如果能唯一确定，则装配成功，如果不能唯一确定，则装配失败，抛出异常.
     *
     *  默认情况下， 使用@Autowired标注的属性必须被装配，如果装配不了，也会抛出异常.
     *  可以使用required=false来设置不是必须要被装配.
     *
     *  如果匹配到多个兼容类型的bean，可以使用@Qualifier来进一步指定要装配的bean的id值 。
     *
     *  @Autowired @Qualifier 注解即可加在成员变量上，也可以加在对应的set方法上..
     *
     */

    @Autowired
    @Qualifier("userDaoMybatisImpl")
    private userDao ud;

    /*@Autowired
    @Qualifier("userDaoMybatisImpl")
    public void setUd(userDao ud) {
        this.ud = ud;
    }*/

    @Override
    public void handleAddUser() {
        ud.addUser();
    }
}
