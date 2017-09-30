package ssm.dao;


import ssm.model.User;

import java.util.List;

public interface IUserDao {

    User selectUser(long id);
    List<User> selectUserList();

}

