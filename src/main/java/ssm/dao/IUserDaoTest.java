package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.model.User;

import java.util.List;
// 加载spring配置文件

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private IUserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = dao.selectUser(id);
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getId());
        System.out.println(user.getStatus());
        List<User> list = dao.selectUserList();
        for ( int i = 0 ; i < list.size() ; ++i ) {
            System.out.println(list.get(i).getId());
        }

    }

}
